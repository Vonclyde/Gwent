package cl.uchile.dcc
package gwent.card

import munit.FunSuite
class CardTest extends FunSuite {
  val name = "Thrall"
  var card: Card = _
  override def beforeEach(context: BeforeEach): Unit = {
    card = new Card(name)
  }

  test("Una carta debe tener un nombre"){
    assertEquals(new Card(name), card)
  }

  test("The hash code of a ranged card is consistent with equals") {
    assertEquals(new Card(name).##, card.##)
  }
}