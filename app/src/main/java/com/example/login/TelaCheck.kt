package com.example.login

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaCheck : AppCompatActivity() {
    private lateinit var checkPizza: CheckBox
    private lateinit var checkHamburguer: CheckBox
    private lateinit var checkSuco: CheckBox
    private lateinit var btnMostrar: Button
    private lateinit var textTotal: TextView
    private val precoPizza = 30
    private val precoHamburguer = 25
    private val precoSuco = 8

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_check)

        checkPizza = findViewById(R.id.checkPizza)
        checkHamburguer = findViewById(R.id.checkHamburguer)
        checkSuco = findViewById(R.id.checkSuco)
        btnMostrar = findViewById(R.id.btnMostrar)
        textTotal = findViewById(R.id.textTotal)
        btnMostrar.setOnClickListener {
            val escolhas = mutableListOf<String>()
            var total = 0

            if (checkPizza.isChecked){
                escolhas.add("Pizza")
                total += precoPizza
            }
            if (checkHamburguer.isChecked) {
                escolhas.add("Hambúrguer")
                total += precoHamburguer
            }
            if (checkSuco.isChecked) {
                escolhas.add("Suco")
                total += precoSuco
            }
            val mensagem = if (escolhas.isEmpty()) {
                "Nenhum item selecionado."
            } else {
                "Você escolheu:\n- " + escolhas.joinToString("\n- ")
            }

            AlertDialog.Builder(this)
                .setTitle("Escolhas")
                .setMessage(mensagem)
                .setPositiveButton("OK", null)
                .show()
            textTotal.text = "Total: R$ $total"
        }
    }
}