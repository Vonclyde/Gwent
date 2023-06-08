package cl.uchile.dcc
package gwent.card

import cl.uchile.dcc.gwent.board.Board

/** A trait that represent a Card
 *
 * @constructor Create a new Card with the given name and description
 * @author Cristian Salas
 * @since 1.0
 * @version 1.1
 */

trait Card {

  /**
   * Getters to obtain the name of the card and description
   */
  def name: String
  def description: String

  /**
   * Function for when a card is played, its different according to the type of card
   *
   * @param player Player who plays the card.
   * @param board Board in which the match is taking place.
   */
  def played(player: Player, board: Board): Unit

}
