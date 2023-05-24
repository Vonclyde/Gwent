package cl.uchile.dcc
package gwent.player
package gwent.card

import cl.uchile.dcc.gwent.card.Card
import cl.uchile.dcc.gwent.card.unit.{Melee, Ranged}
import munit.FunSuite

class PlayerTest extends FunSuite {
  val name = "Ramirez"

  var card1: Card = _
  var card2: Card = _
  var card3: Card = _
  var card4: Card = _

  var side: Battleground = _

  var deck: Deck = _
  var hand: Hand = _

  var player: Player = _

  override def beforeEach(context: BeforeEach): Unit = {

    card1 = new Melee("Varian Wrynn")
    card2 = new Ranged("Medivh")
    card3 = new Melee("Arthas Menethil")
    card4 = new Melee("Gromash Hellscream")

    side = new Battleground()

    deck = new Deck(List(card1, card2))
    hand = new Hand(List(card3, card4))

    player = new Player(name, side,2, deck, hand)

  }

  test("Two players with the same name means that they are the same") {
    assertEquals(new Player(name, side, 2, deck, hand), player)
  }

  test("Player can't be a instance of another class") {
    assert(!player.equals(new Melee(name)))
  }
  /** The next tests are for methods */
  test("Jugador tiene un mazo y una mano") {
    assertEquals(player.deck.size, 2)
    assertEquals(player.deck.cards, List(card1, card2))
    assertEquals(player.hand.size, 2)
    assertEquals(player.hand.cards, List(card3, card4))
  }

  test("Jugador roba una carta del mazo") {
    assertEquals(player.deck, deck)
    assertEquals(player.hand, hand)
    player.draw()

    // Verifying the deck
    assertEquals(player.deck.size, 1)
    assertEquals(player.deck.cards, List(card2))
    assertEquals(player.hand.size, 3)
    assertEquals(player.hand.cards, List(card3, card4, card1))

    // Drawing another card, deck will be empty
    player.draw()
    assertEquals(player.deck.size, 0)
    assertEquals(player.deck.cards, List())
    assertEquals(player.hand.size, 4)
    assertEquals(player.hand.cards, List(card3, card4, card1, card2))

    // Nothing happens when drawing a card, it will prints: Your deck is empty!
    player.draw()
    assertEquals(player.deck.size, 0)
    assertEquals(player.deck.cards, List())
    assertEquals(player.hand.size, 4)
    assertEquals(player.hand.cards, List(card3, card4, card1, card2))
  }

  test("Jugador juega una carta de su mano") {
    // Playing the card at index 1.
    assertEquals(player.hand.size, 2)
    assertEquals(player.hand.cards, List(card3, card4))
    player.play(1)

    // Verifying the hand.
    assertEquals(player.hand.size, 1)
    assertEquals(player.hand.cards, List(card3))

    // Playing the last card at index 0.
    player.play(0)
    assertEquals(player.hand.size, 0)
    assertEquals(player.hand.cards, List())

    // Now Hand is empty, it prints: Your hand is empty!
    player.play(67) // Doesn't matter
    assertEquals(player.hand.size, 0)
    assertEquals(player.hand.cards, List())
  }
}
