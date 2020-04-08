package com.example.firestorepeople.Fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firestorepeople.Adapters.UserAdapter
import com.example.firestorepeople.Model.User
import com.example.firestorepeople.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var userAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_first, container, false)

        recyclerView = view.findViewById(R.id.recyclerview_users)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)

        readUsers()

        return view
    }

    fun readUsers(){
        val userList = mutableListOf<User>()


        val db = FirebaseFirestore.getInstance()

        db.collection("pessoas")
            .get()
            .addOnSuccessListener { result ->
                userList.clear()

                for (doc in result) {
                    val user = doc.toObject(User::class.java)
                    user.id = doc.id
                    user.name = doc.get("nome").toString()
                    user.age = doc.get("idade").toString().toInt()

                    userList.add(user)
                    //userList.add(User(doc.id, doc.get("nome").toString(), doc.get("idade").toString().toInt())) - FUNCIONANDO
                }

                userAdapter = UserAdapter(userList, context!!)
                recyclerView.adapter = userAdapter
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
    }
}

