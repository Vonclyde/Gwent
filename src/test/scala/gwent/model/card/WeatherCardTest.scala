package cl.uchile.dcc
package gwent.card

import munit.FunSuite

class WeatherCardTest extends FunSuite {
  val name: String = "Ventisca"
  val description: String = "Lluvia de escarcha"
  var weather: WeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    weather = new WeatherCard(name, description)
  }

  test("Weather needs to be created with a name and description") {
    assertEquals(weather.name, name)
    assertEquals(weather.description, description)
    assert(weather.equals(new WeatherCard(name, description)))
  }

  test("Weather card can't be another type of card"){
    assert(!weather.equals(new Melee(name, description)))
  }

  test("The hash code of a weather card is consistent with equals") {
    assertEquals(new WeatherCard(name, description).##, weather.##)
  }
}
