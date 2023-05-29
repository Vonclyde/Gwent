package cl.uchile.dcc
package gwent.card

import gwent.card.AbstractUnitCard
import gwent.player.Player

import cl.uchile.dcc.gwent.board.Board

import java.util.Objects

/** A Melee Card that extends AbstractUnitCard.
 *
 * @constructor Create a new melee Card with the given name.
 * @author Cristian Salas
 * @version 1.0
 * @since 1.1
 */

class Melee(name: String, description: String = "", power: Int = 0)
  extends AbstractUnitCard(name, description, power) with Equals {

  override def played(player: Player, board: Board): Unit = {
    player.battleground.addMeleeCard(this)
  }
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Melee]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Melee]
      super.name == other.name
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[Melee], super.name)
  }
}
