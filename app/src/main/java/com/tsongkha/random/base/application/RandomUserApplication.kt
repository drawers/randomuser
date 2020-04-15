package com.tsongkha.random.base.application

import android.app.Application
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
                }
            )
    }
}