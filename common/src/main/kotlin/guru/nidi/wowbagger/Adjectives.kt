package guru.nidi.wowbagger

import guru.nidi.wowbagger.Wowbagger.trimLines

object Adjectives {
    val list = """
aarig
aabrönt
aabislet
aagchaflet
aagchätschet
aagfigget
abegmechet
abgfigget
abgnaget
abgsärblet
abgschiffet
abverheit
aghotschet
agnöttelet
agschissen
arrogant
blöd
bireweich
bockstössig
breitarschig
böckelig
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
gagugälb
gibuhaarig
gnietig
grusig
gopfertecku(//)
gopferdammt
gruebegrässlech
gschiferlig
gschläfzig
gschniglet
gstabig
gääj
halbbatzig
himutrurig
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
mies(e/es/i)
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
steihässlech
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
verbrunzet
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