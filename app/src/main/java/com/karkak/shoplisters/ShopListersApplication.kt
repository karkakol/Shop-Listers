package com.karkak.shoplisters

import android.app.Application
import com.karkak.shoplisters.data.AppContainer
import com.karkak.shoplisters.data.AppDataContainer

class ShopListersApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
