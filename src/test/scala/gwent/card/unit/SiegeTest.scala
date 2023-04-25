package cl.uchile.dcc
package gwent.card.unit

import munit.FunSuite

class SiegeTest extends FunSuite {
  val name: String = "Sylvanas"
  var siege: Siege = _

  override def beforeEach(context: BeforeEach): Unit = {
    siege = new Siege(name)
  }

  test("Siege unit card can be created with a name"){
    assertEquals(new Siege(name), siege)
  }

  test("Siege unit card can't be an instance of another class") {
    assert(!siege.equals(new Ranged(name)))
    assert(!siege.equals(new Melee(name)))
  }

  test("The hash code of a siege card is consistent with equals") {
    assertEquals(new Siege(name).##, siege.##)
  }
}
