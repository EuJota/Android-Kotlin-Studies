package com.example.apiconsuming.Interface
import retrofit2.Call
import com.example.apiconsuming.Model.Posts
import retrofit2.http.GET

/** Por que usar uma interface?
 * Para delegar a responsabilidade de implementar os métodos http apenas ao retrofit
 * Sendo assim ficamos com o código livre só para fazer o tratamento das respostas
 */

interface EndPoint {

    @GET("posts")

    fun getPosts() : Call<List<Posts>>
}

/** getPosts
 * A função abaixo tem um retorno implicito pelo kotlin, e retorna um objeto retrofit do tipo call
 * Utilizamos o call para fazer o processamento da requisição de forma separada, pois não sabemos o tempo
 * da requisição e o app nao pode ficar parado esperando a requisição acontecer
 */