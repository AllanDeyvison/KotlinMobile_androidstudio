package com.example.login

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaRadio : AppCompatActivity() {
    // Preços (R$) — ajuste como quiser
    private val PRECO_CAMISA = 49.90
    private val PRECO_CALCA  = 89.90
    private val PRECO_SAPATO = 149.90
    private var precoSelecionado = PRECO_CAMISA
    private var nomeSelecionado  = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_radio)
        val titulo       = findViewById<TextView>(R.id.txtTitulo)
        val radioGroup   = findViewById<RadioGroup>(R.id.rgRoupas)
        val rbCamisa     = findViewById<RadioButton>(R.id.rbCamisa)
        val rbCalca      = findViewById<RadioButton>(R.id.rbCalca)
        val rbSapato     = findViewById<RadioButton>(R.id.rbSapato)
        val imgItem      = findViewById<ImageView>(R.id.imgItem)
        val edtQtd       = findViewById<EditText>(R.id.edtQuantidade)
        val btnCalcular  = findViewById<Button>(R.id.btnCalcular)
        val txtItemInfo  = findViewById<TextView>(R.id.txtItemInfo)
        val txtTotal     = findViewById<TextView>(R.id.txtTotal)
        // Usando strings do resources
        titulo.text = getString(R.string.app_title)
        // Estado inicial: Camisa
        rbCamisa.isChecked = true
        precoSelecionado = PRECO_CAMISA
        nomeSelecionado = getString(R.string.camisa)
        imgItem.setImageResource(R.drawable.camisa)
        txtItemInfo.text = getString(R.string.item_info_format,
            nomeSelecionado, precoSelecionado)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbCamisa -> {
                    precoSelecionado = PRECO_CAMISA
                    nomeSelecionado = getString(R.string.camisa)
                    imgItem.setImageResource(R.drawable.camisa)
                }
                R.id.rbCalca -> {
                    precoSelecionado = PRECO_CALCA
                    nomeSelecionado = getString(R.string.calca)
                    imgItem.setImageResource(R.drawable.calcajeans)
                }
                R.id.rbSapato -> {
                    precoSelecionado = PRECO_SAPATO
                    nomeSelecionado = getString(R.string.sapato)
                    imgItem.setImageResource(R.drawable.sapato)
                }
            }
            txtItemInfo.text = getString(R.string.item_info_format,
                nomeSelecionado, precoSelecionado)
            txtTotal.text = "" // limpa o total ao trocar o item
        }
        btnCalcular.setOnClickListener {
            val qtd = edtQtd.text.toString().toInt() // seguindo sua linha: sem toIntOrNull
            val total = qtd * precoSelecionado
            txtTotal.text = getString(R.string.total_format, total)
        }
    }
}