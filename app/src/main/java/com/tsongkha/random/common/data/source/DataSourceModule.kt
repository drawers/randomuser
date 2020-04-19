package com.tsongkha.random.common.data.source

import toothpick.ktp.binding.bind
import toothpick.ktp.binding.module

val dataSourceModule = module {
    bind<UserDataSource>().toProvider(UserDataSourceProvider::class)
    bind<UserDataSource>().withName(REMOTE).toClass<RemoteUserDataSource>()
    bind<UserDataSource>().withName(REMOTE_PERSISTING).toClass<PersistingUserDataSource>()
    bind<UserDataSource>().withName(OFFLINE).toClass<OfflineUserDataSource>()
}