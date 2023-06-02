package cl.uchile.dcc
package gwent.player

import gwent.card.Card

@/** A List of cards that represent the playable cards.
 *
 * @param cards Playable cards.
 *
 * @constructor Creates a hand with a specific list of cards
 *              
 * @see Card
 * 
 * @author Cristian Salas
 * @since 1.0.0
 * @version 1.1.0
 */

class Hand(var cards: List[Card]){
  /** Number of cards in deck. */
  def size: Int = cards.length
  
  /** Discard the current hand for an empty one */
  def discardHand(): Unit = {
    cards = List()
  }
}
