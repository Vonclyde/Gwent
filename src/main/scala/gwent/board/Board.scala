package cl.uchile.dcc
package gwent.board

import gwent.card.{Card, WeatherCard}

import cl.uchile.dcc.gwent.player.Player

class Board(val player: Player, val cpu: Player){
  private var currentWeather: WeatherCard = new WeatherCard("Clear Weather")

  def changeWeather(newWeather: WeatherCard): Unit = {
    currentWeather = newWeather
  }
}
