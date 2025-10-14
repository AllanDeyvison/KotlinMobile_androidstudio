 package com.example.login

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaLista : AppCompatActivity() {
    private val precos = doubleArrayOf(
        49.90,   // Camisa
        89.90,   // Calça
        149.90   // Sapato
    )
    // imagens na mesma ordem (reaproveitando as que você já tem)
    private val imagens = intArrayOf(
        R.drawable.roupa_camisa,
        R.drawable.roupa_calca,
        R.drawable.roupa_sapato
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_lista)

        val lista = findViewById<ListView>(R.id.lista)
        val produtos = resources.getStringArray(R.array.produtos)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
            produtos)
        lista.adapter = adapter

        lista.setOnItemClickListener { _, _, position, _ ->
            mostrarDialogProduto(produtos[position], precos[position],
                imagens[position])
        }
    }
    private fun mostrarDialogProduto(nome: String, preco: Double, imgRes: Int)
    {
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_item,
            null)
        val img = view.findViewById<ImageView>(R.id.imgProduto)
        val txtPreco = view.findViewById<TextView>(R.id.txtPreco)
        val edtQtd = view.findViewById<EditText>(R.id.edtQtd)
        val btnCalcular = view.findViewById<Button>(R.id.btnCalcular)
        val txtTotal = view.findViewById<TextView>(R.id.txtTotal)

        img.setImageResource(imgRes)
        txtPreco.text = getString(R.string.preco_unit, preco)

        val dialog = AlertDialog.Builder(this)
            .setTitle(nome)
            .setView(view)
            .setNegativeButton(getString(R.string.fechar), null)
            .create()
        btnCalcular.setOnClickListener {
            val qtd = edtQtd.text.toString().toInt()
            val total = qtd * preco
            txtTotal.text = getString(R.string.total_format, total)
        }
        dialog.show()
    }

}