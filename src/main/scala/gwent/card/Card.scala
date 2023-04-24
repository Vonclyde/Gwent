package cl.uchile.dcc
package gwent.card

import java.util.Objects

/** A generic card.
 *
 * @constructor Create a simple card with a name.
 * @param name Name of the card.
 *
 * @author Cristian Salas.
 * @since 1.0.0
 * @version 1.0.0
 */
class Card(val name: String) extends Equals {
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Card]
  
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Card]
      name == other.name
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[Card], name)
  }
}
