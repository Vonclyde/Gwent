package cl.uchile.dcc
package gwent.card

import gwent.player.Player

import cl.uchile.dcc.gwent.board.Board

/** A trait that represent a Card
 *
 * @constructor Create a new Card with the given name and description
 * @author Cristian Salas
 * @since 1.0
 * @version 1.1
 */

trait Card {
  
  def name: String

  def description: String

  def played(player: Player, board: Board): Unit

}
