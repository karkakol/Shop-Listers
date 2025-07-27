package com.karkak.shoplisters.data

import android.content.Context
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

/**
 * App container for Dependency injection.
 */
interface AppContainer{
    val shoppingListsRepository: ShoppingListsRepository
}

class AppDataContainer(private val context: Context) : AppContainer{
    override val shoppingListsRepository: ShoppingListsRepository by lazy{
        FirebaseShoppingListsRepository(Firebase.firestore)
    }
}
