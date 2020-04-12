package com.example.firestorepeople.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.firestorepeople.Persistence.DataPersistence
import com.example.firestorepeople.Model.User
import com.example.firestorepeople.R
import kotlinx.android.synthetic.main.user_item.view.*
import java.util.*

class UserAdapter (private val userList:MutableList<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>(), Filterable{

    var userFilterList = mutableListOf<User>()

    init {
        userFilterList = userList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)

    )

    override fun getItemCount() = userFilterList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userFilterList[position])
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val textSearch = constraint.toString()

                if(textSearch.isEmpty())
                    userFilterList = userList
                else{
                    val resultList = mutableListOf<User>()
                    for(user in userList)
                        if(user.name.toLowerCase(Locale.getDefault()).contains(textSearch))
                            resultList.add(user)

                    userFilterList = resultList
                }

                val filterResults = FilterResults()
                filterResults.values = userFilterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                userFilterList = results?.values as MutableList<User>
                notifyDataSetChanged()
            }
        }
    }


    inner class UserViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val userPicture = view.pic
        private var userName = view.text_name
        private var userAge = view.text_age
        private var toFavorite = view.btn_fav_empty

        fun bind(_data : User){
            userName.text = _data.name
            userAge.text = _data.age.toString()

            itemView.setOnClickListener{println("Saaaaaaafe")}

            toFavorite.setOnClickListener{
                    toFavorite.setImageResource(R.drawable.ic_favorite)
            }
        }
    }
}