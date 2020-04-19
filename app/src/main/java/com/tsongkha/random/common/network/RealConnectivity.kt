package com.tsongkha.random.common.network

import android.net.ConnectivityManager
import android.net.NetworkInfo
import toothpick.InjectConstructor

@InjectConstructor
class RealConnectivity(private val connectivityManager: ConnectivityManager) : Connectivity {

    override fun isConnected(): Boolean {
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }
}