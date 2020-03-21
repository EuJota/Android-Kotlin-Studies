package com.example.coronabrasil.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coronabrasil.Model.Data
import com.example.coronabrasil.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.note_item.view.*

class CoronaListAdapter (val context : Context) : RecyclerView.Adapter<CoronaListAdapter.UserViewHolder>(){
    var datas : List<Data> = listOf()

    fun updateData(newDatas : List<Data>){
        this.datas = newDatas
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
    )

    override fun getItemCount() = datas.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    class UserViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val textState = view.state_item
        private val textCases = view.cases_item
        private val textSuspects = view.suspects_item

        fun bind(_data : Data){
            textState.text = _data.state
            textCases.text = _data.cases.toString()
            textSuspects.text = _data.suspects.toString()
        }
    }
}