package cl.uchile.dcc
package gwent.card


/** A trait that represent a Unit Card
 *
 * @constructor Create a new Unit Card with the given name
 * @author Cristian Salas
 * @since 1.1
 * @version 1.0
 */

trait UnitCard extends Card {
  /** Name of the card */
  val name: String
  
}
