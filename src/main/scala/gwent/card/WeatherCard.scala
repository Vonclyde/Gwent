package cl.uchile.dcc
package gwent.card

import gwent.card.Card

/** A weather card, it extends Card.
 *
 * @constructor Create a weather card with a given name.
 * @param name Name of the weather card.
 * @author Cristian Salas
 * @since 1.0.0
 * @version 1.0.0
 */
class WeatherCard(override val name: String) extends Card(name) with Equals {
  /** Same methods of Card */
}
