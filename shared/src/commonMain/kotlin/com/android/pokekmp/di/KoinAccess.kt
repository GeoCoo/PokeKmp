package com.android.pokekmp.di

import org.koin.core.context.GlobalContext
import org.koin.core.Koin

fun getKoin(): Koin = GlobalContext.get()