package com.tsongkha.random.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tsongkha.random.R
import com.tsongkha.random.base.application.ApplicationScope
import com.tsongkha.random.base.network.UserService
import toothpick.ktp.KTP
import javax.inject.Inject

class ListActivity : AppCompatActivity() {

    @Inject
    lateinit var userService: UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        KTP.openScopes(ApplicationScope::class.java)
            .inject(this)
    }
}