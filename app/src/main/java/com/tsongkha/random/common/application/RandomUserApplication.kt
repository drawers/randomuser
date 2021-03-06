package com.tsongkha.random.common.application

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import com.tsongkha.random.common.data.source.dataSourceModule
import com.tsongkha.random.common.data.db.dbModule
import com.tsongkha.random.common.data.network.networkModule
import toothpick.Scope
import toothpick.ktp.KTP
import toothpick.ktp.binding.bind
import toothpick.ktp.binding.module

class RandomUserApplication : Application() {

    lateinit var scope: Scope

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)

        scope = KTP.openScope(ApplicationScope::class.java)
            .installModules(
                module {
                    bind<Application>().toInstance { this@RandomUserApplication }
                    bind<Context>().withName(APPLICATION).toInstance { this@RandomUserApplication }
                },
                networkModule,
                dbModule,
                dataSourceModule
            )
    }
}