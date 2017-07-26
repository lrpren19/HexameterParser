package edu.holycross.shot.lrp
import org.scalatest.FlatSpec

import edu.holycross.shot.greek._



class HexameterParserSpec extends FlatSpec {

  "A HexameterParser"  should  "strip punctuation from a Greek string" in {
    val gs = LiteraryGreekString("ἄειδε,")
    val stripped = HexameterParser.stripNonAlphabetic(gs)
    val expected = "aeide"
    assert (stripped == expected)
  }

  "A HexameterParser" should "isolate vowels that have a diaresis" in {
    val s = "eyxei+"
    val isolated = HexameterParser.isolateDiaresis(s)
    val exp = "eyxe i "
    assert (isolated == exp)
  }

 "A HexameterParser" should "replace uncertain vowels due to epic correption with ?" in {
   val s = "ei o"
   val correpted = HexameterParser.accountForCorreption(s)
   val expected = "? o"
   assert (correpted == expected)
 }

 "A HexameterParser" should "replace vowels/dipthongs that are long by position with -" in {
   val s = "pem pwmenon"
   val longPosition = HexameterParser.longByPosition(s)
   val expected = "p-m pwmenon"
   assert (longPosition == expected)
 }

 "A HexameterParser" should "replace vowels/dipthongs that are long by nature with -" in {
   val s = "wka xamai"
   val longNature = HexameterParser.longByNature(s)
   val expected = "-ka xam-"
   assert (longNature == expected)
 }

 "A HexameterParser" should "remove consonants and spaces from a string, leaving only vowels and lengths" in {
   val s = "p-m p-menon"
   val noConsonants = HexameterParser.removeConsonants(s)
   val expected = "--eo"
   assert (noConsonants == expected)
 }

 "A HexameterParser" should "replace all characters that are not a length with '?'" in {
   val s = "--eo"
   val lengths = HexameterParser.makeLengths(s)
   val expected = "--??"
   assert (lengths == expected)
 }


 "A HexameterParser" should "scann all possible versions of a line of lengths" in {
   val s= "---???????-????"
   val scanned= HexameterParser.scanner(s)
   val expected = List("---???????-????","4_1","4_5","4_6")
   assert (scanned == expected)
 }

 it should "map a Greek hexameter in Unicode to a string representing lengths" in {
   val quantities = HexameterParser.analyzeLengths("Μῆνιν ἄειδε θεὰ Πηληϊάδεω Ἀχιλῆος")
   val expected = "-??-???--????-?"
   assert (quantities == expected)
 }

 it should "find a list of all possible analyses of a line for a single hexameter" in {
    val hex = "Μῆνιν ἄειδε θεὰ Πηληϊάδεω Ἀχιλῆος"
    val analyzed = HexameterParser.scan(hex)
    val expected = List("---???????-????","4_1","4_5","4_6")
    assert(analyzed == expected)
 }
}
