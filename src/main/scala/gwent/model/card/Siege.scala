package cl.uchile.dcc
package gwent.card

import gwent.card.AbstractUnitCard

import cl.uchile.dcc.gwent.board.Board

import java.util.Objects

/** A Siege Card that extends AbstractUnitCard.
 *
 * @param name Name of the card.
 * @param description Possible effect of the card.
 * @param power Strength of the card.
 * @constructor Create a new siege Card with a given name.
 *
 * @author Cristian Salas
 * @version 1.0
 * @since 1.1
 */

class Siege(name: String, description: String = "", power: Int = 0)
  extends AbstractUnitCard(name, description, power) with Equals {

  /**
   * When a siege card is played, it goes to the siege cards zone of the player
   *
   * @param player It receives the player who play the card.
   * @param board Receives the board in which the match is taking place. Is not used in Unit Cards.
   */
  override def played(player: Player, board: Board): Unit = {
    player.battleground.addSiegeCard(this)
  }
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Siege]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Siege]
      super.name == other.name
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[Siege], name)
  }
}
