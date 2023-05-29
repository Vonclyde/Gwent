package cl.uchile.dcc
package gwent.board

import gwent.card.{Melee, Ranged, Siege}
import gwent.player.Player


class Battleground {

  private var meleeZone: List[Melee] = List()
  private var rangedZone: List[Ranged] = List()
  private var siegeZone: List[Siege] = List()
  
  def meleeCards: List[Melee] = meleeZone
  def rangedCards: List[Ranged] = rangedZone
  def siegeCards: List[Siege] = siegeZone

  def addMeleeCard(melee: Melee): Unit = {
   meleeZone = meleeZone :+ melee
  }
  def addRangedCard(ranged: Ranged): Unit = {
    rangedZone = rangedZone :+ ranged
  }
  def addSiegeCard(siege: Siege): Unit = {
    siegeZone = siegeZone :+ siege
  }
}
