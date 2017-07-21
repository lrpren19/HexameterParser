package edu.holycross.shot.lrp
import org.scalatest.FlatSpec

import edu.holycross.shot.greek._



class HexameterParserSpec extends FlatSpec {
/*
  "A HexameterParser"  should  "strip punctuation from a Greek string" in {
    val gs = LiteraryGreekString("ἄειδε,")
    val stripped = HexameterParser.stripNonAlphabetic(gs)
    val expected = "aeide"
    assert (stripped == expected)
  }

  "A HexameterParser" should "Isolate vowels that have a diaresis" in {
    val s = "eyxei+"
    val isolated = HexameterParser.isolateDiaresis(s)
    val exp = "eyxe i "
    assert (isolated == exp)
  }
*/
 "A HexameterParser" should "replace uncertain vowels due to epic correption with ?" in {
   val n = "ei o"
   val correpted = HexameterParser.accountForCorreption(n)
   val exp = "? o"
   assert (correpted == exp)
 }


}
