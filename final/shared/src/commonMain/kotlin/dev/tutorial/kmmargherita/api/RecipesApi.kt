package dev.tutorial.kmmargherita.api

import dev.tutorial.kmmargherita.model.Recipe
import io.ktor.client.call.*
import io.ktor.client.request.*

class RecipesApi(private val ktorApi: KtorApi) : KtorApi by ktorApi {

    companion object {
        const val RECIPES_BASE_URL = "recipes"
    }

    suspend fun getPizza(): String {
        return client.get {
            apiUrl("pizza")
        }.body()
    }

    suspend fun getRecipes(): List<Recipe> {
        return client.get {
            apiUrl(RECIPES_BASE_URL)
        }.body()
    }
}
