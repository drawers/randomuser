package com.tsongkha.random.common.network

class FakeConnectivity : Connectivity {

    var value: Boolean = true

    override fun isConnected(): Boolean {
        return value
    }
}