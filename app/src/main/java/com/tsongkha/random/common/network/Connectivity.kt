package com.tsongkha.random.common.network

interface Connectivity {
    open fun isConnected(): Boolean
}