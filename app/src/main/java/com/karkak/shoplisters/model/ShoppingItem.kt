package com.karkak.shoplisters.model

import java.util.UUID

data class ShoppingItem(
    val id: String = "", // Assuming items also have IDs, adjust as needed
    val name: String = "",
    val quantity: Int = 0,
    val complete: Boolean = false
) {
    companion object {
        private fun mock(
            id: String = UUID.randomUUID().toString(),
            name: String = "Sample Item ${(0..99).random()}",
            quantity: Int = (1..5).random(),
            complete: Boolean = false // Default to not complete
        ): ShoppingItem {
            return ShoppingItem(
                id = id,
                name = name,
                quantity = quantity,
                complete = complete
            )
        }

        val MOCKS: List<ShoppingItem> = listOf(
            mock(name = "Milk", quantity = 1, complete = false),
            mock(name = "Bread", quantity = 2, complete = true),
            mock(name = "Eggs", quantity = 12, complete = false),
            mock(name = "Butter", quantity = 1, complete = false),
            mock(name = "Apples", quantity = 5, complete = true, id = "fixed-apple-id"), // Example with a fixed ID
            mock(name = "Chicken Breast", quantity = 2, complete = false),
            mock(name = "Pasta", quantity = 1, complete = false),
            mock(name = "Orange Juice", quantity = 1, complete = true)
        )
    }
}
