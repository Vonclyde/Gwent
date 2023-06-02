package cl.uchile.dcc
package gwent.board

import gwent.card.{Melee, Ranged, Siege}
import gwent.player.Player

/** Class that represents the player's area where his unit cards goes when played according to his type
 *
 * @param meleeZone List holding the melee cards played
 * @param rangedZone List holding the ranged cards played
 * @param siegeZone List holding the siege cards played
 *
 * @author Cristian Salas
 * @since 1.2.0
 * @version 1.0.0
 */
class Battleground {


  private var meleeZone: List[Melee] = List()
  private var rangedZone: List[Ranged] = List()
  private var siegeZone: List[Siege] = List()

  /**
   * Getters to obtain the cards in that area
   */
  def meleeCards: List[Melee] = meleeZone
  def rangedCards: List[Ranged] = rangedZone
  def siegeCards: List[Siege] = siegeZone

  /**
   * Add a melee card to the melee zone
   */
  def addMeleeCard(melee: Melee): Unit = {
   meleeZone = meleeZone :+ melee
  }

  /**
   * Add a ranged card to the ranged zone
   */
  def addRangedCard(ranged: Ranged): Unit = {
    rangedZone = rangedZone :+ ranged
  }

  /**
   * Add a siege card to the siege zone
   */
  def addSiegeCard(siege: Siege): Unit = {
    siegeZone = siegeZone :+ siege
  }
}