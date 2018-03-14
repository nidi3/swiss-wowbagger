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

object Subjects {
    val list = """
m Aargouer Outofahrer | A 200 r g o u @ r _ 50 o u t o f A 200 r @ r 200
f Achermähre(/ne) | A x 200 @ r m a 200 r @ (/n @ 150)
m Aff(/e) | A f 300 (/@ 150)
m Angschthas(/e) | A N S t h A 200 s (/@ 150)
m Armlüchter
m Arschchäfer(/e) | A 200 r S x a f @ r (/@ 150)
f Arschgige(/ne) | A 200 r S g i 200 g @ (/n @ 150)
m Arschgig(u/le) | A 200 r S g I g (u 150/l @ 150)
n Arschkantefilet | A 200 r S k 100 h 50 A n t @ f i l e 200
m Aschi | A 150 S i
n Aupech(aub/äuber) | A u p @ x (A u b 200/a u b @ r)
f Baabe(/ne) | b A 200 p @ (/n @ 150)
f Bagglimoore(/ne) | b A g 200 l i m O 200 r @ (/n @ 150)
n Baslerbebbi(/s) | b A s l @ r b e b 200 i (/s 150)
m Batzechlemmer | b A t s @ x l e m 200 @ r
m Bettseicher | b e t s e i x @ r
n Bipperlisi(/s) | b I p 200 @ r l i s i (/s 150)
m Bisibueb(/e) | b i s i b u @ b (/@ 150)
n Bisibääbi | b i s i b a 200 b i
m Bisitrinker | b i s i t r I N k h 50 @ r
m Blickläser | b l I k 200 h 50 l a s @ r
m Blödian(/e) | b l 2 200 d i a 150 n (/@ 150)
m Blöffs(ack/eck) | b l 2 f 200 s (A k h 50/e k h 50)
n Bohner(oss/össer) | b O 200 n @ r (O s 300/2 s 200 @ r)
f Bohnestange(/ne) | b O 200 n @ S t A 150 N @ (/n @ 150)
m Braschti(/ne) | b r A S 150 t i (/n @ 150)
m Brämeständer | b r a 200 m @ S t a n d @ r
m Bschish(ung/üng) | b S i s h (u N _ 50/Y N _ 50)
f Bännes(ou/öi) | b a n 200 @ s (o u/2 i)
f Bärgänte(/ne) | b a r k 200 _ 20 a n t @ (/n @ 150)
m Bäse(/ne) | b a s @ (/n @ 150)
n Bäserääf | b a s @ r a 250 f 200
m Bääggisiech(/e) | b a 200 g 200 i s i @ x (/@ 150)
f Bire(/ne) | b I r @ (/n @ 150)
m Birewixer | b I r @ w I g s @ r
m Bhouptisiech(/e) | b 300 h o u p 200 t i s i @ x (/@ 150)
m Bööggefrässer | b 2 200 k 200 @ f r a s 200 @ r
m Büff(u/le) | b Y f 200 (u/l @ 150)
m Bünzli(/s) | b Y n t s l i (/s 150)
m Bürokolleg(/e) | b Y r O k 200 h 20 O l e 200 k 200 (/@ 150)
m Chafler | x A f l @ r
m Chaflicheib(/e) | x A f l i x e i b (/@ 150)
m Chatzestrecker | x A t s @ S t r e k 200 h 50 @ r
m Chegelebrägler | x e g @ l @ b r a g l @ r
m Cheib(/e) | x e i b (/@ 150)
m Chirschigägger | x i r S i 50 g 200 a g 200 @ r
m Chiubi-Gig(u/le) | x i u b i k I k (u/l @ 150)
f Chleech(ue/üe) | x l e 200 x (u @/y @)
f Chlefe(/ne) | x l e f @ (/n @ 150)
n Chlepfschit(/ter) | x l e p f S i t 200 h 50 (/@ r)
m Chnorzi(/ne) | x n O r t s i (/n @ 150)
m Chnüblisiech(/e) | x n y 200 b l i s i e x (/@ 150)
m Chotzchüb(u/le) | x o t s x Y b (u/l @ 150)
m Choderi(/ne) | x o d @ r i (/n @ 150)
m Chodermoore(/ne)
m Choles(ack/eck) | x O l @ s (A k 200 h 50/e k 200 h 50)
m Chouderi(/ne) | x O u d @ r i (/n @ 150)
m Chrüppucheib(/e) | x r Y p 200 u x e i b (/@ 150)
m Chrüppuh(ung/üng) | x r Y p 200 u h (u N g/y N g)
n Chuderluuri | x u d @ r l u 200 r i
n Chuefüdle | x u @ f Y d l @
m Chutzemischt | x u t s @ m I S d
m Chüttenechotzer | x Y t 200 @ n @ x o t s @ r
m Chuttlefrässer | x u t 200 l @ f r a s 200 @ r
m Chääri(/ne) | x a 200 r i (/n @ 150)
m Chöözi(/ne) | x 2 200 t s i (/n @ 150)
n Dascheli | d A S @ l i
n Doggeli | d O k 200 @ l i
m Dorfmuni(/ne) | d O r f m u n i (/n @ 150)
m Dräcks(ack/eck) | d r a k s (A k 200 h 50/e k 200 h 50)
m Düppugring(/e) | d Y p 200 u g r I N g (/@ 150)
n Eiterbibeli | e i t 200 @ r b i b @ l i
m Figgfähler | f I k 200 f a 200 l @ r
f Filzl(uus/üüs) | f I u t s l (u 200 s/y 200 s)
n Finöggeli | f i n 2 k 200 @ l i
m Fleischv(ogu/ögu) | f l e i S f (O g u/2 g u)
n Flöigehirni | f l 2 i g @ 50 h I r n i
m Fotzucheib(/e) | f O t s u x e i b (/@ 150)
m Fridhofjödeler | f r I d h O f i 2 d @ l @ r
m Frässh(ung/üng) | f r a s 200 h (u N g/Y N g)
m Fuschti(/ne) | f u 200 S t i (/n @ 150)
m F(utz/ütz) | f (u t s/Y t s)
m Futzbu(ur/re) | f u t s p (u 200 r/u r @ 150)
m Futzgring(/e) | f u t s g r i N g (/@ 150)
m Füdlibürger | f Y d 50 l i b Y r g @ r
n Fägnäscht(/er) | f a g n a S d (/@ r)
f Färlimore(/ne) | f a 200 r l i m O 200 r @ (/n @ 150)
m Fätze | f a t s @
m Fötz(u/le) | f 2 t s (u/l @ 150)
m Fötzucheib(/e) | f 2 t s u x e i b (/@ 150)
m Fötzusiech(/e) | f 2 t s u s i e x (/@ 150)
m Gaggelari(/ne) | g A k 200 @ l A 200 r i (/n @ 150)
m Galööri(/ne) | g A l 2 200 r i (/n @ 150)
m Gartefeschtplouderi(/ne) | g A r t @ f e S t p l o u d @ r i (/n @ 150)
m Ghüderi(/ne) | g 200 h Y d @ r i (/n @ 150)
f Gibe(/ne) | g i b @ (/n @ 150)
m Gig(u/le) | g I g (u/l @ 150)
m Gigusiech(/e) | g I g u s i e x (/@ 150)
m Gitzeler | g I t s @ l @ r
m Gitzgnäpper(/e) | g i t s g n a p 200 @ r (/@ 150)
n Gjätt | k i 50 a d 200
f Gjätthäse(/ne) | k i 50 a t 200 h a s @ (/n @ 150)
m Gfröörli(/ne) | g f r 2 200 r l i (/n @ 150)
m Glaraff(/e) | k l A r A f 300 (/@ 150)
m Globiv(ogu/ögu) | g l O p i f (o g u/2 g u)
m Glögglifrösch(/e) | g l 2 g 200 l i f r 2 S 200 (/@ 150)
m Glünggi(/ne) | g l Y N k 200 i (/n @ 150)
m Glüschteler | g l Y S t @ l @ r
m Gmeinsmuni(/ne) | g m e i n s m u n i (/n @ 150)
f Gmüetsmoore(/ne) | g m y @ t s m O 200 r @ (/n @ 150)
m Gnieti(/ne) | g n i @ t 200 i (/n @ 150)
m Goof(/e) | k O 200 f (/@ 150)
m Gorilla Blau(arsch/ärsch) | g O r i l 200 A b l A 200 u (A 200 r S 200/a 200 r S 200)
n Grillehirni | g r I l 200 @ h I r n i
m Grittibänz(/e) | g r I t 200 i b a n t s (/@ 150)
m Groggermooslaferi(/ne) | g r O g 200 @ r m O 200 s l A f @ r i (/n @ 150)
m Gränni(/ne) | g r a n 200 i (/n @ 150)
m Grümscheler | g r Y m S @ l @ r
m Grüs(u/le) | g r y 200 s (u/l @ 150)
m Gschtabi(/ne) | k S t A b i (/n @ 150)
m Gschtabicheib(/e) | k S t A b i x e i b (/@ 150)
n Gschwür | k S w y r
m Gummih(aus/äus) | g u m i h (A u s 200/a u s 200)
f Gumsle(/ne) | g u m s l @ (/n @ 150)
m Gugaagger | g u g A 200 g 200 @ r
f Gure(/ne) | g u r @ (/n @ 150)
m Gwaggli(/ne) | g w A k 200 l i (/n @ 150)
m Gäderhäch(u/le) | g a d @ r h a x 200 (u/l @ 150)
n Gäderiwyb(/er) | g a d @ r i w i 200 p h 50 (/@ r)
n Gäderimanndli | g a d @ r m A n 200 d l i
m Gäägerehub(u/le) | g a 200 k 200 @ r @ h u b (u/l @ 150)
m Göiferisiech(/e) | g 2 i f @ r i s i @ x (/@ 150)
m Göigg(u/le) | g 2 i k 200 h 10 (u/l @ 150)
m Göferlimuni(/ne) | g 2 f @ r l i m u n i (/n @ 150)
n Güezi | g y @ t s i
m Haagge(/ne) | h A 200 k 200 @ (/n @ 150)
n Haaghuuri | h A 200 g h u 200 r i
m Habasch(/e) | h A 50 b A S 200 (/@ 150)
f Hafehuer(/e) | h A f @ h u @ r (/@ 150)
m Hag(u/le) | h A g (u/l @ 150)
m Heilandtonner | h e i l A n d t o n 200 @ r
m Hodegemschi(/s)
m Hornochs(/e) | h O r n O x s (/@ 150)
m Hudilump(/e) | h u d i l u m p (/@ 150)
n Hundshammli | h u n d s h A m 200 l i
f Hundsniere(/ne) | h u n d s n i @ r @ (/n @ 150)
m Hueresiech(/e) | h u @ r @ s i @ x (/@ 150)
m Hurli-Gw(aag/ääg) | h u r l i g 200 w (A 200 k 200 h 50/a 200 k 200 h 50)
m Hurrlibueb(/e) | h u r r l i b u @ p (/@ 150)
m Höseler | h 2 s @ l @ r
m Höuz(u/le) | h 2 u t s (u/l @ 150)
m Im-Kreisu-Links-Blinker | i m k r e i s u l I n k s b l I N k 200 @ r
m Krouteri(/ne) | k 200 r o u t 200 @ r i (/n @ 150)
n Kamuff(/s) | k 200 h 10 A m u f 200 (/s 200)
m Laferi(/ne) | l A f @ r i (/n @ 150)
m Lafericheib(/e) | l A f @ r i x e i b (/@ 150)
m Laferisiech(/e) | l A f @ r i s i e x (/@ 150)
m Laggaff(/e) | l A k 200 A f 250 (/@ 150)
m Lappi(/ne) | l A p 200 i (/n @ 150)
m Lauerisiech(/e) | l A u @ r i s i e x (/@ 150)
m Lumpeh(ung/üng) | l u m p @ h (u N g/Y N g)
m Lyribänz(/e) | l i 200 r i b a n t s (/@ 150)
m Lüm(u/mle) | l Y m (u/m l @ 150)
f Memme(/ne) | m e m 200 @ (/n @ 150)
n Miuchmubi(/s) | m Y u x b u b i (/s 150)
n Mischtschwibeli | m I S t S w I b @ l i
m Mongo(/s) | m O N g O (/s 150)
m Mongobilly(/s) | m O N g O b i l i (/s 150)
f Moore(/ne) | m O 200 r @ (/n @ 150)
m Motzi(/ne) | m O t s i (/n @ 150)
m Mulaff(/e) | m u l A f 250 (/@ 150)
m Muggigring(/e) | m u k 200 i g r I N g (/@ 150)
m Märebrätscher | m a 200 r @ b r a t S @ r
m Möögigring(/e) | m 2 200 k 200 i g r I N g (/@ 150)
m Möng(u/le) | m 2 N g (u/l @ 150)
m Möff(/e) | m 2 f 250 (/@ 150)
m Mürgg(u/le) | m Y 200 r k 200 (u/l @ 150)
m Nasepöögg(u/le) | n A s @ p 2 200 k 200 (u/l @ 150)
m Niddörfisiech(/e) | n I d _ 10 d 2 r f i s i e x (/@ 150)
m Närvs(ack/eck) | n a r f s (A k 200 50 h/e k 200 h 50)
m Pajass(/e) | p A i A s 200 (/@ 150)
f Panne(/ne) | p h A n 200 @ (/n @ 150)
m Plouderi(/ne) | p 200 l o u d @ r i (/n @ 150)
m Pfl(ock/öck) | p f l (O k 200 h 50/2 k 200 h 50)
m Pflotsch(/e) | p f l O t S 200 (/@ 150)
m Pf(oschte/öschte) | p f (O S t @/2 S t @)
m PHP-Programmierer | p 200 e h A p 200 e p r O g r A m i @ r @ r
m Pralaaggi(/ne) | p r A l A 200 k 200 i (/n @ 150)
m Praschaueri(/ne) | p r A S A u @ r i (/n @ 150)
f Pumpi(/ne) | p u m p i (/n @ 150)
m Pünt(u/le) | p Y n t 200 (u/l @ 150)
m Püüru | p y 200 r u
m Quadratspünt(u/le) | k 200 w A d r A 200 t S p Y n t 200 (u/l @ 150)
n Ranggifüdle | r A N k i f 2 d l @
n Rääf | r a 200 f 200
f Rosshode | r O s 200 h O d @
m Rosspigger | r O s 200 p i k 200 @ r
n Rybise | r i b i s @
f Schabe(/ne) | S A b @ (/n @ 150)
m Schafseck(u/le) | S O 200 f s e k 200 h 10 (u/l @ 150)
m Schibütz(u/le) | S i b y t s (u/l @ 150)
m Schiissigurgler | S i 200 s 200 i g u r g l @ r
m Schiissiputzer | S i 200 s 200 i p u t s @ r
m Schissgring(/e) | S i 200 s 200 g r I N g (/@ 150)
m Schlarpisiech(/e) | S l A r p i s i e x (/@ 150)
m Schlimschisser | S l i 200 m S i 200 s 200 @ r
m Schmingg(u/le) | S m I N k 200 (u/l @ 150)
m Schnudergoof(/e) | S n u d @ r g O 200 f 200 (/@ 150)
m Schnuderi(/ne) | S n u d @ r i (/n @ 150)
m Schnäbizägg(/e) | S n a b i t s a k 200 (/@ 150)
m Schnäbichätscher | S n a b i x a t S @ r
m Schnäbifächter
m Schnäbischpienzler | S n a b i S p i @ n t s l @ r
f Schnädere | S n a d @ r @
m Schwafler | S w A f l @ r
m Schwanzl(urch/ürch) | S w A n t s l (u r x 150/y r x 150)
m Schwauderi(/ne) | S w A u d @ r i (/n @ 150)
m Schwüpp(u/le) | S w y p 200 (u/l @ 150)
m Schöggeler | S 2 k 200 @ l @ r
m Schönwätterschlöfler | S 2 200 n w a t 200 @ r S l 2 200 f l @ r
m Seck(u/le) | s e k 200 h 20 (u/l @ 150)
m Seckupeter | s e k 200 h 20 u p e 200 t 200 @ r
m Siech(/e) | s i e x (/@ 150)
m Solothurner | s O l O t 200 u r n @ r
m Soucheib(/e) | s O u x e i b (/@ 150)
m Souh(ung/üng) | s O u h (u N g/Y N g)
f Soumätz(/e) | s O u m a t s (/@ 150)
f Soumoore(/ne) | s O u m O 200 r @ (/n @ 150)
m Sousiech(/e) | s O u s i e x (/@ 150)
m Spränz(u/le) | S p r a n t s (u/l @ 150)
m Stürmi(/ne) | S t y r m i (/n @ 150)
m Stärnesiech(/e) | S t a 200 r n @ s i e x (/@ 150)
m Stürmisiech(/e) | S t y r m i s i e x (/@ 150)
m Sufludi(/ne) | s u f l u d i (/n @ 150)
m Söiferludi(/ne) | s 2 i f 200 @ r l u d i (/n @ 150)
m Söinigg(u/le) | s 2 i n i k 200 (u/l @ 150)
m Süch(u/le) | s Y x 200 (u/l @ 150)
m Süff(u/le) | s Y f 200 (u/l @ 150)
m Sürm(u/le) | s Y r m (u/l @ 150)
n Theresli(/s) | t 200 e r e 200 s l i (/s 150)
m Togg(u/le) | t O k 200 (u/l @ 150)
m T(otsch/ötsch) | t (O t S 200/2 t S 200)
m Traliwatsch(/e) | t r A l i w A t S (/@ 150)
m Troschtpris(/e) | t r O 200 S t 200 p r i 200 s (/@ 150)
f Träne(/ne) | t r a 200 n @ (/n @ 150)
m Tröchni(/ne) | t r 2 x 200 n i (/n @ 150)
m Tropech(opf/öpf)
m Tröun(agu/egu) | t r 2 200 u n (A g u/e g u)
m Tschaupisiech(/e) | t S A u p i s i e x (/@ 150)
m Tschirpegig(u/le) | t S I r p @ k I k (u/l @ 150)
m Tschugger | t S u k 200 @ r
m Tschumppuh(ung/üng) | t S u m p u h (u N g/y N g)
m Tschump(u/le) | t S u m p (u/l @ 150)
m Tub(u/le) | t u p (u/l @ 150)
n Tüpfi(/s) | t y p f i (/s 150)
n Tussi(/s) | t 200 u s 200 i (/s 150)
m Töfflibueb(/e) | t 2 f 200 l i 50 b u @ p (/@ 150)
m Tüpflischisser | t y p f l i S i 200 s 200 @ r
m Uh(ung/üng) | u u h (u 200 N g/Y 200 N g)
m Vagant(/e) | f A g A 200 n t 200 (/@ 150)
m Voupf(oschte/öschte) | f O u p f (O S 150 t @/2 S 150 t @)
m Vout(otsch/ötsch) | f O u t 200 (O t S 200/2 t S 200)
m Weichschnäbeler | w e i x S n a b @ l @ r
f Wixbire(/ne) | w I g s b I r @ (/n @ 150)
f Wurzle(/ne) | w u r t s l @ (/n @ 150)
m Wäbstübeler | w a b S t Y b @ l @ r
m Zablisiech(/e) | t s A b l i s i e x (/@ 150)
m Zieg(u/le) | t s i @ g (u/l @ 150)
m Zirpegig(u/le) | t s I r p @ k i k (u/l @ 150)
m Zwick(/e) | t s w I k 200 h 20 (/@ 150)
m Zwänggring(/e) | t s w a N g g r I N g (/@ 150)
f Zwätschge(/ne) | t s w a t S g @ (/n @ 150)
m Zäieföhner | t s a 200 i @ f 2 200 n @ r
m Zürcher | t s Y 200 r x @ r
f aut(i/e) Hafehuer(/e) | A u t 200 (i/@) h A f @ h u @ r (/@ 150)
m genetische Müuh(uufe/üüfe) | g e n e 200 t h 50 i S @ m Y u h (u 200 f 200 @/y 200 f 200 @)
m Äschebächer | a S 200 @ b a x 200 @ r
m Ätti(/ne) mit Huet | a t 200 i (/n @ 150) _ 20 m I t h u @ t
""".trimLines().map { Entry.of(it) { Gendered(it) } }
}