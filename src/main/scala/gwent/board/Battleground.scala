package cl.uchile.dcc

import gwent.card.unit.{Melee, Ranged, Siege}
import cl.uchile.dcc.gwent.player.Player


class Battleground(){

  protected var meleeZone: List[Melee] = List()
  protected var rangedZone: List[Ranged] = List()
  protected var siegeZone: List[Siege] = List()

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
