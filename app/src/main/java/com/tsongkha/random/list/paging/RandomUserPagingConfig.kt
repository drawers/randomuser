package com.tsongkha.random.list.paging

data class RandomUserPagingConfig(
    val maxResults: Int,
    val pageSize: Int,
    val initialPage: Int,
    val seed: String
) {

    val totalPages: Int = maxResults / pageSize

    fun nextPage(currentPage: Int): Int? = (currentPage + 1).takeIf { it < totalPages }

    fun previousPage(currentPage: Int): Int? = (currentPage - 1).takeUnless { it <= 0 }
}