package br.unisanta.ui.Dao

import br.unisanta.ui.Model.Card

class CardDao {
    companion object{
        private val listCard = mutableListOf<Card>()
    }

    fun adicionarCard(card: Card){
        Companion.listCard.add(card)
    }
    fun obterCards(): List<Card> {
        return Companion.listCard
    }
}