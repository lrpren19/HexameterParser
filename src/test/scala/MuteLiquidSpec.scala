package edu.holycross.shot.lrp
import org.scalatest.FlatSpec

import edu.holycross.shot.greek._



class MuteLiquidSpec extends FlatSpec {

  "A HexameterParser"  should  "be able to apply the mute+liquid exception on request" in {
    val unmodified = "οἴξασα κληῗδι"
    val expected = "oi)/casa khi=+di"
    val modified = HexameterParser.muteLiqdRule(unmodified)
    assert (modified == expected)
  }

  it should "apply mute-liquid rule if no analyses possible otherwise" in {
    val problemLine = "οὐδ᾽ ὅ γε πρὶν Δαναοῖσιν ἀεικέα λοιγὸν ἀπώσει"
    val analyzed = HexameterParser.scan(problemLine)
    assert(analyzed.size == 2)
  }


  it should "recognize and apply synezesis" in {
    val problemLine = "οἴκοι ἔχειν: καὶ γάρ ῥα Κλυταιμνήστρης προβέβουλα"
    val analyzed = HexameterParser.scan(problemLine)
    assert(analyzed.size == 2)
  }


}
