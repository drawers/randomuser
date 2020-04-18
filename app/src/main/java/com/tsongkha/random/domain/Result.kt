package com.tsongkha.random.domain

data class Result(
    val results: List<User>,
    val info: Info
)

class Info(
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String
)