package edu.holycross.shot.lrp
import org.scalatest.FlatSpec

import edu.holycross.shot.greek._



class HexameterScansionSpec extends FlatSpec {

  "A HexameterScansion" should "have five feet" in {

    val iliad_1_1 = HexameterScansion(Dactyl, Dactyl, Spondee, Dactyl, Dactyl)

    val expectedDactyls = 4
    assert(iliad_1_1.dactyls == expectedDactyls)

    val expectedSpondees = 1
    assert(iliad_1_1.spondees == expectedSpondees)

  }

  "The Scansions object" should "contain all possible scansions of hexameters" in {
    assert(Scansions.hexameter_1_1 == HexameterScansion(Spondee,Spondee,Spondee,Spondee,Spondee))
  }

  it should "have a total of 32 patterns" in pending
  // Scansions.asVector.size == 32
}
