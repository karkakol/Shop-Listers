package com.karkak.shoplisters.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.karkak.shoplisters.ShopListersApplication
import com.karkak.shoplisters.ui.screens.shopping_lists.ShoppingListsViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            ShoppingListsViewModel()
        }

    }
}

fun CreationExtras.inventoryApplication(): ShopListersApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as ShopListersApplication)
