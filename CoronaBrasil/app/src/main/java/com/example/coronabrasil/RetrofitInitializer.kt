package com.example.coronabrasil

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/** Nomeando a classe de configuração do retrofit
 * Existem algumas convenções para nomear essa classe de configuração:
 * RetrofitConfig, Webclient ou DependencyInjection
 */
class RetrofitInitializer {
//nao entendi bem esse role aqui ainda
    companion object{
        fun  getRetrofitInitializer() : Retrofit{
            return Retrofit.Builder()
                .baseUrl("https://api.coronaanalytic.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}