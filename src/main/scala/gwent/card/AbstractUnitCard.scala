package cl.uchile.dcc
package gwent.card

import gwent.board.Board
import gwent.player.Player


/** An abstract class that represent a UnitCard with a name
 *
 * @constructor Create a new Unit Card with the given name
 * @author Cristian Salas
 * @version 1.0
 * @since 1.1
 */
abstract class AbstractUnitCard (private val _name: String, private val _description: String, private var _power: Int)
  extends Card {

  def name: String = _name

  def description: String = _description

  def power: Int = _power

}