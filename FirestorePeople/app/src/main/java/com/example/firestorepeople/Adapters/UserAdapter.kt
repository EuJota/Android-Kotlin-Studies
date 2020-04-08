package com.example.firestorepeople.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firestorepeople.Model.User
import com.example.firestorepeople.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.user_item.view.*

class UserAdapter (private val userList:MutableList<User>,
                   private val context: Context) : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)

    )

    override fun getItemCount() = userList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    class UserViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val userPicture = view.pic
        private var userName = view.text_name
        private var userAge = view.text_age

        fun bind(_data : User){
            userName.text = _data.name
            userAge.text = _data.age.toString()
        }
    }
}