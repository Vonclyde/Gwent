package cl.uchile.dcc
package gwent.player

import gwent.card.Card
import gwent.board.{Battleground, Board}

/** This class represent the player.
 *
 * A player is defined by his name. They have a side of the battlefield in which he is
 * gonna play his cards. Gems represent his "health" in the match. He also has a
 * starting deck and hand.
 *
 * @param name Name of the player.
 * @param battleground Side of the battlefield.
 * @param gems Health of the player.
 * @param deck His deck of cards.
 * @param hand His hand of cards.
 * @constructor Creates a new player that will be in a gwent match
 * @example
 * {{{
 * val player1 = new Player("Zack", true, 2, new Deck, new Hand)
 * val player2 = new Player("Cody", false, 2, new Deck, new Hand)
 * }}}
 * @see Deck
 * @see Hand
 * @see Card
 * @author Cristian Salas
 * @since 1.0.0
 * @version 1.2.0
 */
class Player(private val _name: String, private val _battleground: Battleground, private var _gems: Int, private var _deck: Deck, private var _hand: Hand) extends Equals {

  def name: String = _name
  def battleground: Battleground = _battleground
  def gems: Int = _gems
  def deck: Deck = _deck
  def hand: Hand = _hand
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Player]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Player]
      name == other.name
    } else {
      false
    }
  }

  /** Draw a card from the deck and add it in the hand.
   *
   * Function to draw a card from the respective deck of the player.
   * It adds the top card of the deck to the player's hand.
   */
  def draw(): Unit = {
    // If the deck is empty, there is no cards to draw. Return
    // "Tu mazo está vacío".
    if (deck.size == 0){
      println("Tu mazo está vacío!")
    } else {

      // Topdeck is the card that is in the top of your deck, it will
      // always be the one drawn.
      val topdeck = deck.cards.head
      deck.cards = deck.cards.drop(1)

      // Add the topdeck to the hand.
      hand.cards = hand.cards :+ topdeck
    }
  }

  /** Play the cards in your hand.
   *
   * Function in order to actually play the cards based in their position
   * in the hand, from zero to the size of the hand minus one.
   * In this version the method will check the type of the card from the hand,
   * and then add it to its corresponding area on the player's battleground.
   *
   * @param num Integer that represent the index of the card in hand.
   * @param board Where the game is taking place.
   *
   */

  def play(num: Int, board: Board): Unit = {
    // If there is no cards in hand to be player, it prints "Tu mano está vacía!".
    if (hand.size == 0){
      println("Tu mano está vacía!")
    } else {
      // Card is eliminated from the hand according to num.
      val playedCard: Card = hand.cards.apply(num)
      playedCard.played(this, board)

      val newHand = hand.cards.zipWithIndex.filter(_._2 != num).map(_._1)
      hand.cards = newHand
    }
  }
}