package com.example.myapplication.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.NYTServices.ApiService
import com.example.myapplication.data.model.Book
import com.example.myapplication.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// CLASSE PRECISA SER INDEPENDENTE DAS ACTIVITIES OU FRAGMENTS

// Live data é o componente sugerido para fazer a comunicação entre a view e o viewmodel no android
// Utiliza o pattern de observer: Notifica a view com qualquer alteração que acontece no viewmodel

class BooksViewModel : ViewModel() {

    val booksLiveData : MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {
        ApiService.service.getBooks().enqueue(
            object: Callback<BookBodyResponse>{
                override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<BookBodyResponse>,
                    response: Response<BookBodyResponse>
                ) {
                    if(response.isSuccessful){
                        val books : MutableList<Book> = mutableListOf()

                        response.body()?.let {bookBodyResponse ->
                            for(result in bookBodyResponse.bookResuls) {
                                val book = Book(
                                    title = result.bookDetailsResponse[0].title,
                                    author = result.bookDetailsResponse[0].author
                                )

                                books.add(book)
                            }
                        }

                        booksLiveData.value = books
                    }
                }

            }
        )
    }
}