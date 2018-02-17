/*
 * Copyright © 2018 Stefan Niederhauser (nidin@gmx.ch)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package guru.nidi.wowbagger

import guru.nidi.wowbagger.Wowbagger.trimLines

object Adjectives {
    val list = """
aarig | A 300 r i g
aabrönt | A 200 b r 2 n t 200
aabislet | A 200 b i s l @ t 200
aagchaflet | A 200 g x A f l @ t 200
aagchätschet | A 200 g x a t S @ t 200
aagfigget | A 200 g f I g 200 @ t 200
abegmechet | A b @ 150 g m e x 200 @ t 200
abgfigget | A b 100 g f I g 200 @ t 200
abgnaget | A b g n A 200 g @ t 200
abgsärblet | A b g s a r b l @ t 200
abgschiffet | A b g S I f 200 @ t 200
abverheit | A b f e r h e i t 200
aghotschet | A 200 g h O 200 t S @ t 200
agnöttelet | A 200 g n 2 t 200 @ l @ t 200
agschissen | A 200 g S I s 200 @ n
arrogant | A r 200 O g A n t 200
blöd | b l 2 200 d
bireweich | b I r @ w e i x
bockstössig | b O k S t 2 200 s 200 i g
breitarschig | b r e i t _ 30 A r S 200 i g
böckelig | b 2 k h 50 @ l i g
bünzlig | b y n t s l i g
charesaubig | x A r @ s A u b i g
cheib | x e i b
cheibedoof | x e i b @ d O 200 f
chlin | x l i 200 n
chlinghüselet | x l i n _ 50 g 200 h y s l @ t 200
chnütschblau | x n y 50 t S b l A 200 u
choderpflotschig | x O d @ r p f l O t S i g
chotzbrockemässig | x O t s b r O k 200 h 50 @ m a 200 s 200 i g
chotzpängglig | x O t s p a N _ 10 g 200 l I g
chäferfüdletroch | x a f @ r 50 f 2 d l @ t r O x 200
chäsig | x a s i g
degoutant | d e g u t A n t 200
doof | d O 200 f
doppuchinig | d O p 200 u x I n i g
drischaagget | d r i S A 200 g 200 @ t 200
dumm | d u m 200
düregheit | d y r @ g h e i t 200
eländ | e l a n d
eländ(e/s/i) huere(//) | e l a n d (@/s/i) h u @ r @ (//)
fautsch | f A u S
fautsch glismet | f A u S g l I 50 s m @ t 200
feiss | f e i s 200
ful | f u 200 l
futzdumm | f u t s d u m 200
füdleblutt | f y d l @ 50 b l u t 200
gagugälb | g A g u g 50 a l b 50
gchäppelet | g 200 x a p 200 @ 50 l @ t 200
gfräsig | g f r a 200 s i g
gibuhaarig | g I b u h A 200 r i g
giechtig | g 200 i @ x t i g
giggerig | g 200 i g 250 @ r i g
gnietig | g 200 n i e t 200 i g
grusig | g r u 200 s i g
gopfertecku(//) | g 200 O p f @ r t e k h 50 u (//)
gopferdammt | g 200 O p f @ r d a m 250 t 200
grossgchotzet | g 200 r O 200 s g x O t s @ t 200
gruebegrässlech | g r u @ b @ g r a s 200 l @ x
gschiferlig | g S I f @ 10 r l i g
gschliferig | g S l I f e 50 r i g
gschläfzig | k 200 S l a f t s i g
gschniglet | k 200 S n I g l @ t 200
gschämig | k 200 S a m i g
gstabig | k 200 S t A b i g
gääj | g a 200 i
halbbatzig | h A l b _ 10 b A t s i g
himutrurig | h I m u t r u 200 r i g
hingereglitzt | h I N 200 @ r @ g l I t s t 200
hingerfotzig | h I N 200 @ r f o t s i g
hingerbiggelig | h I N 200 @ r b i g 200 @ l i g
hingerletscht | h I N 200 @ r l e t S t 200
hingerletscht(e/s/i) huere(//) | h I N 200 @ r l e t S t (@/s/i) h u @ r @ (//)
hohl | h O 200 l
huere(//) | h u @ r @ (//)
ichegschwärzelet | i x @ g S w a r t s @ 50 l @ t 200
id Chnöde glötet | i t _ 50 x n 2 d @ _ 50 g l 50 2 150 t @ t 200
idiotisch | i d i O t 200 i S
is Hirni gschissen | i s h I r n i _ 50 g S I s 200 @ n
kuurlig | k u 200 r l i g
lahmarschig | l A 200 m A r 200 S i g
lamaschig | l A m A 200 S i g
läufig | l 2 i f 200 i g
lützl | l Y t s l
mies(e/es/i) | m i 200 s (@/@ s/i)
miggerig | m i k 200 @ r i g
muderig | m u d @ r i g
nüütmerkig | n y 200 t m e r k h 50 i 50 g
nüütratzig | n y 200 t r A t s i 50 g
nüütwärchig | n y 200 t w a r x i 50 g
obergruusig | O b @ 50 r g r u 200 s i 50 g
pseudogschiid | p s 2 i d O g S i 200 d
pägguhaarig | p a k 200 u h A 200 r i g
quergvoglet | k 200 w e r g f O g l @ t 200
ranzig | r A n t s i g
rumpelsuurig | r u m p u s u 200 r i 50 g
schitter | S I t 200 @ r
schnarchnasig | S n A 200 r x n A 150 s i g
schnäderfräsig | S n a d @ r f r a 200 s i g
schwauderig | S w A u d @ r i g
steihässlech | S t e i h a s 200 l @ x
strub | S t r u b
süderig | s y d @ r i 50 g
tunggig | t 200 u N k 200 i g
tüfusüchtig | t y 200 f u s y x t i g
umegschläberlet | u m @ g S l a b @ r l @ t 200
unerchannt | u n @ r x A n 200 t 200
ungerbeliechtet | u N @ 50 r b e l i @ x 50 t @ t 200
ulidig | u l i 200 d i g
ugantlig | u g A n t l I 50 g
uschaflig | u S A f l I 50 g
verbibäbbelet | f @ r b i b a 250 p 200 @ 50 l @ t 200
verbrunzet | f @ r b r u n t s @ t 200
verchiset | f @ r x I s @ t 200
verchoderet | f @ r x O d @ r @ t 200
verdammt | f @ r d A m 200 t 200
verfigget | f @ r f I k 200 @ t 200
verhudlet | f @ r h u d l @ t 200
verreckt | f @ r r e k 200 h 50 t 200
versiechet | f @ r 50 s i @ x @ t 200
versouet | f @ r s o u @ t 200
vervoglet | f @ r f O g l @ t 200
vom Aff bissen | f O m _ 20 A f 200 b I s 200 @ n
wältsch(e/es/i) | w a l t S (@/@ s/i)
wüescht | w y @ S t
zämegflickt | t s a m @ g f l I k h 50 t 200
überegheit | y b @ r @ k h 50 @ 50 i t 200
""".trimLines().map { Entry.of(it) { Adjective(it) } }
}