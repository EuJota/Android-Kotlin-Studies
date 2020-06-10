package com.example.myapplication.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.model.Book
import kotlinx.android.synthetic.main.itens_books.view.*

class BooksAdapter(private val books: List<Book>) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itens_books, parent,false)
        return BooksViewHolder(itemView)
    }

    override fun getItemCount() = books.count()

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bindView(books[position])
    }

    class BooksViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.txt_title
        private val author = itemView.txt_author

        fun bindView(_book : Book){
            title.text = _book.title
            author.text = _book.author
        }
    }
}