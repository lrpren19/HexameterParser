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

 def isolateDiaresis(s: String) : String = {
   val diaresis = """([hweoaiu])(\+)""".r
   diaresis.replaceAllIn(s, " $1 ")
 }

 def accountForCorreption(s: String) : String = {
   val epicCorreption = """(ai|au|oi|ou|ui|ei|eu|[hw]) *([hwaeiou])""".r
   epicCorreption.replaceAllIn(s, "? $2")
 }

 def longByPosition(s: String) : String = {
   val longPosition= """(ai|au|ou|oi|ui|ei|eu|[hweoaiu])( ?)((zyc)|([qrtpsdygklzxcbnmf]( ?)[qrtpsdygklzxcbnmf]))""".r
   longPosition.replaceAllIn(n, "-")
 }

 def longByNature(s: String) : String = {
  val longNature= """ai|au|oi|ui|ei|eu|ou|[hw]""".r
  longNature.replaceAllIn(s,"-")
 }
}
