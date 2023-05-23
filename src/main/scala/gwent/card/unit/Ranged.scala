package cl.uchile.dcc
package gwent.card.unit

import gwent.card.unit.AbstractUnitCard

import cl.uchile.dcc.gwent.player.Player

import java.util.Objects

/** A Ranged Card that extends AbstractUnitCard.
 *
 * @constructor Create a new ranged Card with the given name.
 * @author Cristian Salas
 * @version 1.0
 * @since 1.1
 */

class Ranged(name: String) extends AbstractUnitCard(name) with Equals {

  override def play(player: Player): Unit = {
    player.receiveRangedCard(this)
  }
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Ranged]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Ranged]
      name == other.name
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[Ranged], name)
  }
}