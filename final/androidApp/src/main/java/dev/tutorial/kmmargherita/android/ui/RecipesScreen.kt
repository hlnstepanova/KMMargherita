package dev.tutorial.kmmargherita.android.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.tutorial.kmmargherita.model.Recipe
import dev.tutorial.kmmargherita.viewmodel.RecipeViewModel

@Composable
public fun RecipesScreen() {
    val viewModel = remember { RecipeViewModel() }

    val recipes by viewModel.recipes.collectAsState()

    Recipes(items = recipes)
}

@Composable
fun Recipes(
    items: List<Recipe>
) {
    LazyColumn {
        itemsIndexed(
            items = items,
            itemContent = { _, item ->
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = item.title
                )
            }
        )
    }
}
