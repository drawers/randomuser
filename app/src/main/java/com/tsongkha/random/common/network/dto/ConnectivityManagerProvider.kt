package com.tsongkha.random.common.network.dto

import android.content.Context
import android.net.ConnectivityManager
import com.tsongkha.random.common.application.APPLICATION
import toothpick.InjectConstructor
import javax.inject.Named
import javax.inject.Provider

@InjectConstructor
class ConnectivityManagerProvider(@Named(APPLICATION) private val context: Context) : Provider<ConnectivityManager> {

    override fun get(): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}