package com.android.pokekmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform