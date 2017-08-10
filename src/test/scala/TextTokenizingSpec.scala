package edu.holycross.shot.lrp
import org.scalatest.FlatSpec

import edu.holycross.shot.greek._



class TextTokenizingSpec extends FlatSpec {

  "A HexameterParser" should  "isolate vowels that have a diaresis" in {
    val s = "atrei+dhs"
    val isolated = HexameterParser.tokenizeDiaeresis(s)
    val exp = "atre i dhs"
    assert (isolated == exp)
  }

 it should "replace uncertain vowels due to epic correption with ?" in pending

 it should "replace vowels/dipthongs that are long by position with -" in pending

 it should "replace vowels/dipthongs that are long by nature with -" in pending

it should "remove consonants and spaces from a string, leaving only vowels and lengths" in pending

it should "replace all characters that are not a length with '?'" in  pending

 it should "map a Greek hexameter in Unicode to a string representing lengths" in pending

 it should "scan all possible versions of a line of lengths" in pending

 it should "find a list of all possible analyses of a line for a single hexameter in unicode" in pending
}
