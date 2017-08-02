
:load imports.sc


val c = CorpusSource.fromFile("iliad-goodlines-ucode.tsv")

val lines = c.nodes.map(_.text)

val greekLines = lines.map( n => LiteraryGreekString(n))

val asciiLines = greekLines.map(_.ascii)


val punctuation= """[\\/\(\)\*|,;:#'".=]""".r
val noPunctuation= asciiLines.map(n => punctuation.replaceAllIn(n, ""))

val splitOnDiars = """([hweoaiu])(\+)""".r
val diarsSplit = noPunctuation.map(n => splitOnDiars.replaceAllIn(n," $1 "))

val synizesis="""(ew)\b|(hu)""".r
val synizesisMarked= diarsSplit.map( s => synizesis.replaceAllIn(s,"w"))

val epicCorreption = """((ai)|(au)|(oi)|(ou)|(ui)|(ei)|(eu)|[hw]) *([hwaeiou])""".r
val correpted = synizesisMarked.map(s => epicCorreption.replaceAllIn(s, "? $9"))

val longPosition= """(ai|au|ou|oi|ui|ei|eu|[hweoaiu])( *)([zyc]|([qrtpsdygklzxcbnmf]( *)[qrtpsdygklzxcbnmf]))""".r
val longByPosition= correpted.map( n => longPosition.replaceAllIn(n, "-"))

val longNature = """((ai)|(au)|(oi)|(ui)|(ei)|(eu)|(ou)|[hw])""".r
val longByNature = longByPosition.map( s => longNature.replaceAllIn(s,"-"))

val justVowels = """[^hweoiua?-]""".r
val scannable = longByNature.map( s => justVowels.replaceAllIn(s, ""))

//for histogram  use val h = scannable.groupBy(_.size).mapValues(_.size)

val notLengths = """[^?-]""".r
val lengthScannable = scannable.map( s => notLengths.replaceAllIn(s,"?"))


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

val scanned6= lengthScannable.map(s => arrang6_1.replaceAllIn(s,"6_1"))
val scanned51= lengthScannable.map(s => arrang5_1.replaceAllIn(s,"5_1"))
val scanned52= lengthScannable.map(s => arrang5_2.replaceAllIn(s,"5_2"))
val scanned53= lengthScannable.map(s => arrang5_3.replaceAllIn(s,"5_3"))
val scanned54= lengthScannable.map(s => arrang5_4.replaceAllIn(s,"5_4"))
val scanned55= lengthScannable.map(s => arrang5_5.replaceAllIn(s,"5_5"))
val scanned41= lengthScannable.map(s => arrang4_1.replaceAllIn(s,"4_1"))
val scanned42= lengthScannable.map(s => arrang4_2.replaceAllIn(s,"4_2"))
val scanned43= lengthScannable.map(s => arrang4_3.replaceAllIn(s,"4_3"))
val scanned44= lengthScannable.map(s => arrang4_4.replaceAllIn(s,"4_4"))
val scanned45= lengthScannable.map(s => arrang4_5.replaceAllIn(s,"4_5"))
val scanned46= lengthScannable.map(s => arrang4_6.replaceAllIn(s,"4_6"))
val scanned47= lengthScannable.map(s => arrang4_7.replaceAllIn(s,"4_7"))
val scanned48= lengthScannable.map(s => arrang4_8.replaceAllIn(s,"4_8"))
val scanned49= lengthScannable.map(s => arrang4_9.replaceAllIn(s,"4_9"))
val scanned410= lengthScannable.map(s => arrang4_10.replaceAllIn(s,"4_10"))
val scanned31= lengthScannable.map(s => arrang3_1.replaceAllIn(s,"3_1"))
val scanned32= lengthScannable.map(s => arrang3_2.replaceAllIn(s,"3_2"))
val scanned33= lengthScannable.map(s => arrang3_3.replaceAllIn(s,"3_3"))
val scanned34= lengthScannable.map(s => arrang3_4.replaceAllIn(s,"3_4"))
val scanned35= lengthScannable.map(s => arrang3_5.replaceAllIn(s,"3_5"))
val scanned36= lengthScannable.map(s => arrang3_6.replaceAllIn(s,"3_6"))
val scanned37= lengthScannable.map(s => arrang3_7.replaceAllIn(s,"3_7"))
val scanned38= lengthScannable.map(s => arrang3_8.replaceAllIn(s,"3_8"))
val scanned39= lengthScannable.map(s => arrang3_9.replaceAllIn(s,"3_9"))
val scanned310= lengthScannable.map(s => arrang3_10.replaceAllIn(s,"3_10"))
val scanned21= lengthScannable.map(s => arrang2_1.replaceAllIn(s,"2_1"))
val scanned22= lengthScannable.map(s => arrang2_2.replaceAllIn(s,"2_2"))
val scanned23= lengthScannable.map(s => arrang2_3.replaceAllIn(s,"2_3"))
val scanned24= lengthScannable.map(s => arrang2_4.replaceAllIn(s,"2_4"))
val scanned25= lengthScannable.map(s => arrang2_5.replaceAllIn(s,"2_5"))
val scanned1= lengthScannable.map(s => arrang1_1.replaceAllIn(s, "1_1"))

val allPossible = List(c.nodes.map(_.urn),diarsSplit,scanned6,scanned51,scanned52,scanned53,scanned54,scanned55,scanned41,scanned42,scanned43,scanned44,scanned45,scanned46,scanned47,scanned48,scanned49,scanned410,scanned31,scanned32,scanned33,scanned34,scanned35,scanned36,scanned37,scanned38,scanned39,scanned310,scanned21,scanned22,scanned23,scanned24,scanned25,scanned1).transpose
val rslt=allPossible.map(n => n.distinct)
val h = rslt.groupBy(_.size)
