package com.tsongkha.random.feature.list.paging

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
            // max results divided by page number rounding up with integer division

            val sum = maxResults + pageSize - 1

            // check for integer overflow
            check(sum > maxResults)
            check(sum > pageSize)

            return sum / pageSize
        }

    /**
     * Generates an id based on the current page and the position inside the result set
     */
    fun id(currentPage: Int, indexFromZero: Int): Int {
        require(0 < currentPage) { "Expected current page $currentPage to be a positive integer - pages indexed from 1" }
        return (currentPage - 1) * pageSize + indexFromZero + 1
    }

    /**
     * gives a range of upper and lower ids for a given page
     */
    fun idsForPage(currentPage: Int): IntRange {
        require(initialPage <= currentPage)
        require(currentPage <= totalPages)

        val start = (currentPage - 1) * pageSize + 1
        val endInclusive = start + pageSize - 1

        return IntRange(start = start, endInclusive = endInclusive)
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