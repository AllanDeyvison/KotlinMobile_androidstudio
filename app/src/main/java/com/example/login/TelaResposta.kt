package com.example.login

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaResposta : AppCompatActivity() {

    companion object{
        const val EXTRA_NOME = "EXTRA_NOME"
        const val EXTRA_EMAIL = "EXTRA_EMAIL"
        const val EXTRA_TEL = "EXTRA_TEL"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tela_resposta)
        var textResposta= findViewById<TextView>(R.id.textResposta)
        var buttonMostrar= findViewById<Button>(R.id.buttonMostrar)


        val extras = intent.extras
        val nome = intent.getStringExtra(EXTRA_NOME).orEmpty()
        val email = intent.getStringExtra(EXTRA_EMAIL).orEmpty()
        val tel = intent.getStringExtra(EXTRA_TEL).orEmpty()

        textResposta.text = "Nome: $nome\nEmail: $email\nTel: $tel"
        buttonMostrar.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Dados informados")
                .setMessage("Nome: $nome\nEmail: $email\nTel: $tel")
                .setPositiveButton("OK", null)
                .show()

        }
    }
}