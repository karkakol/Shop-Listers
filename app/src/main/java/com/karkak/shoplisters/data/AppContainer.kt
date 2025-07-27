package com.karkak.shoplisters.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer

class AppDataContainer(private val context: Context) : AppContainer
