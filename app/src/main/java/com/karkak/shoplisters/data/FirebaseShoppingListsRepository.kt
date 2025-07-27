package com.karkak.shoplisters.data

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.dataObjects
import com.karkak.shoplisters.model.ShoppingList
import kotlinx.coroutines.flow.Flow

class FirebaseShoppingListsRepository(firestore: FirebaseFirestore): ShoppingListsRepository {
    private val shoppingListCollection = firestore.collection(SHOPPING_LISTS_COLLECTION)

    override fun getAllShoppingListsStream(): Flow<List<ShoppingList>> {
        return shoppingListCollection.dataObjects()
    }

    override fun insertList(list: ShoppingList) {
        shoppingListCollection.add(list)
    }

    override fun updateList(list: ShoppingList) {
        shoppingListCollection.document(list.id).set(list)
    }

    override fun deleteList(list: ShoppingList) {
        shoppingListCollection.document(list.id).delete()
    }

    companion object{
        private const val SHOPPING_LISTS_COLLECTION = "shoppingLists"
    }
}