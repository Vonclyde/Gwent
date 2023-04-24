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

  test("The hash code of a melee card is consistent with equals") {
    assertEquals(new Melee(name).##, melee.##)
  }
}