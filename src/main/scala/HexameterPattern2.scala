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



object Scansions {
  val hexameter_1_1 = HexameterScansion(Spondee,Spondee,Spondee,Spondee,Spondee)
  val hexameter_1_2 = HexameterScansion(Dactyl,Spondee,Spondee,Spondee,Spondee)

  def asVector: Vector[HexameterScansion] = {
    Vector(hexameter_1_1,
      hexameter_1_2)
  }
}

//case class HexameterPattern2(id: String, scansion: HexameterScansion) {

/*
1.1 S S S S S X
2.1 D S S S S X
2.2 S D S S S X
2.3 S S D S S X
2.4 S S S D S X
2.5 S S S S D X
3.1 D D S S S X
3.2 S D D S S X
3.3 S S D D S X
3.4 S S S D D X
3.5 D S D S S X
3.6 D S S D S X
3.7 D S S S D X
3.8 S D S D S X
3.9 S D S S D X
3.10 S S D S D X
4.1 S S D D D X
4.2 D S S D D X
4.3 D D S S D X
4.4 D D D S S X
4.5 S D S D D X
4.6 S D D S D X
4.7 S D D D S X
4.8 D S D S D X
4.9 D S D D S X
4.10 D D S D S X
5.1 S D D D D X
5.2 D S D D D X
5.3 D D S D D X
5.4 D D D S D X
5.5 D D D D S X
6.1 D D D D D X
*/
