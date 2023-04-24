package cl.uchile.dcc
package gwent.card.unit

import munit.FunSuite

class RangedTest extends FunSuite {
  val name: String = "Sylvanas"
  var ranged: Ranged = _

  override def beforeEach(context: BeforeEach): Unit = {
    ranged = new Ranged(name)
  }

  test("Ranged unit card can be created with a name"){
    assertEquals(new Ranged(name), ranged)
  }

  test("The hash code of a ranged card is consistent with equals") {
    assertEquals(new Ranged(name).##, ranged.##)
  }
}