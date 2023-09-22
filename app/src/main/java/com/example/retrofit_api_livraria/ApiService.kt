package com.example.retrofit_api_livraria
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
interface ApiService {
    @POST("/categoria/cadastrarCategoria")
    //mandar dados
    suspend fun createCategory(@Body body: JsonObject): Response<JsonObject> //JsonO -> google devolve e manda Json
}