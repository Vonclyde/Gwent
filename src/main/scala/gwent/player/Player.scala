package cl.uchile.dcc
package gwent.player

import gwent.card.{Card, WeatherCard}

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.card.unit.{Melee, Ranged, Siege}

/** This class represent the player.
 *
 * A player is defined by his name. They have a side of the battlefield in which he is
 * gonna play his cards. Gems represent his "health" in the match. He also has a
 * starting deck and hand.
 *
 * @param name Name of the player.
 * @param side Side of the battlefield.
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
 * @version 1.0.0
 */
class Player(val name: String, val side: Battleground, var gems: Int = 2, var deck: Deck, var hand: Hand) extends Equals {

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
   *
   * @example
   * {{{
   * val deck = List(card1, card2)
   * val hand = List(card3, card4)
   * val player = new Player("Howl", true, 2, deck, hand)
   *
   * player.draw()
   *
   * printf(deck == List(card2))
   * printf(hand == List(card3, card4, card1))
   * }}}
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
      deck.size -= 1

      // Add the topdeck to the hand.
      hand.cards = hand.cards :+ topdeck
      hand.size += 1
    }
  }

  /** Play the cards in your hand.
   *
   * Function in order to actually play the cards that are in your hand
   * based in their order, from zero to the size of the hand minus one.
   * In this version the method only eliminates the card from the hand,
   * because there is no battlefield yet.
   *
   * @param num_order Integer that represent the index of the card in hand.
   * {{{
   * val deck = List()
   * val hand = List(card3, card4)
   * val player = new Player("Howl", true, 2, deck, hand)
   *
   * player.play(0)
   *
   * printf(player.hand == List(card4))
   *
   * }}}
   */

  def play(num: Int): Unit = {
    // If there is no cards in hand to be player, it prints "Tu mano está vacía!".
    if (hand.size == 0){
      println("Tu mano está vacía!")
    } else {
      // Card is eliminated from the hand according to num_order.
      val playedCard: Card = hand.cards.apply(num)
      playedCard.play(this)

      val newHand = hand.cards.zipWithIndex.filter(_._2 != num).map(_._1)
      hand.cards = newHand
      hand.size -= 1
    }
  }
  def receiveMeleeCard(melee: Melee): Unit = {
    side.addMeleeCard(melee)
  }
  def receiveRangedCard(ranged: Ranged): Unit = {
    side.addRangedCard(ranged)
  }
  def receiveSiegeCard(siege: Siege): Unit = {
    side.addSiegeCard(siege)
  }
}