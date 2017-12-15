package guru.nidi.wowbagger

import guru.nidi.wowbagger.Wowbagger.trimLines

object Adjectives {
    val list = """
aarig
abegmechet
aghotschet
arrogant
blöd
bünzlig
cheibedoof
choderpflotschig
chotzbrockemässig
chotzpängglig
degoutant
doof
dumm
eländ
eländ(e/s/i) huere(//)
fausch glismet
feiss
futzdumm
füdleblutt
gibuhaarig
gnietig
grusig
gopfertecku(//)
gopferdammt
gääj
hingereglitzt
hingerfotzig
hingerletscht
hingerletscht(e/s/i) huere(//)
hohl
huere(//)
idiotisch
is Hirni gschissen
kuurlig
lamaschig
nüütratzig
nüütwärchig
obergruusig
pseudogschiid
pägguhaarig
quergvoglet
ranzig
schitter
schnarchnasig
schnäderfräsig
strub
unerchannt
ungerbeliechtet
verdammt
verfigget
verhudlet
verreckt
versiechet
vervoglet
vom Aff bissen
wältsch(e/es/i)
""".trimLines().map { Adjective(it) }
}