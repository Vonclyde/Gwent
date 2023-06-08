package cl.uchile.dcc
package gwent.card

import gwent.card.{Melee, Ranged, Siege}

import munit.FunSuite

class SiegeTest extends FunSuite {
  val name: String = "Catapulta de despojos"
  val description: String = "Máquina de asedio de los no-muertos"
  val power: Int = 4
  var siege: Siege = _

  override def beforeEach(context: BeforeEach): Unit = {
    siege = new Siege(name, description, power)
  }

  test("Siege unit card can be created with a name"){
    assertEquals(siege.name, name)
    assert(siege.equals(new Siege(name)))
  }

  test("Siege unit card can't be an instance of another class") {
    assert(!siege.equals(new Ranged(name, description, power)))
  }

  test("Obtaining the description and power of a siege card") {
    assertEquals(siege.description, description)
    assertEquals(siege.power, power)
  }

  test("The hash code of a siege card is consistent with equals") {
    assertEquals(new Siege(name, description, power).##, siege.##)
  }
}
