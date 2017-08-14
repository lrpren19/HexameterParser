package edu.holycross.shot.lrp


trait Foot

object Spondee extends Foot
object Dactyl extends Foot

/** Class representing the scansion of the first five
* feet of a hexameter.  (Sixth is always anceps.)
*
* @param foot1 Scansion of first foot.
* @param foot2 Scansion of second foot.
* @param foot3 Scansion of third foot.
* @param foot4 Scansion of fourth foot.
* @param foot5 Scansion of fifth foot.
*/
case class HexameterScansion (
  foot1: Foot,
  foot2: Foot,
  foot3: Foot,
  foot4: Foot,
  foot5: Foot
) {


  /** Make scansions accessible as a Vector.
  */
  def toVector: Vector[Foot] = {
    Vector(foot1, foot2, foot3, foot4, foot5)
  }

  /** Number of dactyls in this hexameter.*/
  def dactyls: Int = {
    toVector.filter(_ == Dactyl).size
  }

  /** Number of spondees in this hexameter.*/
  def spondees: Int = {
    toVector.filter(_ == Spondee).size
  }

}


/** Object defining all possible scansions of a hexameter.
*/
object Scansions {
  val hexameter_1_1 = HexameterScansion(Spondee,Spondee,Spondee,Spondee,Spondee)
  val hexameter_2_1 = HexameterScansion(Dactyl,Spondee,Spondee,Spondee,Spondee)
  val hexameter_2_2 = HexameterScansion(Spondee,Dactyl,Spondee,Spondee,Spondee)
  val hexameter_2_3 = HexameterScansion(Spondee,Spondee,Dactyl,Spondee,Spondee)
  val hexameter_2_4 = HexameterScansion(Spondee,Spondee,Spondee,Dactyl,Spondee)
  val hexameter_2_5 = HexameterScansion(Spondee,Spondee,Spondee,Spondee,Dactyl)
  val hexameter_3_1 = HexameterScansion(Dactyl,Dactyl,Spondee,Spondee,Spondee)
  val hexameter_3_2 = HexameterScansion(Spondee,Dactyl,Dactyl,Spondee,Spondee)
  val hexameter_3_3 = HexameterScansion(Spondee,Spondee,Dactyl,Dactyl,Spondee)
  val hexameter_3_4 = HexameterScansion(Spondee,Spondee,Spondee,Dactyl,Dactyl)
  val hexameter_3_5 = HexameterScansion(Dactyl,Spondee,Dactyl,Spondee,Spondee)
  val hexameter_3_6 = HexameterScansion(Dactyl,Spondee,Spondee,Dactyl,Spondee)
  val hexameter_3_7 = HexameterScansion(Dactyl,Spondee,Spondee,Spondee,Dactyl)
  val hexameter_3_8 = HexameterScansion(Spondee,Dactyl,Spondee,Dactyl,Spondee)
  val hexameter_3_9 = HexameterScansion(Spondee,Dactyl,Spondee,Spondee,Dactyl)
  val hexameter_3_10 = HexameterScansion(Spondee,Spondee,Dactyl,Spondee,Dactyl)
  val hexameter_4_1 = HexameterScansion(Spondee,Spondee,Dactyl,Dactyl,Dactyl)
  val hexameter_4_2 = HexameterScansion(Dactyl,Spondee,Spondee,Dactyl,Dactyl)
  val hexameter_4_3 = HexameterScansion(Dactyl,Dactyl,Spondee,Spondee,Dactyl)
  val hexameter_4_4 = HexameterScansion(Dactyl,Dactyl,Dactyl,Spondee,Spondee)
  val hexameter_4_5 = HexameterScansion(Spondee,Dactyl,Spondee,Dactyl,Dactyl)
  val hexameter_4_6 = HexameterScansion(Spondee,Dactyl,Dactyl,Spondee,Dactyl)
  val hexameter_4_7 = HexameterScansion(Spondee,Dactyl,Dactyl,Dactyl,Spondee)
  val hexameter_4_8 = HexameterScansion(Dactyl,Spondee,Dactyl,Spondee,Dactyl)
  val hexameter_4_9 = HexameterScansion(Dactyl,Spondee,Dactyl,Dactyl,Spondee)
  val hexameter_4_10 = HexameterScansion(Dactyl,Dactyl,Spondee,Dactyl,Spondee)
  val hexameter_5_1 = HexameterScansion(Spondee,Dactyl,Dactyl,Dactyl,Dactyl)
  val hexameter_5_2 = HexameterScansion(Dactyl,Spondee,Dactyl,Dactyl,Dactyl)
  val hexameter_5_3 = HexameterScansion(Dactyl,Dactyl,Spondee,Dactyl,Dactyl)
  val hexameter_5_4 = HexameterScansion(Dactyl,Dactyl,Dactyl,Spondee,Dactyl)
  val hexameter_5_5 = HexameterScansion(Dactyl,Dactyl,Dactyl,Dactyl,Spondee)
  val hexameter_6_1 = HexameterScansion(Dactyl,Dactyl,Dactyl,Dactyl,Dactyl)

  /** All scansions, as a Vector.
  */
  def asVector: Vector[HexameterScansion] = {
    Vector(hexameter_1_1,
      hexameter_2_1,
      hexameter_1_1,
      hexameter_2_1,
      hexameter_2_2,
      hexameter_2_3,
      hexameter_2_4,
      hexameter_2_5,
      hexameter_3_1,
      hexameter_3_2,
      hexameter_3_3,
      hexameter_3_4,
      hexameter_3_5,
      hexameter_3_6,
      hexameter_3_7,
      hexameter_3_8,
      hexameter_3_9,
      hexameter_3_10,
      hexameter_4_1,
      hexameter_4_2,
      hexameter_4_3,
      hexameter_4_4,
      hexameter_4_5,
      hexameter_4_6,
      hexameter_4_7,
      hexameter_4_8,
      hexameter_4_9,
      hexameter_4_10,
      hexameter_5_1,
      hexameter_5_2,
      hexameter_5_3,
      hexameter_5_4,
      hexameter_5_5,
      hexameter_6_1
    )
  }
}
