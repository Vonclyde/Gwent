package cl.uchile.dcc
package gwent.board

import cl.uchile.dcc.gwent.card.WeatherCard
import cl.uchile.dcc.gwent.player.Player

class Board(private val _player: Player, private val _cpu: Player){

  private var _currentWeather: WeatherCard = new WeatherCard("Sky Clear",
   "A beautiful blue sky")

  def player: Player = _player

  def cpu: Player = _cpu

  def currentWeather: WeatherCard = _currentWeather

  def changeWeather(newWeather: WeatherCard): Unit = {
    _currentWeather = newWeather
  }
}
