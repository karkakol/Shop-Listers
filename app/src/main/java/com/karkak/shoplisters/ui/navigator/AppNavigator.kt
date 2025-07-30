package com.karkak.shoplisters.ui.navigator

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.karkak.shoplisters.ui.screens.shopping_list.ShoppingListScreen
import com.karkak.shoplisters.ui.screens.shopping_lists.ShoppingListsScreen
import kotlinx.serialization.Serializable


sealed class AppRoutes : NavKey

@Serializable
data object ShoppingLists : AppRoutes()

@Serializable
data object ShoppingList : AppRoutes()

@Composable
fun AppNavigator(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(ShoppingLists)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<ShoppingLists> {
                ShoppingListsScreen(navigateToShoppingList = {
                    backStack.add(
                        ShoppingList
                    )
                })
            }
            entry<ShoppingList> {
                ShoppingListScreen(navigateBack = { backStack.removeLastOrNull() })
            }
        }
    )
}