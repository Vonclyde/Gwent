package cl.uchile.dcc
package gwent.player

import gwent.card.Card

/** A List of cards that represent the playable cards.
 *
 * @param cards Playable cards.
 *
 * @constructor Creates a hand with a specific list of cards
 *              
 * @see Card
 */

class Hand(var cards: List[Card]){
  /** Number of cards in deck. */
  def size: Int = cards.length
  
  def discardHand(): Unit = {
    cards = List()
  }
}
