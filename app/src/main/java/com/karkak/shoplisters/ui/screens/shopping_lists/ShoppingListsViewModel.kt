package com.karkak.shoplisters.ui.screens.shopping_lists

import androidx.lifecycle.ViewModel
import com.karkak.shoplisters.model.ShoppingList

class ShoppingListsViewModel : ViewModel() {
    val uiState = ShoppingListsUiState()
}

data class ShoppingListsUiState(
    val lists: List<ShoppingList> = ShoppingList.MOCKS
)