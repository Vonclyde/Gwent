package cl.uchile.dcc
package gwent

class Player(val name: String, val side: Boolean, var gems: Int, var deck: Deck, var hand: Hand){

  // Robar una carta
  def draw(): Unit = {
    if (deck.size == 0){
      println("Tu mazo esta vacío!")
    } else {

      
      val topdeck = deck.cards.head
      deck.cards = deck.cards.drop(1)
      deck.size -= 1

      // We put the topdeck in the hand
      hand.cards = hand.cards :+ topdeck
      hand.size += 1
    }
  }
  def play(num_order: Int): Unit = {
    if (hand.size == 0){
      println("Tu mano esta vacía!")
    } else {
      val newHand = hand.cards.zipWithIndex.filter(_._2 != num_order).map(_._1)
      hand.cards = newHand
      hand.size -= 1
    }
  }
}
