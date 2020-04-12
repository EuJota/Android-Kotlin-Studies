package com.example.firestorepeople.Fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
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

    fun  readUsers(){
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

                userAdapter = UserAdapter(userList)
                recyclerView.adapter = userAdapter
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }

    //PRECISA CORRIGIR O SEARCH QUE TA BUGADO (O BOTAO)
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        val searchItem = menu.findItem(R.id.action_settings)

        if (searchItem != null){
            val searchView = searchItem.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    userAdapter.filter.filter(newText)
                    return true
                }

            })
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
    }
}

