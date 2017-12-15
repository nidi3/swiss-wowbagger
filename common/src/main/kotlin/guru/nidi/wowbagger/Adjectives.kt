package guru.nidi.wowbagger

import guru.nidi.wowbagger.Wowbagger.trimLines

object Adjectives {
    val list = """
aarig
abegmechet
aghotschet
agnöttelet
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
gschiferlig
gschläfzig
gschniglet
gstabig
gääj
halbbatzig
hingereglitzt
hingerfotzig
hingerbiggelig
hingerletscht
hingerletscht(e/s/i) huere(//)
hohl
huere(//)
ichegschwärzelet
id Chnöde glötet
idiotisch
is Hirni gschissen
kuurlig
lamaschig
läufig
lützl
miggerig
muderig
nüütratzig
nüütwärchig
obergruusig
pseudogschiid
pägguhaarig
quergvoglet
ranzig
rumpelsuurig
schitter
schnarchnasig
schnäderfräsig
schwauderig
strub
süderig
tunggig
tüfusüchtig
umegschläberlet
unerchannt
ungerbeliechtet
ulidig
ugantlig
uschaflig
verbibäbbelet
verdammt
verfigget
verhudlet
verreckt
versiechet
versouet
vervoglet
vom Aff bissen
wältsch(e/es/i)
wüescht
""".trimLines().map { Adjective(it) }
}