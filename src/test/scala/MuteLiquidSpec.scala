package edu.holycross.shot.lrp
import org.scalatest.FlatSpec

import edu.holycross.shot.greek._



class MuteLiquidSpec extends FlatSpec {

  "A HexameterParser"  should  "be able to apply the mute+liquid exception on request" in {
    val unmodified = "oicasa klhi+di"
    val expected = "oicasa khi+di"
    val modified = HexameterParser.muteLiqdRule(unmodified)
    assert (modified == expected)
  }



}
