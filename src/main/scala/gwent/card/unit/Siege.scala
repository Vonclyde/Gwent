package cl.uchile.dcc
package gwent.card.unit

import gwent.card.unit.AbstractUnitCard
import java.util.Objects

/** A Siege Card that extends AbstractUnitCard.
 *
 * @constructor Create a new siege Card with the given name.
 * @author Cristian Salas
 * @version 1.0
 * @since 1.1
 */

class Siege(name: String) extends AbstractUnitCard(name) with Equals {
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Siege]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Siege]
      name == other.name
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[Siege], name)
  }
}
