package com.tsongkha.random.common.data.source

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.tsongkha.random.common.db.FakeUserDao
import com.tsongkha.random.common.domain.DtoConverter
import com.tsongkha.random.common.domain.UserDataSource
import com.tsongkha.random.common.network.Connectivity
import com.tsongkha.random.common.network.UserService
import com.tsongkha.random.feature.list.paging.Paging
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.Date

class UserDataSourceTest {

    private lateinit var userDataSource: UserDataSource

    @Mock
    private lateinit var connectivity: Connectivity

    private val mockWebServer: MockWebServer = MockWebServer()

    private lateinit var mockHttp: OkHttpClient

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        val retrofit = Retrofit.Builder().baseUrl("https://mock").addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().add(
                    Date::class.java,
                    Rfc3339DateJsonAdapter().nullSafe()
                ).build()
            )
        ).build()

        val paging = Paging(
            maxResults = 200,
            pageSize = 50,
            initialPage = 1,
            seed = "abc"
        )

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
    }
}