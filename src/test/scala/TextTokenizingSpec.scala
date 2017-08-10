package edu.holycross.shot.lrp
import org.scalatest.FlatSpec

import edu.holycross.shot.greek._
import edu.holycross.shot.gsphone._


class TextTokenizingSpec extends FlatSpec {



 it should "bring a Unicode string into a vector of syllable strings" in {
   // test gs_phone library's syllabification
   val line = "ἡρώων, αὐτοὺς δὲ ἑλώρια τεῦχε κύνεσσιν"
   val wordsVector = line.split(" ").toVector
   val gsVector = wordsVector.map(LiteraryGreekString(_))


   println("Original line: \n" + line + "\n")
   println("Vector of white-space delimited Greek words:\n" + gsVector + "\n")
   println("\nSyllabified:")
   val sylls = LGSyllable.syllabify(gsVector)
   println(sylls.map(_.ucode).mkString(" -- "))

 }
}
