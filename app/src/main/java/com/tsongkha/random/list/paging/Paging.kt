package com.tsongkha.random.list.paging

data class Paging(
    val maxResults: Int,
    val pageSize: Int,
    val initialPage: Int,
    val seed: String
) {

    init {
        require(maxResults > 0)
        require(pageSize > 0)
        require(initialPage > 0)
    }

    // source: https://stackoverflow.com/a/17974
    val totalPages: Int
        get() {
            val sum = maxResults + pageSize - 1

            // check for integer overflow
            check(sum > maxResults)
            check(sum > pageSize)

            return (maxResults + pageSize - 1) / pageSize
        }

    /**
     * Generates an id based on the current page and the position inside the result set
     */
    fun id(currentPage: Int, indexFromZero: Int): Int {
        require(0 < currentPage) { "Expected current page $currentPage to be a positive integer - pages indexed from 1" }
        return (currentPage - 1) * pageSize + indexFromZero
    }

    /**
     * Next page or null if no more data to load
     */
    fun nextPage(currentPage: Int): Int? {
        require(currentPage <= totalPages) { "Expected current page $currentPage to be within total number of pages" }
        return (currentPage + 1).takeIf { it <= totalPages }
    }

    /**
     * Previous page or null if no previous data
     */
    fun previousPage(currentPage: Int): Int? {
        require(initialPage <= currentPage) { "Expected current page $currentPage to never go below initial page $initialPage" }
        return (currentPage - 1).takeUnless { it <= 0 }
    }
}