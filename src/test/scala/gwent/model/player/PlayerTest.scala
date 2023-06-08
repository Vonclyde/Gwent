package cl.uchile.dcc
package gwent.model.player

import gwent.board.Battleground
import gwent.card.{Melee, Ranged}

import cl.uchile.dcc.gwent.player.{Deck, Hand, Player}
import munit.FunSuite

class PlayerTest extends FunSuite {
  val name = "Ramirez"

  var card1: Melee = _
  var card2: Ranged = _
  var card3: Melee = _
  var card4: Melee = _

  var side: Battleground = _

  var deck: Deck = _
  var hand: Hand = _

  var player: Player = _

  override def beforeEach(context: BeforeEach): Unit = {

    card1 = new Melee("Varian Wrynn")
    card2 = new Ranged("Medivh")
    card3 = new Melee("Arthas Menethil")
    card4 = new Melee("Gromash Hellscream")

    side = new Battleground

    deck = new Deck(List(card1, card2))
    hand = new Hand(List(card3, card4))

    player = new Player(name, side, 2, deck, hand)
  }

  test("A player needs to be initialized with a name, a battleground," +
    "his gems, his deck and hand") {
    assertEquals(player.name, name)
    assertEquals(player.gems, 2)
    assertEquals(new Player(name, side, 2, deck, hand), player)
  }

  test("Player can't be a instance of another class") {
    assert(!player.equals(new Melee(name)))
  }
  /** The next tests are for methods */
  test("Player has a deck and a hand of cards") {
    assertEquals(player.deck.size, 2)
    assertEquals(player.deck.cards, List(card1, card2))
    assertEquals(player.hand.size, 2)
    assertEquals(player.hand.cards, List(card3, card4))
  }

  test("Player draws a card from his deck") {
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
}
