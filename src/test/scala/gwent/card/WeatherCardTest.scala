package cl.uchile.dcc
package gwent.card

import munit.FunSuite

class WeatherCardTest extends FunSuite {
  val name: String = "Blizzard"
  var weather: WeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    weather = new WeatherCard(name)
  }

  test("Weather card can be created with a name") {
    assertEquals(new WeatherCard(name), weather)
  }

  test("The hash code of a weather card is consistent with equals") {
    assertEquals(new WeatherCard(name).##, weather.##)
  }
}
