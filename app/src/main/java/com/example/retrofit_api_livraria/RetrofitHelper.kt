package com.example.retrofit_api_livraria
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetrofitHelper {
    //acessar o reqres -> site
    //URL base
    private  const val baseUrl = " http://10.107.144.16:3002"

    //criando a conexao -> metodo para resolver conexao para quando chamar abrir a conexao

    fun getInstace(): Retrofit {
        // espera um retorno de um objeto
        return Retrofit.Builder() //retorno do retofif do Bulder(para construir)
            .baseUrl(baseUrl)
            //fabrica de conversao -> para conveter o objeto json para o retrofit manipula-lo
            .addConverterFactory(GsonConverterFactory.create())
            .build() //para construir
    }
}