package com.tsongkha.random.common.data.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Info(
	val seed : String,
	val results : Int,
	val page : Int,
	val version : String
)