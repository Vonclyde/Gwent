package cl.uchile.dcc
package gwent.card.unit

import gwent.card.unit.AbstractUnitCard

import cl.uchile.dcc.gwent.player.Player

import java.util.Objects

/** A Melee Card that extends AbstractUnitCard.
 *
 * @constructor Create a new melee Card with the given name.
 * @author Cristian Salas
 * @version 1.0
 * @since 1.1
 */

class Melee(name: String) extends AbstractUnitCard(name) with Equals {

  override def play(player: Player): Unit = {
    player.receiveMeleeCard(this)
  }
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Melee]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Melee]
      name == other.name
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[Melee], name)
  }
}
