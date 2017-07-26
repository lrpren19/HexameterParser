package edu.holycross.shot.lrp
import org.scalatest.FlatSpec

import edu.holycross.shot.greek._



class HexameterParserSpec extends FlatSpec {

  "A HexameterParser"  should  "strip punctuation and capitlization from a Greek string" in {
    val gs = LiteraryGreekString("ἄειδε,")
    val stripped = HexameterParser.stripNonAlphabetic(gs)
    val expected = "aeide"
    assert (stripped == expected)
  }

  it should "isolate vowels that have a diaresis" in {
    val s = "eyxei+"
    val isolated = HexameterParser.isolateDiaresis(s)
    val exp = "eyxe i "
    assert (isolated == exp)
  }

 it should "replace uncertain vowels due to epic correption with ?" in {
   val s = "w a ei o"
   val correpted = HexameterParser.accountForCorreption(s)
   val expected = "? a ? o"
   assert (correpted == expected)
 }

 it should "replace vowels/dipthongs that are long by position with -" in {
   val s = "ec"
   val longPosition = HexameterParser.longByPosition(s)
   val expected = "-c"
   assert (longPosition == expected)
 }

 it should "replace vowels/dipthongs that are long by nature with -" in {
   val s = "wka xamai"
   val longNature = HexameterParser.longByNature(s)
   val expected = "-ka xam-"
   assert (longNature == expected)
 }

it should "remove consonants and spaces from a string, leaving only vowels and lengths" in {
   val s = "p-m p-menon"
   val noConsonants = HexameterParser.removeConsonants(s)
   val expected = "--eo"
   assert (noConsonants == expected)
 }

it should "replace all characters that are not a length with '?'" in {
   val s = "--eo"
   val lengths = HexameterParser.makeLengths(s)
   val expected = "--??"
   assert (lengths == expected)
 }

 it should "map a Greek hexameter in Unicode to a string representing lengths" in {
   val quantities = HexameterParser.analyzeLengths("Μῆνιν ἄειδε θεὰ Πηληϊάδεω Ἀχιλῆος")
   val expected = "-??-???-????????"
   assert (quantities == expected)
 }


 it should "scan all possible versions of a line of lengths" in {
    val s= "---???????-????"
    val scanned= HexameterParser.scanner(s)
    val expected = List("---???????-????","4_1","4_5","4_6")
    assert (scanned == expected)
  }

 it should "find a list of all possible analyses of a line for a single hexameter in unicode" in {
    val hex = "Μῆνιν ἄειδε θεὰ Πηληϊάδεω Ἀχιλῆος"
    val analyzed = HexameterParser.scan(hex)
    val expected = List("-??-???-????????","5_3")
    assert(analyzed == expected)
 }
}
