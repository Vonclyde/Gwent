package cl.uchile.dcc
package gwent.player

import gwent.card.Card

/** A List of cards that represent the cards that are not playable yet.
 *
 * @param cards List of cards that are in the deck, they need to be drawn first in order to play them.
 * @constructor Creates a deck with a specific list of cards
 *
 * @see Card
 */

class Deck(var cards: List[Card]){

  /** Number of cards in deck. */
  def size: Int = cards.length

}
