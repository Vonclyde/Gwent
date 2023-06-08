package cl.uchile.dcc
package gwent.card

import gwent.card.{Melee, Ranged, Siege}

import munit.FunSuite

class RangedTest extends FunSuite {
  val name: String = "Sylvanas"
  val description: String = "Reina Banshee"
  val power: Int = 5
  var ranged: Ranged = _

  override def beforeEach(context: BeforeEach): Unit = {
    ranged = new Ranged(name, description, power)
  }

  test("Ranged unit card can be created with a name"){
    assertEquals(ranged.name, name)
    assert(ranged.equals(new Ranged(name)))
  }

  test("Obtaining the description and power of a ranged card") {
    assertEquals(ranged.description, description)
    assertEquals(ranged.power, power)
  }

  test("Ranged unit card can't be an instance of another class") {
    assert(!ranged.equals(new Melee(name, description, power)))
  }

  test("The hash code of a ranged card is consistent with equals") {
    assertEquals(new Ranged(name, description, power).##, ranged.##)
  }
}