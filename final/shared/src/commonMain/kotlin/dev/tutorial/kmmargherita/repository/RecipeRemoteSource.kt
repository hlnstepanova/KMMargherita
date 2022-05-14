package dev.tutorial.kmmargherita.repository

import dev.tutorial.kmmargherita.api.RecipesApi

class RecipeRemoteSource(private val recipesApi: RecipesApi) {
    suspend fun getRecipes() = recipesApi.getRecipes()
}
