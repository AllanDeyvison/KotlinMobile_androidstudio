package com.example.login

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaSpinner : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_spinner)

        val spinner = findViewById<Spinner>(R.id.spinnerOp)
        val edtV1   = findViewById<EditText>(R.id.edtV1)
        val edtV2   = findViewById<EditText>(R.id.edtV2)
        val btnCalc = findViewById<Button>(R.id.btnCalcular)
        val txtRes  = findViewById<TextView>(R.id.txtResultado)

        btnCalc.setOnClickListener {
            val v1 = edtV1.text.toString().toDouble()
            val v2 = edtV2.text.toString().toDouble()
            val pos = spinner.selectedItemPosition
            val resultado = when (pos) {
                0 -> Math.pow(v1, v2)
                1 -> Math.sqrt(v1)
                2 -> Math.hypot(v1, v2)
                3 -> Math.sin(Math.toRadians(v1))
                else -> 0.0
            }
            txtRes.text = getString(R.string.resultado_format, resultado)
        }
    }
}