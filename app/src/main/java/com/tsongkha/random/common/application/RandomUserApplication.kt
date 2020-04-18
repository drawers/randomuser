package com.tsongkha.random.base.application

import android.app.Application
import android.content.Context
import com.tsongkha.random.base.db.dbModule
import com.tsongkha.random.base.network.networkModule
import toothpick.Scope
import toothpick.ktp.KTP
import toothpick.ktp.binding.bind
import toothpick.ktp.binding.module

class RandomUserApplication : Application() {

    lateinit var scope: Scope

    override fun onCreate() {
        super.onCreate()

        scope = KTP.openScope(ApplicationScope::class.java)
            .installModules(
                module {
                    bind<Application>().toInstance { this@RandomUserApplication }
                    bind<Context>().withName(APPLICATION).toInstance { this@RandomUserApplication }
                },
                networkModule,
                dbModule
            )
    }
}