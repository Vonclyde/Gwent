package cl.uchile.dcc
package gwent.card

import gwent.card.{Melee, Ranged, Siege}

import munit.FunSuite

class MeleeTest extends FunSuite {
  val name: String = "Bolvar"
  val description: String = "Carcelero de los Malditos"
  val power: Int = 3
  var melee: Melee = _

  override def beforeEach(context: BeforeEach): Unit = {
    melee = new Melee(name, description, power)
  }

  test("Melee unit card can be created with a name"){
    assertEquals(melee.name, name)
    assert(melee.equals(new Melee(name)))
  }
  test("Obtaining the description and power of a melee card"){
    assertEquals(melee.description, description)
    assertEquals(melee.power, power)
  }
  
  test("Melee unit card can't be an instance of another class") {
    assert(!melee.equals(new Ranged(name, description, power)))
  }

  test("The hash code of a melee card is consistent with equals") {
    assertEquals(new Melee(name, description, power).##, melee.##)
  }
}