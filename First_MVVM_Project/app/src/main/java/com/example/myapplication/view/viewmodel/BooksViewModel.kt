package com.example.myapplication.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.model.Book

// CLASSE PRECISA SER INDEPENDENTE DAS ACTIVITIES OU FRAGMENTS

// Live data é o componente sugerido para fazer a comunicação entre a view e o viewmodel no android
// Utiliza o pattern de observer: Notifica a view com qualquer alteração que acontece no viewmodel

class BooksViewModel : ViewModel() {

    val booksLiveData : MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {
        booksLiveData.value = createFakeBooks()
    }

    fun createFakeBooks() : List<Book>{
        return listOf(
            Book("Title","Autor 1"),
            Book("Title 2","Autor 2"),
            Book("Title 3","Autor 3")
        )
    }
}