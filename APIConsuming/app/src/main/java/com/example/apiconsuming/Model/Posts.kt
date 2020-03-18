package com.example.apiconsuming.Model

import com.google.gson.annotations.SerializedName

/**
 * classe que irá representar a resposta que contém as informações retornadas pela API,
 * para isso precisamos criar uma classe com os atributos e padrões necessários para que o GsonFactory
 * converta as respostas em objetos que possam ser úteis para nossa aplicação
 */

/** Por que usar data class e não class?
 *  O data class é utilizado para representar um POJO de maneira concisa, porém funciona normalmente sem o data
 *  O fator importante para usar data class (nao é esse exemplo) é que o data class nos entrega
 *  funções pré implementadas baseando-se nas propriedades do do construtor primário
 */

data class Posts(

    @SerializedName("userId")
    var userId : Int,
    @SerializedName("id")
    var id : Int,
    @SerializedName("title")
    var title : String,
    @SerializedName("body")
    var body : String
)