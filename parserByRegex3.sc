
:load imports.sc


val c = CorpusSource.fromFile("iliad-goodlines-ucode.tsv")

val lines = c.nodes.map(_.text)

def getUrn (s :String) :edu.holycross.shot.ohco2.CitableNode = {
  val ind = lines.indexOf(s)
  c.nodes(ind)

}

def muteLiqdRule(s: String) : String = {
  val consonantLiquid = """([qrtpsdygkzxcbnm])[lr]""".r
  consonantLiquid.replaceAllIn(s,"$1")
}

def stripNonAlphabetic(gs: GreekString) : String = {
  val noAcc = gs.stripAccent.ascii
  val punctuationAndCaps= """[\(\)|,;:.*'"]""".r
  punctuationAndCaps.replaceAllIn(noAcc, "")
}

def isolateDiaresis(s: String) : String = {
 val hash = """#""".r
 val hashesRemoved= hash.replaceAllIn(s," i ")
 val diaresis = """([hweoaiu])(\+)""".r
 diaresis.replaceAllIn(hashesRemoved, " $1 ")
}

def accountForSynezisis(s: String) : String = {
 val synizesis="""(ew)|(hu)""".r
 synizesis.replaceAllIn(s, "w")
}

def accountForCorreption(s: String) : String = {
 val epicCorreption = """(ai|au|oi|ou|ui|ei|eu|[hw]) *((?=[hwaeiou]))""".r
 epicCorreption.replaceAllIn(s, "? $2")
}
def longByPosition(s: String) : String = {
  val longPosition= """(ai|au|ou|oi|ui|ei|eu|[hweoaiu])( *)([zyc]|([qrtpsdygklzxcbnmf]( *)[qrtpsdygklzxcbnmf]))""".r
  longPosition.replaceAllIn(s, "-$2$3")
}
def longByNature(s: String) : String = {
 val longNature= """ai|au|oi|ui|ei|eu|ou|[hw]""".r
 longNature.replaceAllIn(s,"-")
}
def removeConsonants(s: String) : String = {
 val justVowels = """[^hweoiua?-]""".r
 justVowels.replaceAllIn(s,"")
}
def makeLengths(s: String) : String = {
 val notLengths = """[^?-]""".r
 notLengths.replaceAllIn(s,"?")
}

def analyzeLengths(s: String) : String = {
  val gs = LiteraryGreekString(s)
  val nonAB= stripNonAlphabetic(gs)
  val isolateDiars= isolateDiaresis(nonAB)
  val synizesisMarked= accountForSynezisis(isolateDiars)
  val correpted= accountForCorreption(synizesisMarked)
  val lbp= longByPosition(correpted)
  val lbn= longByNature(lbp)
  val noConsonants= removeConsonants(lbn)
  makeLengths(noConsonants)

}

