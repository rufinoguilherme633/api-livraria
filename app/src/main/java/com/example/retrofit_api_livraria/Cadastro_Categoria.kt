package com.example.retrofit_api_livraria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

class Cadastro_Categoria : AppCompatActivity() {

    private  lateinit var apiService: ApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_categoria)
        //conecta apiservise com API REST atravé da CLASSE RetrofitHelprer
        //e seumétodo getInstace
        apiService = RetrofitHelper.getInstace().create(ApiService::class.java)

        //Recupera o Componente grafico
        val txtCategoria = findViewById<EditText>(R.id.txtCategoria)
        //trata A AÇÀO DE CLICK NO BOTÀO CADATRASR
        findViewById<Button>(R.id.bntCadastrarCategoria).setOnClickListener {

            // recuperar o dado pelo usuario
            val nomeCategoria = txtCategoria
            createCategory(nomeCategoria.toString())
            //enviar a requisiçao de cadastar paa api

        }
    }



    private fun createCategory(nome_categoria: String) {
        lifecycleScope.launch {
            //Montagem do corpo de dados em JSON

            var body = JsonObject().apply {
                addProperty("nome_categoria", nome_categoria)
            }
            //envio da requisição de cadastro de categoria
            val result = apiService.createCategory(body)

            if(result.isSuccessful) {
                val msg = result.body()?.get("mensagemStatus")
                Log.e("CREATE-CATEGORY", "STATUS: ${msg}")
            }else{
                Log.e("CREATE-CATEGORY", "ERROR: ${result.message()}")

            }
        }
    }
}