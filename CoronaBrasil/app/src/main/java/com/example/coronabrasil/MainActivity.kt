package com.example.coronabrasil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coronabrasil.Adapter.CoronaListAdapter
import com.example.coronabrasil.Interface.NoteService
import com.example.coronabrasil.Model.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var recyclerAdapter : CoronaListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.note_list_recyclerview)
        recyclerAdapter = CoronaListAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        getData()

    }

    fun getData(){
        val retrofitinitializer = RetrofitInitializer
            .getRetrofitInitializer()

        val endpoint = retrofitinitializer.create(NoteService::class.java)
        val callback = endpoint.listDatas()

        callback.enqueue(object : Callback<DataResponse>{

            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
              if(response.isSuccessful) {
                  val data: MutableList<Data> = mutableListOf()

                  response.body()?.let { dataResponse ->
                      for (event in dataResponse.dataResults){
                          val corona = Data(
                              state = event.state,
                              cases = event.cases,
                              suspects = event.suspects
                          )
                          data.add(corona)
                      }
                  }
                  recyclerAdapter.updateData(data)
              }
            }

        })
    }
}
