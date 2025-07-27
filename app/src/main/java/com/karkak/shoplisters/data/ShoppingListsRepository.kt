package com.karkak.shoplisters.data

import com.karkak.shoplisters.model.ShoppingList
import kotlinx.coroutines.flow.Flow

interface ShoppingListsRepository {

    fun getAllShoppingListsStream(): Flow<List<ShoppingList>>

    fun insertList(list: ShoppingList)
    fun updateList(list: ShoppingList)
    fun deleteList(list: ShoppingList)
}