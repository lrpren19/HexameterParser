package edu.holycross.shot.lrp

import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._
import edu.holycross.shot.greek._
import edu.holycross.shot.gsphone._

object HexameterParser {

/** Returns string of ascii characters without accents, breathings, or punctuation
 *  takes LiteraryGreekString
 *  only keeps diareses and letters
 * @param gs the LiteraryGreekString
*/
  def stripNonAlphabetic(gs: GreekString) : String = {
    val noAcc = gs.stripAccent.ascii
    val punctuation= """[\(\)|,;:.'"]""".r
    punctuation.replaceAllIn(noAcc, "")
  }

/** Returns string with isolated vowels that contain diareses
 *  takes a String of ascii characters
 *  @param s the String of ascii characters
*/
 def isolateDiaresis(s: String) : String = {
   val diaresis = """([hweoaiu])(\+)""".r
   diaresis.replaceAllIn(s, " $1 ")
 }

/** Returns string with vowels or dipthongs that might undergo epic correption marked as "?"
 *  takes a String of ascii characters
 *  accounts for internal epic correption as well
 *  @param s the String
*/
 def accountForCorreption(s: String) : String = {
   val epicCorreption = """(ai|au|oi|ou|ui|ei|eu|[hw]) *([hwaeiou])""".r
   epicCorreption.replaceAllIn(s, "? $2")
 }

 /** Returns string with vowels or dipthongs that are long by position marked as "-"
  *  takes a String of ascii characters
  *  accounts for a vowel or dipthong followed by two consonants or a double consonant
  *  @param s the String
 */
 def longByPosition(s: String) : String = {
   val longPosition= """(ai|au|ou|oi|ui|ei|eu|[hweoaiu])( ?)((zyc)|([qrtpsdygklzxcbnmf]( ?)[qrtpsdygklzxcbnmf]))""".r
   longPosition.replaceAllIn(s, "-$2$3")
 }

 /** Returns String with vowels or dipthongs that are long by nature marked as "-"
  *  takes a String of ascii characters
  *  @param s the String
 */
 def longByNature(s: String) : String = {
  val longNature= """ai|au|oi|ui|ei|eu|ou|[hw]""".r
  longNature.replaceAllIn(s,"-")
 }

 /** Returns String without consonants or spaces, leaves only vowels and lengths ("?" or "-")
  *  @param s the String
 */
 def removeConsonants(s: String) : String = {
  val justVowels = """[^hweoiua?-]""".r
  justVowels.replaceAllIn(s,"")
 }

 /** Returns String that replaces all characters that aren't lengths ("?" or "-") with "?"
  *  @param s the String
 */
 def makeLengths(s: String) : String = {
  val notLengths = """[^?-]""".r
  notLengths.replaceAllIn(s,"?")
 }
 


}