def scanner(s: String ) : List[String] = {
  val arrang1_1="""\A(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\z""".r
  val arrang2_1="""\A(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\z""".r
  val arrang2_2="""\A(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\z""".r
  val arrang2_3="""\A(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\z""".r
  val arrang2_4="""\A(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)\z""".r
  val arrang2_5="""\A(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)\z""".r
  val arrang3_1="""\A(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\z""".r
  val arrang3_2="""\A(-|\?)(-|\?)(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\z""".r
  val arrang3_3="""\A(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)\z""".r
  val arrang3_4="""\A(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)\z""".r
  val arrang3_5="""\A(-|\?)\?\?(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\z""".r
  val arrang3_6="""\A(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)\z""".r
  val arrang3_7="""\A(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)\z""".r
  val arrang3_8="""\A(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)\z""".r
  val arrang3_9="""\A(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)\z""".r
  val arrang3_10="""\A(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)\z""".r
  val arrang4_1="""\A(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\?\?(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)\z""".r
  val arrang4_2="""\A(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)\z""".r
  val arrang4_3="""\A(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)\z""".r
  val arrang4_4="""\A(-|\?)\?\?(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)(-|\?)\z""".r
  val arrang4_5="""\A(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)\z""".r
  val arrang4_6="""\A(-|\?)(-|\?)(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)\z""".r
  val arrang4_7="""\A(-|\?)(-|\?)(-|\?)\?\?(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)\z""".r
  val arrang4_8="""\A(-|\?)\?\?(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)\z""".r
  val arrang4_9= """\A(-|\?)\?\?(-|\?)(-|\?)(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)\z""".r
  val arrang4_10="""\A(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)\z""".r
  val arrang5_1="""\A(-|\?)(-|\?)(-|\?)\?\?(-|\?)\?\?(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)\z""".r
  val arrang5_2="""\A(-|\?)\?\?(-|\?)(-|\?)(-|\?)\?\?(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)\z""".r
  val arrang5_3="""\A(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)\z""".r
  val arrang5_4="""\A(-|\?)\?\?(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)(-|\?)\?\?(-|\?)(-|\?)\z""".r
  val arrang5_5="""\A(-|\?)\?\?(-|\?)\?\?(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)(-|\?)(-|\?)\z""".r
  val arrang6_1="""\A(-|\?)\?\?(-|\?)\?\?(-|\?)\?\?(-|\?)\?\?(-|\?)\?\?(-|\?)(-|\?)\z""".r

  val scanned6= arrang6_1.replaceAllIn(s,"6_1")
  val scanned51= arrang5_1.replaceAllIn(s,"5_1")
  val scanned52=  arrang5_2.replaceAllIn(s,"5_2")
  val scanned53= arrang5_3.replaceAllIn(s,"5_3")
  val scanned54= arrang5_4.replaceAllIn(s,"5_4")
  val scanned55= arrang5_5.replaceAllIn(s,"5_5")
  val scanned41= arrang4_1.replaceAllIn(s,"4_1")
  val scanned42= arrang4_2.replaceAllIn(s,"4_2")
  val scanned43= arrang4_3.replaceAllIn(s,"4_3")
  val scanned44= arrang4_4.replaceAllIn(s,"4_4")
  val scanned45= arrang4_5.replaceAllIn(s,"4_5")
  val scanned46=arrang4_6.replaceAllIn(s,"4_6")
  val scanned47= arrang4_7.replaceAllIn(s,"4_7")
  val scanned48= arrang4_8.replaceAllIn(s,"4_8")
  val scanned49= arrang4_9.replaceAllIn(s,"4_9")
  val scanned410= arrang4_10.replaceAllIn(s,"4_10")
  val scanned31=arrang3_1.replaceAllIn(s,"3_1")
  val scanned32=arrang3_2.replaceAllIn(s,"3_2")
  val scanned33= arrang3_3.replaceAllIn(s,"3_3")
  val scanned34=  arrang3_4.replaceAllIn(s,"3_4")
  val scanned35= arrang3_5.replaceAllIn(s,"3_5")
  val scanned36=  arrang3_6.replaceAllIn(s,"3_6")
  val scanned37=  arrang3_7.replaceAllIn(s,"3_7")
  val scanned38= arrang3_8.replaceAllIn(s,"3_8")
  val scanned39= arrang3_9.replaceAllIn(s,"3_9")
  val scanned310=  arrang3_10.replaceAllIn(s,"3_10")
  val scanned21= arrang2_1.replaceAllIn(s,"2_1")
  val scanned22= arrang2_2.replaceAllIn(s,"2_2")
  val scanned23= arrang2_3.replaceAllIn(s,"2_3")
  val scanned24=  arrang2_4.replaceAllIn(s,"2_4")
  val scanned25= arrang2_5.replaceAllIn(s,"2_5")
  val scanned1= arrang1_1.replaceAllIn(s, "1_1")

  val allPossible = List(scanned6,scanned51,scanned52,scanned53,scanned54,scanned55,scanned41,scanned42,scanned43,scanned44,scanned45,scanned46,scanned47,scanned48,scanned49,scanned410,scanned31,scanned32,scanned33,scanned34,scanned35,scanned36,scanned37,scanned38,scanned39,scanned310,scanned21,scanned22,scanned23,scanned24,scanned25,scanned1)
  allPossible.distinct
}
def scan(s: String) : List[String] = {
  val quantities = analyzeLengths(s)
  scanner(quantities)
}

def scanWithNodes(s:String) = {
  val quantities = analyzeLengths(s)
  val scanned = scanner(quantities)
  scanned.zipWithIndex
}

def scannerHistogram (l :Vector[List[String]]) : Map[String,Int] = {
  l.flatten.filter(n=> n matches """(\d\_\d\d?)""").groupBy(identity).mapValues(_.size)
}
