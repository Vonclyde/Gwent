package cl.uchile.dcc
package gwent.board

import cl.uchile.dcc.gwent.card.{Melee, Ranged, Siege, WeatherCard}
import munit.FunSuite

class BattlegroundTest extends FunSuite {

  var card1: Melee = _
  var card2: Ranged = _
  var card3: Siege = _
  var card4: WeatherCard = _
  var currentWeather: WeatherCard = _

  val name: String = "Toro"
  val name2: String = "Matías"
  var battleground: Battleground = _
  var battleground2: Battleground = _

  var hand: Hand = _
  var deck: Deck = _
  var player: Player = _
  var player2: Player = _
  var board: Board = _

  override def beforeEach(context: BeforeEach): Unit = {
    card1 = new Melee("A")
    card2 = new Ranged("B")
    card3 = new Siege("C")
    card4 = new WeatherCard("Torrential Rain", "The rain will" +
      "wash away the blood of the fallen")

    currentWeather = new WeatherCard("Sky clear", "A beautiful blue sky")

    battleground = new Battleground
    battleground2 = new Battleground
    deck = new Deck(List())
    hand = new Hand(List(card1, card2, card3, card4))

    player = new Player(name, battleground, 2, deck, hand)
    player2 = new Player(name2, battleground2, 2, deck, hand)
    board = new Board(player, player2)
  }

  test("Melee card is played"){

    //Check that melee area is empty
    assertEquals(player.battleground.meleeCards, List())
    assertEquals(player.hand.cards, List(card1, card2, card3, card4))

    //Melee card is played
    player.play(0, board)
    assertEquals(player.battleground.meleeCards, List(card1))
    assertEquals(player.hand.cards, List(card2, card3, card4))
  }

  test("Ranged card is played"){
    assertEquals(player.battleground.rangedCards, List())
    assertEquals(player.hand.cards, List(card1, card2, card3, card4))

    //Ranged card is played
    player.play(1, board)
    assertEquals(player.battleground.rangedCards, List(card2))
    assertEquals(player.hand.cards, List(card1, card3, card4))
  }

  test("Siege card is played") {
    assertEquals(player.battleground.rangedCards, List())
    assertEquals(player.hand.cards, List(card1, card2, card3, card4))

    //Siege card is played
    player.play(2, board)
    assertEquals(player.battleground.siegeCards, List(card3))
    assertEquals(player.hand.cards, List(card1, card2, card4))
  }

  test("Weather card is played"){
    assertEquals(player.hand.cards, List(card1, card2, card3, card4))
    player.play(3, board)
    assertEquals(player.hand.cards, List(card1, card2, card3))
    assertEquals(board.currentWeather, card4)
  }

  test("Player has no cards to play") {
    //Check the hand of the player
    assertEquals(player.hand.cards, List(card1, card2, card3, card4))
    //Discarding his hand and then check that the hand is now empty
    player.hand.discardHand()
    assertEquals(player.hand.cards, List())
    assertEquals(player.hand.size, 0)
    //Trying to play anything will result in a text that says "Tu mano está vacía"
    player.play(0, board)
    assertEquals(player.hand.cards, List())
    assertEquals(player.hand.size, 0)
  }
}
