package br.unisanta.ui.Views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.ui.CardAdapter.CardAdapter
import br.unisanta.ui.Dao.CardDao
import br.unisanta.ui.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListCards : AppCompatActivity() {
    val cardDao = CardDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_cards)

        val btnVoltar = findViewById<FloatingActionButton>(R.id.fab_voltar)
        val rvTrefas = findViewById<RecyclerView>(R.id.rv_cards)
        val cards = cardDao.obterCards()

        rvTrefas.layoutManager = LinearLayoutManager(this)
        rvTrefas.adapter = CardAdapter(cards)

        btnVoltar.setOnClickListener {
            finish()
        }
    }
}