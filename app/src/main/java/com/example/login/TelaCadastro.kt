package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro)
        var campoNome=findViewById<EditText>(R.id.editNome)
        var campoEmail=findViewById<EditText>(R.id.editEmail)
        var campoTel=findViewById<EditText>(R.id.editTel)
        var btnSalvar=findViewById<Button>(R.id.button1)
        var btnLimpar=findViewById<Button>(R.id.button2)
        btnLimpar.setOnClickListener {
            campoNome.text?.clear()
            campoEmail.text?.clear()
            campoTel.text?.clear()
            campoNome.requestFocus()
        }
        btnSalvar.setOnClickListener {
            var nome = campoNome.text.toString()
            var email = campoEmail.text.toString()
            var tel = campoTel.text.toString()
            val bundle = Bundle().apply {
                putString(TelaResposta.EXTRA_NOME, nome)
                putString(TelaResposta.EXTRA_EMAIL, email)
                putString(TelaResposta.EXTRA_TEL, tel)
            }
            val intent = Intent(this, TelaResposta::class.java).apply {
                putExtras(bundle)
            }
            startActivity(intent)
        }
    }
}