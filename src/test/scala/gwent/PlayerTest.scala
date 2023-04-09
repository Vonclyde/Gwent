package cl.uchile.dcc
package gwent

import munit.FunSuite
class PlayerTest extends FunSuite {

  var player1: Player = _
  var player2: Player = _

  var deck: Deck = _
  var hand: Hand = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new Player("Ramirez", true, 2, deck, hand)
    player2 = new Player("Slater", false, 2, deck, hand)
  }

  test("Cada jugador debe tener un nombre único"){
    assertEquals(player1.name, "Ramirez")
    assertEquals(player2.name, "Slater")
    assertNotEquals(player1.name, player2.name)
  }

  test("Cada jugador le corresponde una sección del tablero"){
    assertEquals(player1.side, true)
    assertEquals(player2.side, false)
    assertNotEquals(player1.side, player2.side)
  }

  test("Cada jugador debe tener gemas, las que representan la vida"){
    assertEquals(player1.gems, 2)
    assertEquals(player2.gems, 2)
  }
}
