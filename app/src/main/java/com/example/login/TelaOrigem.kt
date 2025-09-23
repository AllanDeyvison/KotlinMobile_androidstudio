package com.example.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaOrigem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_origem)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nome = "Ana"
        val email = "ana@mail.com"
        val tel = "(11) 999999-0000"

        val intent = Intent(this, TelaResposta::class.java).apply {
            putExtra(TelaResposta.EXTRA_NOME, nome)
            putExtra(TelaResposta.EXTRA_EMAIL, email)
            putExtra(TelaResposta.EXTRA_TEL, tel)


        }

    }
}