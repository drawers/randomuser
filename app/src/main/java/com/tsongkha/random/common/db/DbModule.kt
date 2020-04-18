package com.tsongkha.random.base.db

import toothpick.ktp.binding.module

import toothpick.ktp.binding.bind

val dbModule = module {
    bind<UserDatabase>().toProvider(DbProvider::class)
}