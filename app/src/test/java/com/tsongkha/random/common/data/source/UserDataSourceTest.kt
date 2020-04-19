package com.tsongkha.random.common.data.source

import com.nhaarman.mockitokotlin2.whenever
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.tsongkha.random.common.db.FakeUserDao
import com.tsongkha.random.common.domain.DtoConverter
import com.tsongkha.random.common.domain.Location
import com.tsongkha.random.common.domain.Name
import com.tsongkha.random.common.domain.Phone
import com.tsongkha.random.common.domain.Picture
import com.tsongkha.random.common.domain.Street
import com.tsongkha.random.common.domain.User
import com.tsongkha.random.common.domain.UserDataSource
import com.tsongkha.random.common.network.Connectivity
import com.tsongkha.random.common.network.UserService
import com.tsongkha.random.feature.list.paging.Paging
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.time.Instant
import java.util.Date

class UserDataSourceTest {

    private lateinit var userDataSource: UserDataSource

    @Mock
    private lateinit var connectivity: Connectivity

    private lateinit var mockWebServer: MockWebServer

    private val page1: String by lazy {
        File("src/test/java/com/tsongkha/random/common/data/source/page1.json").readText()
    }

    private val page2: String by lazy {
        File("page2.json").readText()
    }

    private val page3: String by lazy {
        File("page3.json").readText()
    }

    private val page4: String by lazy {
        File("page4.json").readText()
    }

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        val paging = Paging(
            maxResults = 200,
            pageSize = 50,
            initialPage = 1,
            seed = "abc"
        )

        mockWebServer = MockWebServer()
        mockWebServer.start()
        val baseUrl = mockWebServer.url("")

        val retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().add(
                    Date::class.java,
                    Rfc3339DateJsonAdapter().nullSafe()
                ).build()
            )
        ).build()

        userDataSource = NaiveSwitchingUserDataSource(
            connectivity,
            remoteUserDataSource = RemoteUserDataSource(
                userService = retrofit.create(UserService::class.java),
                dtoConverter = DtoConverter(paging)
            ),
            offlineUserDataSource = OfflineUserDataSource(
                userDao = FakeUserDao(),
                paging = paging
            )
        )

        val dispatcher = object : Dispatcher() {

            override fun dispatch(request: RecordedRequest): MockResponse {
                when {
                    request.path?.contains("page=1") == true -> {
                        return MockResponse().setResponseCode(200).setBody(page1)
                    }
                    request.path?.contains("page=2") == true -> {
                        return MockResponse().setResponseCode(200).setBody(page2)
                    }
                    request.path?.contains("page=3") == true -> {
                        return MockResponse().setResponseCode(200).setBody(page3)
                    }
                    request.path?.contains("page=4") == true -> {
                        return MockResponse().setResponseCode(200).setBody(page4)
                    }
                    else -> {
                        throw IllegalStateException("Unexpected request")
                    }
                }
            }
        }
        mockWebServer.dispatcher = dispatcher
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `request from API honored when connected`() {
        whenever(connectivity.isConnected()).thenReturn(true)

        val result = runBlocking {
            userDataSource.users(
                page = 1,
                seed = "abc",
                results = 50,
                exclude = "registered",
                include = null
            )
        }

        assertEquals(FIRST_USER, result.results.first())
    }

    val FIRST_USER = User(
        1,
        "female",
        Name("Miss", "Louane", "Vidal"),
        Location(
            street = Street(
                number = 2479,
                name = "Place du 8 Février 1962"
            ),
            city = "Avignon",
            state = "Vendée",
            country = "France",
            postcode = "78276"
        ),
        email = "louane.vidal@example.com",
        uuid = "9f07341f-c7e6-45b7-bab0-af6de5a4582d",
        dob = Date.from(Instant.parse("1966-06-26T11:50:25.558Z")),
        phone = Phone(
            home = "02-62-35-18-98",
            cell = "06-07-80-83-11"
        ),
        picture = Picture(
            large = "https://randomuser.me/api/portraits/women/88.jpg",
            thumbnail = "https://randomuser.me/api/portraits/thumb/women/88.jpg"
        ),
        nat = "FR"
    )
}