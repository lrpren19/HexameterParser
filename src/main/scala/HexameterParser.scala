package edu.holycross.shot.lrp

import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._
import edu.holycross.shot.greek._
import edu.holycross.shot.gsphone._

object HexameterParser {

  def stripNonAlphabetic(gs: GreekString) : String = {
    val noAcc = gs.stripAccent.ascii
    val punctuation= """[\(\)|,;:.'"]""".r
    punctuation.replaceAllIn(noAcc, "")
  }

}
