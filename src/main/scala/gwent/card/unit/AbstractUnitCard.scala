package cl.uchile.dcc
package gwent.card
package unit

import gwent.player.Player

/** An abstract class that represent a UnitCard with a name
 *
 * @constructor Create a new Unit Card with the given name
 * @author Cristian Salas
 * @version 1.0
 * @since 1.1
 */
abstract class AbstractUnitCard(override val name: String) extends Card(name: String) {
  def play(player: Player): Unit
}
