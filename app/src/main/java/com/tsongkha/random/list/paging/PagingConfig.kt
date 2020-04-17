package com.tsongkha.random.list.paging

data class PagingConfig(
    val maxResults: Int,
    val pageSize: Int,
    val initialPage: Int,
    val seed: String
) {

    val totalPages: Int = maxResults / pageSize

    /**
     * Generates an id based on the current page and the position inside the result set
     */
    fun id(currentPage: Int, indexFromZero: Int) = (currentPage - 1) * pageSize + indexFromZero

    /**
     * Next page or null if no more data to load
     */
    fun nextPage(currentPage: Int): Int? = (currentPage + 1).takeIf { it <= totalPages }

    /**
     * Previous page or null if no previous data
     */
    fun previousPage(currentPage: Int): Int? = (currentPage - 1).takeUnless { it < 0 }
}