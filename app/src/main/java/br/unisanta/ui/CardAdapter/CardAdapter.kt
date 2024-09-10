package br.unisanta.ui.CardAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.ui.Model.Card
import br.unisanta.ui.R
import com.squareup.picasso.Picasso

class CardAdapter(private val cards:List<Card>):RecyclerView.Adapter<CardAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txvNome: TextView = itemView.findViewById(R.id.txv_nome_card)
        val txvWpp: TextView = itemView.findViewById(R.id.txv_wpp_card)
        val imxUrl: ImageView = itemView.findViewById(R.id.img_url_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycle,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = cards[position]
        Picasso.get().load(card.url).resize(200, 200).centerCrop().into(holder.imxUrl);
        holder.txvNome.text = card.nome
        holder.txvWpp.text = card.number
    }
}