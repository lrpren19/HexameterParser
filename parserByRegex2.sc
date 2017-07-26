
:load imports.sc


val c = CorpusSource.fromFile("iliad-goodlines-ucode.tsv")

val lines = c.nodes.map(_.text)

val greekLines = lines.map( n => LiteraryGreekString(n))

val asciiLines = greekLines.map(_.ascii)


val punctuation= """[\\/\(\)\*|,;:'".=]""".r
val noPunctuation= asciiLines.map(n => punctuation.replaceAllIn(n, ""))

val splitOnDiars = """([hweoaiu])(\+)""".r
val diarsSplit = noPunctuation.map(n => splitOnDiars.replaceAllIn(n," $1 "))

val synizesis="""(ew)\b|(hu)""".r
val synizesisMarked= diarsSplit.map( s => synizesis.replaceAllIn(s,"w"))

val epicCorreption = """((ai)|(au)|(oi)|(ou)|(ui)|(ei)|(eu)|[hw]) *([hwaeiou])""".r
val correpted = synizesisMarked.map(s => epicCorreption.replaceAllIn(s, "? $9"))

val longPosition= """(ai|au|ou|oi|ui|ei|eu|[hweoaiu])( ?)((zyc)|([qrtpsdygklzxcbnmf]( ?)[qrtpsdygklzxcbnmf]))""".r
val longByPosition= correpted.map( n => longPosition.replaceAllIn(n, "-"))

val longNature = """((ai)|(au)|(oi)|(ui)|(ei)|(eu)|(ou)|[hw])""".r
val longByNature = longByPosition.map( s => longNature.replaceAllIn(s,"-"))

val justVowels = """[^hweoiua?-]""".r
val scannable = longByNature.map( s => justVowels.replaceAllIn(s, ""))

//scannable.mkString("\n")
//val h = scannable.groupBy(_.size).mapValues(_.size)
//h.mkString("\n")
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

//scanned6.zip(scanned51).zip(scanned52).zip(scanned53).zip(scanned54).zip(scanned55).zip(scanned41).zip(scanned42).zip(scanned43).zip(scanned44).zip(scanned45).zip(scanned46).zip(scanned47).zip(scanned48).zip(scanned49).zip(scanned410).zip(scanned31).zip(scanned32).zip(scanned33).zip(scanned34).zip(scanned35).zip(scanned36).zip(scanned37).zip(scanned38).zip(scanned39).zip(scanned310).zip(scanned21).zip(scanned22).zip(scanned23).zip(scanned23).zip(scanned24).zip(scanned25).zip(scanned1)

val allPossible = List(diarsSplit,scanned6,scanned51,scanned52,scanned53,scanned54,scanned55,scanned41,scanned42,scanned43,scanned44,scanned45,scanned46,scanned47,scanned48,scanned49,scanned410,scanned31,scanned32,scanned33,scanned34,scanned35,scanned36,scanned37,scanned38,scanned39,scanned310,scanned21,scanned22,scanned23,scanned24,scanned25,scanned1).transpose
val rslt=allPossible.map(n => n.distinct)
val h = rslt.groupBy(_.size)






/**
val scanned6= lengthScannable.map(s => arrang6_1.replaceAllIn(s,"6_1"))
val scanned51= scanned6.map(s => arrang5_1.replaceAllIn(s,"5_1 "))
val scanned52= scanned51.map(s => arrang5_2.replaceAllIn(s,"5_2"))
val scanned53= scanned52.map(s => arrang5_3.replaceAllIn(s,"5_3"))
val scanned54= scanned53.map(s => arrang5_4.replaceAllIn(s,"5_4"))
val scanned55= scanned54.map(s => arrang5_5.replaceAllIn(s,"5_5"))
val scanned41= scanned55.map(s => arrang4_1.replaceAllIn(s,"4_1"))
val scanned42= scanned41.map(s => arrang4_2.replaceAllIn(s,"4_2"))
val scanned43= scanned42.map(s => arrang4_3.replaceAllIn(s,"4_3"))
val scanned44= scanned43.map(s => arrang4_4.replaceAllIn(s,"4_4"))
val scanned45= scanned44.map(s => arrang4_5.replaceAllIn(s,"4_5"))
val scanned46= scanned45.map(s => arrang4_6.replaceAllIn(s,"4_6"))
val scanned47= scanned46.map(s => arrang4_7.replaceAllIn(s,"4_7"))
val scanned48= scanned47.map(s => arrang4_8.replaceAllIn(s,"4_8"))
val scanned49= scanned48.map(s => arrang4_9.replaceAllIn(s,"4_9"))
val scanned410= scanned49.map(s => arrang4_10.replaceAllIn(s,"4_10"))
val scanned31= scanned410.map(s => arrang3_1.replaceAllIn(s,"3_1"))
val scanned32= scanned31.map(s => arrang3_2.replaceAllIn(s,"3_2"))
val scanned33= scanned32.map(s => arrang3_3.replaceAllIn(s,"3_3"))
val scanned34= scanned33.map(s => arrang3_4.replaceAllIn(s,"3_4"))
val scanned35= scanned34.map(s => arrang3_5.replaceAllIn(s,"3_5"))
val scanned36= scanned35.map(s => arrang3_6.replaceAllIn(s,"3_6"))
val scanned37= scanned36.map(s => arrang3_7.replaceAllIn(s,"3_7"))
val scanned38= scanned37.map(s => arrang3_8.replaceAllIn(s,"3_8"))
val scanned39= scanned38.map(s => arrang3_9.replaceAllIn(s,"3_9"))
val scanned310= scanned39.map(s => arrang3_10.replaceAllIn(s,"3_10"))
val scanned21= scanned310.map(s => arrang2_1.replaceAllIn(s,"2_1"))
val scanned22= scanned21.map(s => arrang2_2.replaceAllIn(s,"2_2"))
val scanned23= scanned22.map(s => arrang2_3.replaceAllIn(s,"2_3"))
val scanned24= scanned23.map(s => arrang2_4.replaceAllIn(s,"2_4"))
val scanned25= scanned24.map(s => arrang2_5.replaceAllIn(s,"2_5"))
val scanned1= scanned25.map(s => arrang1_1.replaceAllIn(s, "1_1"))

val test = """([^\_\d]+)""".r
val fails = scanned1.filter( x => test.pattern.matcher(x).matches)
val failsSize= fails.size

val tup = scanned1.zip(diarsSplit)
val tupString = tup.map( tuple => tuple.productIterator.mkString("\t"))
val scanned="""(\d\_\d\d?)(\D+)""".r
val fixed = tupString.map(s => scanned.replaceAllIn(s, "$1"))
val notScanned="""([-?]+)(\s)+([qrtpsdygklzxcbnmfhweoiua])""".r
val fixedd = fixed.map(s => notScanned.replaceAllIn(s, "$3"))
**/
