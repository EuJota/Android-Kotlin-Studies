package com.example.firestorepeople

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.firestorepeople.Model.User
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_cadastrar.*

class CadastrarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar)

        val txt_name  = text_name
        val txt_age = text_age
        val btn_insert : Button = btn_create

        btn_insert.setOnClickListener(View.OnClickListener {
            insertUser(txt_name.text.toString(), txt_age.text.toString().toInt())
        })
    }

    fun insertUser(txtName: String, txtAge: Int){
        val db = FirebaseFirestore.getInstance()

        val person = hashMapOf(
            "idade" to txtAge,
            "nome" to txtName
        )

        db.collection("pessoas")
            .add(person)
            .addOnSuccessListener { documentReference -> System.out.println("doc id -> ${documentReference.id}") }
            .addOnFailureListener{e-> Toast.makeText(applicationContext, "Erro: ${e.message}", Toast.LENGTH_SHORT).show()}
    }
}
