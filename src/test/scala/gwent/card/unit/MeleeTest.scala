package cl.uchile.dcc
package gwent.card.unit

import munit.FunSuite

class MeleeTest extends FunSuite {
  val name: String = "Bolvar"
  var melee: Melee = _

  override def beforeEach(context: BeforeEach): Unit = {
    melee = new Melee(name)
  }

  test("Melee unit card can be created with a name"){
    assertEquals(new Melee(name), melee)
  }

  test("Melee unit card can't be an instance of another class") {
    assert(!melee.equals(new Ranged(name)))
    assert(!melee.equals(new Siege(name)))
  }

  test("The hash code of a melee card is consistent with equals") {
    assertEquals(new Melee(name).##, melee.##)
  }

}