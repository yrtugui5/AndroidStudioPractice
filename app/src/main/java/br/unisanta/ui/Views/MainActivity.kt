package br.unisanta.ui.Views

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import br.unisanta.ui.Dao.CardDao
import br.unisanta.ui.Model.Card
import br.unisanta.ui.R
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    val cardDao = CardDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nome = findViewById<TextInputEditText>(R.id.edt_nome_txt)
        val wppNumber = findViewById<TextInputEditText>(R.id.edt_wpp_txt)
        val url = findViewById<TextInputEditText>(R.id.edt_url_txt)
        val btnCadastrar = findViewById<AppCompatButton>(R.id.btn_cadastrar)
        val btnVisuCont = findViewById<TextView>(R.id.btn_visualizarContatos)

        btnCadastrar.setOnClickListener {
            val card = Card(nome.text.toString(), wppNumber.text.toString(), url.text.toString())
            cardDao.adicionarCard(card)
            Toast.makeText(this, "Contato Cadastrado com Sucesso.", Toast.LENGTH_LONG).show()
        }

        btnVisuCont.setOnClickListener {
            val intent = Intent(this, ListCards::class.java)
            startActivity(intent)
        }
    }
}