package cl.uchile.dcc
package gwent.board

import cl.uchile.dcc.gwent.card.WeatherCard
import cl.uchile.dcc.gwent.player.{Hand, Deck, Player}
import munit.FunSuite

class BoardTest extends FunSuite{

  val name1 = "Clyde"
  val name2 = "Bonnie"

  var side1: Battleground = _
  var side2: Battleground = _

  var deck: Deck =_
  var hand: Hand =_

  var player1: Player = _
  var player2: Player = _

  var board: Board = _
  override def beforeEach(context: BeforeEach): Unit = {

    side1 = new Battleground()
    side2 = new Battleground()

    player1 = new Player(name1, side1, 2, deck, hand)
    player2 = new Player(name2, side2, 2, deck, hand)

    board = new Board(player1, player2)
  }

  test("Board with the same two players is the same"){
    assertEquals(new Board(player1, player2), board)
  }
}
