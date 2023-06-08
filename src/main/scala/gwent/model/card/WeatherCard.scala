package cl.uchile.dcc
package gwent.card

import cl.uchile.dcc.gwent.board.Board

import java.util.Objects

/** A weather card, it extends Card.
 *
 * @param _name Name of the weather card.
 * @param _description Description of what does the weather provided by the card.
 * @constructor It creates a weather card with a given name.
 *
 * @author Cristian Salas
 * @since 1.0.0
 * @version 1.0.0
 */
class WeatherCard(private val _name: String, private val _description: String) extends Card with Equals {
  
  def name: String = _name
  def description: String = _description
  
  /**
   * When a weather card is played, it changes the current weather of the board.
   * @param player It receives the player who play the card, in this particular function of WeatherCard is not used.
   * @param board Receives the board in which the weather is gonna be changed 
   */
  override def played(player: Player, board: Board): Unit = {
    board.changeWeather(this)
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[WeatherCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[WeatherCard]
      this.name == other.name
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[WeatherCard], name)
  }
}
