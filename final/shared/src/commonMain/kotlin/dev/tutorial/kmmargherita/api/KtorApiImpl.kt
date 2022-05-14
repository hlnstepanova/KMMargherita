package dev.tutorial.kmmargherita.api

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*

class KtorApiImpl : KtorApi {

    val baseUrl = "https://enigmatic-sands-01782.herokuapp.com/"

    override val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    override fun HttpRequestBuilder.apiUrl(path: String) {
        url {
            takeFrom(baseUrl)
            encodedPath = path
        }
    }

    override fun HttpRequestBuilder.json() {
        contentType(ContentType.Application.Json)
    }
}
