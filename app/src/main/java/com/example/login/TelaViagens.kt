package com.example.login

import android.os. Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView

class TelaViagens : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_viagens)

        val listView = findViewById<ListView>(R.id.listViewViagens)

        val viagens = listOf(
            Viagem("Salvador", "Pacote 5 dias com hotel incluso", "R$ 1.500", R.drawable. salvador),
            Viagem("Rio de Janeiro", "Pacote 7 dias + passeio pelo Cristo", "R$ 2.200", R.drawable.rio),
            Viagem("São Paulo", "Pacote 3 dias + city tour", "R$ 900", R.drawable. saopaulo)
        )

        val adapter = ViagemAdapter(this, viagens)
        listView.adapter = adapter
    }
}