package com.tsongkha.random.common.network

import android.net.ConnectivityManager
import android.net.NetworkInfo
import toothpick.InjectConstructor

@InjectConstructor
class Connectivity(private val connectivityManager: ConnectivityManager) {

    fun isConnected(): Boolean {
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }
}