package com.tsongkha.random.list.paging

import org.junit.Assert.*
import org.junit.Test

class PagingTest {

    @Test
    fun `next page on last page returns null`() {
        val paging = Paging(
            200,
            50,
            1,
            "abc"
        )

        assertEquals(null, paging.nextPage(4))
    }

    @Test
    fun `next page on other page returns page + 1`() {
        val paging = Paging(
            200,
            50,
            1,
            "abc"
        )

        assertEquals(4, paging.nextPage(3))
    }

    @Test
    fun `previous page on first page returns null`() {
        val paging = Paging(
            200,
            50,
            1,
            "abc"
        )

        assertEquals(null, paging.previousPage(1))
    }

    @Test
    fun `previous page on other page returns page - 1`() {
        val paging = Paging(
            200,
            50,
            1,
            "abc"
        )

        assertEquals(1, paging.previousPage(2))
    }


    @Test
    fun `total pages correct`() {
        val paging = Paging(
            200,
            50,
            1,
            "abc"
        )

        assertEquals(4, paging.totalPages)
    }
}