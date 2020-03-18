package com.example.apiconsuming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apiconsuming.Interface.EndPoint
import com.example.apiconsuming.Model.Posts
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
    }

    /** getData
     * A responsabilidade da função getData é consumir as informações da api que usamos
     * As funções endpoint e callback são utulizadas para o retrofit montar a requisição
     */
    fun getData() {

        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://jsonplaceholder.typicode.com/")

        val endpoint = retrofitClient.create(EndPoint :: class.java)
        val callback = endpoint.getPosts()

        callback.enqueue(object : Callback<List<Posts>>{
            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                 response.body()?.forEach{
                     textView.text = textView.text.toString().plus(it.body)
                 }
            }

        })
    }
}
