package com.example.retrofit_api_livraria
import com.google.gson.annotations.SerializedName // biblioteca que permite o que eu passar ele vai ser adaptado

data class BaseResponse<T>(// é o objeto estrutura de dados que vai ser passado
    @SerializedName("data")// uma forma de fazer anotações de estrutura de dados vai criar um objeto para
    var data: T? = null
)
