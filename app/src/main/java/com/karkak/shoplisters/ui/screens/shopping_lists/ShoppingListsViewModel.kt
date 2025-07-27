package com.karkak.shoplisters.ui.screens.shopping_lists

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karkak.shoplisters.data.ShoppingListsRepository
import com.karkak.shoplisters.model.ShoppingList
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ShoppingListsViewModel(private val listsRepository: ShoppingListsRepository) : ViewModel() {
    val uiState: StateFlow<ShoppingListsUiState> = listsRepository.getAllShoppingListsStream()
        .map {
            Log.i("TTT", "${it.size}")
            ShoppingListsUiState(it, ShoppingListsUiState.LoadingState.READY) }.catch {
            Log.i("TTT", "${it}")

            ShoppingListsUiState(listOf(), ShoppingListsUiState.LoadingState.FAILED)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = ShoppingListsUiState(
                listOf(), ShoppingListsUiState.LoadingState.LOADING
            ),
        )

    fun onCreateListButtonTapped() {
        listsRepository.insertList(ShoppingList.MOCKS.random())
    }
}

data class ShoppingListsUiState(
    val lists: List<ShoppingList> = ShoppingList.MOCKS, val loadingState: LoadingState
) {

    enum class LoadingState {
        LOADING, FAILED, READY
    }
}



