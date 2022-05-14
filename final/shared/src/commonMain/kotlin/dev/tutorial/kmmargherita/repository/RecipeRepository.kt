package dev.tutorial.kmmargherita.repository

import dev.tutorial.kmmargherita.model.Recipe
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RecipeRepository : KoinComponent {
    private val recipeRemoteSource: RecipeRemoteSource by inject()

    suspend fun getRecipes(): List<Recipe> = recipeRemoteSource.getRecipes()
}
