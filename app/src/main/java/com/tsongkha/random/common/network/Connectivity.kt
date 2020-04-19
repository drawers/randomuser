package com.tsongkha.random.common.network

import android.net.ConnectivityManager
import android.net.NetworkInfo
import toothpick.InjectConstructor

@InjectConstructor
open class Connectivity(private val connectivityManager: ConnectivityManager) {

    open fun isConnected(): Boolean {
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }
}