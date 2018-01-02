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
charesaubig
cheib
cheibedoof
chlin
chlinghüselet
chnütschblau
choderpflotschig
chotzbrockemässig
chotzpängglig
chäferfüdletroch
chäsig
degoutant
doof
doppuchinig
drischaagget
dumm
düregheit
eländ
eländ(e/s/i) huere(//)
fautsch
fautsch glismet
feiss
ful
futzdumm
füdleblutt
gagugälb
gchäppelet
gfräsig
gibuhaarig
giechtig
giggerig
gnietig
grusig
gopfertecku(//)
gopferdammt
grossgchotzet
gruebegrässlech
gschiferlig
gschliferig
gschläfzig
gschniglet
gschämig
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
nüütmerkig
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
verchiset
verchoderet
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
zämegflickt
überegheit
""".trimLines().map { Adjective(it) }
}