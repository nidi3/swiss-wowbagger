package guru.nidi.wowbagger

import guru.nidi.wowbagger.Wowbagger.trimLines

object Adjectives {
    val list = """
abegmechet
arrogant
blöd
bünzlig
cheibedoof
chotzbrockemässig
chotzpängglig
degoutant
doof
dumm
eländ
eländ(e/s/i) huere(//)
futzdumm
gibuhaarig
gnietig
gopfertecku(//)
gopferdammt
hingereglitzt
hingerfotzig
hingerletscht
hingerletscht(e/s/i) huere(//)
hohl
huere(//)
idiotisch
is Hirni gschissen
nüütratzig
nüütwärchig
obergruusig
pseudogschiid
pägguhaarig
quergvoglet
ranzig
schnarchnasig
strub
ungerbeliechtet
verdammt
verfigget
verreckt
versiechet
vervoglet
vom Aff bissen
""".trimLines().map { Adjective(it) }
}