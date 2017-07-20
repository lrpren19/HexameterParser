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


}
