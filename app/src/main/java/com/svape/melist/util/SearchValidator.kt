package com.svape.melist.util

fun isSearchQueryValid(query: String): Boolean {
    return query.trim().length >= 3
}
