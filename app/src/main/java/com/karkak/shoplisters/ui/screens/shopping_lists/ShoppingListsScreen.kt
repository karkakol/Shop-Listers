package com.karkak.shoplisters.ui.screens.shopping_lists

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.karkak.shoplisters.R
import com.karkak.shoplisters.model.ShoppingList
import com.karkak.shoplisters.ui.AppViewModelProvider
import com.karkak.shoplisters.ui.common.CommonTopAppBar
import androidx.lifecycle.viewmodel.compose.viewModel



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListsScreen(
    modifier: Modifier = Modifier,
    viewModel: ShoppingListsViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val state = viewModel.uiState
    Scaffold(modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection), topBar = {
        CommonTopAppBar(title = "Your shopping lists", scrollBehavior = scrollBehavior)
    }, floatingActionButton = {
        FloatingActionButton(
            onClick = { },
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_large)),

            ) {
            Icon(
                imageVector = Icons.Filled.AddShoppingCart,
                contentDescription = "Create shopping list"
            )
        }
    }) { innerPadding ->
        ShoppingListsContent(state.lists, Modifier.padding(innerPadding))
    }
}


@Composable
fun ShoppingListsContent(shoppingLists: List<ShoppingList>, modifier: Modifier = Modifier) {
    LazyColumn(modifier.fillMaxWidth()) {
        items(items = shoppingLists, key = { it.id }) { shoppingList ->
            ShoppingListsListTile(
                shoppingList, Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
        items(items = shoppingLists, key = { it.id + it.id }) { shoppingList ->
            ShoppingListsListTile(
                shoppingList, Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
}


@Composable
fun ShoppingListsListTile(list: ShoppingList, modifier: Modifier = Modifier) {
    Card(
        modifier
            .padding(horizontal = dimensionResource(R.dimen.padding_extra_small))
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "",
            )
            Spacer(Modifier.width(dimensionResource(R.dimen.padding_medium)))
            Column {
                Text(list.name, style = MaterialTheme.typography.titleMedium)
                Text(
                    "Items left: ${list.items.size - list.items.count { it.complete }}",
                    style = MaterialTheme.typography.labelMedium
                )
            }
            Spacer(Modifier.weight(1.0F))
            Checkbox(checked = list.complete, onCheckedChange = {})
        }
    }
}

@Preview
@Composable
fun ShoppingListsScreenPreview() {
    ShoppingListsScreen()
}

@Preview
@Composable
fun ShoppingListsContentPreview() {
    val shoppingLists = ShoppingList.MOCKS
    ShoppingListsContent(shoppingLists)
}

@Preview
@Composable
fun ShoppingListsListTilePreview() {
    ShoppingListsListTile(ShoppingList.MOCKS.first())
}