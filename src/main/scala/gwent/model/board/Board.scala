package cl.uchile.dcc
package gwent.board

import cl.uchile.dcc.gwent.card.WeatherCard

/** Class that the represent the board in a gwent match.
 * A gwent match requires 2 players, also there is a area for the weather that affects the cards in the player's battleground.
 *
 * @param _player Player that represent us playing the game
 * @param _cpu Player that represents the enemy, the cpu plays according to the situation in the board. Not implemented yet.
 *
 * @author Cristian Salas
 * @since 1.2.0
 * @version 1.0.0
 */

class Board(private val _player: Player, private val _cpu: Player){

  /**
   * @param _currentWeather Current weather affecting the board state.
   */
  private var _currentWeather: WeatherCard = new WeatherCard("Sky Clear",
   "A beautiful blue sky")

  /**
   * Getters for the player, cpu player and the current weather.
   */
  def player: Player = _player

  def cpu: Player = _cpu

  def currentWeather: WeatherCard = _currentWeather

  /**
   * Setter for a new weather when a Weather Card is played.
   */
  def changeWeather(newWeather: WeatherCard): Unit = {
    _currentWeather = newWeather
  }
}
