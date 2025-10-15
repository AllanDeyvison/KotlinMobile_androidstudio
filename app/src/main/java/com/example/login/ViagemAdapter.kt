package com.example.login

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ViagemAdapter(private val context: Context, private val lista: List<Viagem>) : BaseAdapter() {
    override fun getCount(): Int = lista.size
    override fun getItem(position: Int): Any = lista[position]
    override fun getItemId(position: Int): Long = position. toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false)
        val viagem = lista[position]
        val imgCidade = view.findViewById<ImageView>(R.id.imgCidade)
        val txtCidade = view.findViewById<TextView>(R.id.txtCidade)
        val txtDescricao = view.findViewById<TextView>(R.id.txtDescricao)
        val txtPreco = view.findViewById<TextView>(R.id.txtPreco)

        imgCidade.setImageResource(viagem.imagem)
        txtCidade.text = viagem.cidade
        txtDescricao.text = viagem.descricao
        txtPreco.text = viagem.preco
        return view
    }
}