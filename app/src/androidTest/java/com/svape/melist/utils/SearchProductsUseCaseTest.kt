package com.svape.melist.utils

import com.svape.melist.util.isSearchQueryValid
import org.junit.Assert.*
import org.junit.Test

class SearchValidatorTest {

    @Test
    fun queryShorterThanThreeIsInvalid() {
        val result = isSearchQueryValid("ok")
        assertFalse(result)
    }

    @Test
    fun queryWithSpacesIsTrimmedAndValidated() {
        val result = isSearchQueryValid("  iphone  ")
        assertTrue(result)
    }

    @Test
    fun emptyQueryIsInvalid() {
        val result = isSearchQueryValid("  ")
        assertFalse(result)
    }
}
