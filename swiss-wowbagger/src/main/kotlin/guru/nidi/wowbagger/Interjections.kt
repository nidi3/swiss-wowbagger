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

object Interjections {
    val list = """
alemarsch | A l 50 e m A r S 200
apropo | A p r O p O 200
aues Grümpu | A u @ s g r y m p u
bigoscht | b I g o S t 200
bissoguet | b I s 200 o g u @ t 200
blasius | b l A 200 s i u s 200
blöds Gmöögg | b l 2 200 d s _ 50 k m 2 200 k 200
blöds Gschnur | b l 2 200 d s _ 50 k S n o r 200
Bockmischt | b o k h 50 m I S d 200
Chutzemischt | x u t s @ m I S d 200
Chabis | x A b i s 200
Chnebuschissi | x n e b u S i 200 s 200 i
Chrückemünz | x r Y k 200 h 50 @ m Y n t s
Chueplätter | x u @ p 200 l a t 250 @ r
Donnergueg | d O n 200 @ r g u @ k 200
Donnerschiess | d O n 200 @ r S i @ s 200
Donnerwätter | d O n 200 @ r w a t 250 @ r
dumms Glööl | d u m 200 s g l 2 200 u
dumms Gschmöis | d u m 200 s g S m 2 i s
dumme Seich | d u m 200 @ s e i x
dumms Züg | d u m s t s y 200 k 200
E du verruckt | e d u f @ r 150 u 50 k 200 h 50 t
Eichuzyste | e i x u t s Y S t @
Färegschäderli und Möuchgröötzi | f a r @ k S a d @ 50 r l i _ 50 u n d _ 50 m 2 u x k r 2 200 t s i
Figugegl | f i k u k e g l
ghoue oder gstoche | g h O u @ 200 _ 20 O d @ r k S t O x @ 200
Globivogu | k l O b i f O k u
gloubs der Gugger | g l O u b s d @ r k u k 200 @ r
gopf | k O p f
gopferteli | k O p f @ r t e l i
gopfertami | k O p f @ r t a m i
gopfertecku nomou | k O p f @ r t e k 200 h 50 u n o m o u
gopfertoori | k O p f @ r t O 200 r i
gopfertooria | k O p f @ r t O 200 r i A 200
gopfrid Stutz | k O p f r i d S t u t s
goppeletti | k O p 300 @ l e t 300 i
Gschmöis | k S m 2 i s
gschtoche Bock | k S t O x @ b O k 200 h 50
guet Nacht am Sächsi | k u e t n A x t A m s a x s i
Hafechäs | h A f @ x a 200 s
Hammersack | h A m 200 @ r s A k 200 h 50
Hawasch | h A w A S 200
heimatland | h e i m A t l A n d
heilandsack | h e i l A n d s A k 200 h 50
heilandtonner | h e i l A n d t O n 200 @ r
heilige Beck | h e i l i g @ b e k 200 h 50
heitere Fahne | h e i t 200 @ r @ f A 200 n @
henusode | h e n u s o d e
herrgotttonnerwätter | h e r r g O t 200 t O n 200 @ r w a t 200 @ r
herrgott Stärne | h e r r g O t 200 S t a r n @
himuplütter | h I m u p 200 l Y t 200 @ r
dasch es huere Glauer | d A S @ s h u @ r @ g l A u @ r
huere Moorerei do | h u @ r @ m O 200 r @ r e i d O 200
hueresiech | h u @ r @ s i @ x
i Gotts Name | i g O t s n A m @
i mache es Chrütz ad Tili | I m A x 200 @ _ 50 @ s x r y t s A d t I l i
im Fau | I m f A u
jetz isch gnue Höi dunge | i e t s I S g n u @ h 2 i d u N @
jo was chätzers | i o w A s x a t s @ r s
leidi Sach | l e i d i s A x 200
läck | l a k 200 h 50
mi Gotts Türi | m i g O t s t y 200 r i
mitz id Chuchi | m I t s _ 50 i d x u x 200 i
oha lätz | O h A l a t s
Pfiffetechu | p f i f 200 @ t e x 200 u
potz Himurieme | p O t s h i m u r i @ m @
potz Holzöpfel und Zipfelchappe | p O t s h o u t s 2 p f u u n d t s I p f u x A p 200 @
potztusig | p O t s t u 200 s i k
schiss ad Wang | S i s 200 A d w A N g
Schissdräck am Loufmeter | S i 200 s 200 d r a k 200 h 50 A m l o u f m e 200 t 200 @ r
Schnuder im Telefon | S n u d @ r i m t e l e f O n
stäcketööri | S t a k 200 h 50 @ t 200 2 200 r i
Stärneföifi | S t a r n @ f 2 i f i
tamisiech | t a m i s i @ x
verdammt | f @ r d A m 200 t
verfluecht | f @ r f l u @ x t
vou chrüüsch | f o u x r y 200 S
weiss der Gugger | w e i s 200 d @ r k u k 200 @ r
z'eis Dapf | t 200 s e i s d A p f
z'Gotts Bäri | t 200 s k O t s b a r i
Zeiechäs | t s e 200 i @ x a 200 s
äuä nid | a u a n I 200 t
äuä scho | a u a S O 200
ätsch | a 200 t S
üüüble Sache | y 500 b l @ s A x @
""".trimLines().map { Entry.of(it) { it } }
}