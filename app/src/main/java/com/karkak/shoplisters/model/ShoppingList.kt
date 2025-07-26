package com.karkak.shoplisters.model

import java.util.Date
import java.util.UUID
import java.util.concurrent.TimeUnit

data class ShoppingList(
    val id: String,
    val creationDate: Date,
    val name: String,
    val creator: String,
    val complete: Boolean,
    val items: List<ShoppingItem>,
    val completionDate: Date?,
) {
    companion object {
        private fun mock(
            id: String = UUID.randomUUID().toString(),
            creationDate: Date = Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis((1..10).random().toLong())),
            name: String = "Mock List #${(0..99).random()}",
            creator: String = "User${(1..10).random()}",
            complete: Boolean = false,
            items: List<ShoppingItem> = ShoppingItem.MOCKS.shuffled().take((3..ShoppingItem.MOCKS.size).random()),
            completionDate: Date? = if (complete) Date(System.currentTimeMillis() - TimeUnit.HOURS.toMillis((1..5).random().toLong())) else null
        ): ShoppingList {
            return ShoppingList(
                id = id,
                creationDate = creationDate,
                name = name,
                creator = creator,
                complete = complete,
                items = items,
                completionDate = completionDate
            )
        }

        /**
         * A predefined list of mock ShoppingList objects for previews, testing, etc.
         */
        val MOCKS: List<ShoppingList> = listOf(
            mock(
                name = "Weekly Groceries",
                creator = "Alice",
                complete = false,
                items = ShoppingItem.MOCKS.take(5)
            ),
            mock(
                name = "Weekend Chores",
                creator = "Bob",
                complete = true,
                items = ShoppingItem.MOCKS.take(3),
                completionDate = Date() // Standard java.util.Date
            ),
            mock(
                name = "New Empty List",
                creator = "Charlie",
                complete = false,
                items = emptyList()
            ),
            mock(
                name = "Big Party Prep",
                creator = "Dana",
                complete = false,
                items = ShoppingItem.MOCKS.shuffled().mapIndexed { index, item ->
                    if (index % 3 == 0) item.copy(complete = true) else item
                }
            ),
            mock(
                name = "Office Supplies",
                creator = "Eve",
                complete = false,
                items = ShoppingItem.MOCKS.shuffled().take(4)
            ),
            mock(
                name = "Household Inventory Check",
                creator = "Frank",
                complete = true,
                items = ShoppingItem.MOCKS.map { it.copy(complete = true) },
                completionDate = Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1)) // Standard java.util.Date
            )
        )
    }
}