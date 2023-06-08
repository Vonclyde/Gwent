package cl.uchile.dcc
package gwent.card

import gwent.board.Board


/** An abstract class that represent a UnitCard with no type.
 *
 * @param _name Name of the card.
 * @param _description Possible effect of the card.
 * @param _power Streght of the card.
 *
 * @author Cristian Salas
 * @version 1.0
 * @since 1.1
 */
abstract class AbstractUnitCard (private val _name: String, private val _description: String, private var _power: Int)
  extends Card {

  /**
   * Getters for the attributes of a unit card.
   */
  def name: String = _name

  def description: String = _description

  def power: Int = _power

}