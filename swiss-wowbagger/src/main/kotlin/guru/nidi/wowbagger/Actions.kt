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

object Actions {
    val list = """
(bisch/sit der) am Haag a? | (b I S/s i t 200 @ r) A m h A 200 g A 300
(bisch/sit der) bisse? | (b I S/s i t 200 @ r) b I s 200 @ 150
(bisch/sit der) blind uf de Ouge? | (b I S/s i t 200 @ r) b l I N u f d @ _ 50 o u g @ _ 20
(bisch/sit der) go blüemele? | (b I S/s i t 200 @ r)g O b l y @ m @ l @ _ 20
(bisch/sit der) ir Gäggelischuel blibe hocke? | (b I S/s i t 200 @ r) i r g a 200 k 200 h 50 @ l i S u @ l b l I b @ h o k 200 h 50 @
(bisch/sit der) ir Spinnhumbbele blibe stecke? | (b I S/s i t 200 @ r) I r S p i n 200 h u m p 200 @ l @ b l i b @ S t e k 200 h 50 @
(bisch/sit der) mit em Gertu usgrütscht? | (b I S/s i t 200 @ r) m I t @ m _ 20 g e 150 r t u _ 20 u s g r 10 100 y t S t
(bisch/sit der) nid ganz bache? | (b I S/s i t 200 @ r) n I d g A n t s b 10 100 A 200 100 110 x 150 @
(bisch/sit der) nid ganz hundert? | (b I S/s i t 200 @ r) n I d g A n t s h 10 100 u 150 100 110 n d @ r t
(bisch/sit der) wieder abghaset? | (b I S/s i t 200 @ r) w I d @ r A b g h A s @ t 200
(bruchsch/bruchit der) e Bisiblätz? | (b r u 200 x S/b r u 200 x i t 200 @ r) @ b i s i b l a t s
(chasch/chöit) mer am Ranze hange! | (x A S/x 2 i t) m @ r A m r A n t s @ 50 h A N 200 @ _ 20
(chunsch/chömmit) de flach use! | (x u n S/x 2 m i t) d e f l A x 200 u s @ _ 20
(chunsch/chömmit) de is Chefi! | (x u n S/x 2 m i t) d e _ 20 i s x e f i
(chunsch/chömmit) grad usem Chätschäbertrog? | (x u n S/x 2 m i t) g r A d u s @ m x a t S a b @ 50 r t r O 200 k
(di/öich) muess me abtue! | (d I/2 i x) 200 m u @ s m @ A p 150 t u @ _ 20
(dir/öich) muess me s'Füdle fäge! | (d I r/2 i x) m u @ s m @ s f Y d l @ f a g @ _ 20
(dis/öies) Chrutzli legi (der/nech) zäme! | (d i s/2 i @ s) x r u t s l i l e g i (d @ r/n @ x) t s a m @ _ 20
(du bisch/dir sit) dschuld! | (d u b I S/d I r s i t) t S u l t 200
(du bisch/dir sit) zum Haaröuseiche! | (d u b I S/d I r s i t) t s u m h A 200 r 2 200 u s e i x @ _ 20
(du bisch/dir sit) zum göögge! | (d u b I S/d I r s i t) t s u m S i @ s 200 @ _ 20
(du bisch/dir sit) zum schiesse! | (d u b I S/d I r s i t) t s u m S i @ s 200 @ _ 20
(du böckelisch/dir böckelet)! | (d u b 2 k 200 h 50 @ l i S 200/d I r b 2 k 200 h 50 @ l @ t)
(du chasch/dir chöit) nid mou s'Gräppli im Hotschmägli bleike! | (d u x A S/d I r x 2 i t) n I d m o u s g r a p 200 l i I m h O t S m a g l i b l e i k 200 h 50 @ _ 20
(du chunsch/dir chömmit) nid usem Schider! | (d u x u n S/d I r x 2 m i t) n I d u s @ m S n i 200 d @ r
(du chunsch/dir chömmit) nie id Chränz! | (d u x u n S/d I r x 2 m i t) n i @ i d x r a n t s
(du hesch/dir heit) so ne längi Leitig! | (d u h e S/d I r h e i t 150) s O 200 n @ l a 150 N g i l e i t 200 i k
(du meggisch/dir megget)! | (d u m e k 200 i S 200/d I r m e k 200 @ t 150)
(figg di/figgit nech)! | (f I k 200 d i/f I k 200 @ t n @ x)
(friss/frässit) nid us der Chatzechischte! | (f r I s/f r a s 200 i t) n I d u s d @ 50 r x A t s @ x I S t @ _ 20
(gang/göht) doch anes Chäferfescht! | (g A N/g 2 200 t) d O x A n @ s x a f @ r f e S t
(gang/göht) doch ar Aare nah! | (g A N/g 2 200 t) d O x A r A 250 r @ n A 300
(gang/göht) doch go bääbele! | (g A N/g 2 200 t) d O x g O p a 200 p @ l @
(gang/göht) dänne! | (g A N/g 2 200 t) g 50 d a n 200 @ _ 20
(gang/göht) go z'Acher fahre! | (g A N/g 2 200 t) _ 20 g O t s A x 200 @ r f A 200 r @
(geisch/dir göht) mer ufs Gäder! | (g e i S/d I r g 2 200 t) m @ r u f s g a d @ r
(geisch/göht dir) uf d'Gsüchtihoschtet? | (g e i S/g 2 200 t d I r) u f d g s Y x t i h O S t @ t
(gib/gäht) ihm chli! | (g I b/g a 200 t 150) i m x l i
(gsesch/dir gseht) us wie nes Meertrübeli! | (g s e 200 S/d I r g s e 200 t) u 200 s w i @ 50 n @ s m e 200 r t r y b @ l i
he(sch/it der) Gschtäutli verlore? | h e (S/i t 200 @ r) s g S t a u t l i f @ 50 r l O 200 r @
he(sch/it der) Gsüchti? | h e (S/i t 200 @ r) g s y x t i
he(sch/it der) Mähl am Ermu? | h e (S/i t 200 @ r) m a 200 u A m e r m u
he(sch/it der) de Bröcklihueschte? | h e (S/i t 200 @ r) d @ b r 2 k 200 h 50 l i h u @ S t @ _ 20
he(sch/it der) de Gluggsi? | h e (S/i t 200 @ r) d @ g l u k 200 s i
he(sch/it der) de Glöggeler nid agha? | h e (S/i t 200 @ r) d @ g l 2 k 200 @ l @ r n I d A 300 g h A 200
he(sch/it der) e Bränte glade? | h e (S/i t 200 @ r) @ b r a n 200 t @ g l A 200 d @ _ 20
he(sch/it der) e Churze ide Hose? | h e (S/i t 200 @ r) @ x u 200 r t s @ i d @ h O s @ _ 20
he(sch/it der) e Flick furt? | h e (S/i t 200 @ r) @ _ 20 f l I k 200 h 50 f u r t 200
he(sch/it der) e Fädilätsch im Hirni? | h e (S/i t 200 @ r) @ f a d i l a t S i m h I r n i
he(sch/it der) e Knick ir Fichte? | h e (S/i t 200 @ r) @ _ 20 k n I k 200 h 50 i r f I x t @
he(sch/it der) e dräckige Naselumpe! | h e (S/i t 200 @ r) @ d r a k 200 i g @ n A s @ l u m 200 p @
he(sch/it der) e stumpfe Hegu? | h e (S/i t 200 @ r) @ S t u m p f @ h e g u
he(sch/it der) en Egge ab? | h e (S/i t 200 @ r) @ n _ 20 e k 200 e A p 200
he(sch/it der) es Fröideli? | h e (S/i t 200 @ r) @ s f r 2 i d @ l i
he(sch/it der) es Gnusch im Fadechörbli? | h e (S/i t 200 @ r) _ 20 @ s g n u 200 S i m f A d @ x 2 200 r b l i
he(sch/it der) es blutts Näll? | h e (S/i t 200 @ r) @ s b l u t 200 s n a l 200
he(sch/it der) es warms Joghurt im Sack? | h e (S/i t 200 @ r) @ s w A 200 r m s i o g u r t i m s A k 200
he(sch/it der) id Hose gmacht? | h e (S/i t 200 @ r) i d h O s @ g m A x t
he(sch/it der) ir Bschütti badet? | h e (S/i t 200 @ r) i r b S Y t 200 i b A d @ t
he(sch/it der) nid aui Scheieli am Hag? | h e (S/i t 200 @ r) n I d A u 200 i S e i @ l i A m h A 200 k
he(sch/it der) nüm aui Lätsche ar Lismete? | h e (S/i t 200 @ r) n Y m A u i l a t S @ 150 _ 20 A r l I s m @ t 200 @
he(sch/it der) s'Ohremüggeli? | h e (S/i t 200 @ r) s _ 20 O 200 r @ m Y k 200 @ l i
he(sch/it der) z'heiss badet? | h e (S/i t 200 @ r) t s h e i s 200 b A d @ t
he(sch/it der) z'vüu Bätziwasser gha? | h e (S/i t 200 @ r) t s f Y u b a t s i w A s 200 @ r g h A 200
he(sch/it der) z'vüu ploderet? | h e (S/i t 200 @ r) t s f Y u p l O d @ r @ t
he(sch/it der) öppis gseit, oder nume ds Bis gwächslet? | h e (S/i t 200 @ r) 2 p 200 i s g s e i t O d @ r n u m @ d s b I 200 s g w a x s l @ t
he(sch/it) e Fige wie ne gchläpfte Aff! | h e (S/i t) @ f i g @ w i @ n @ g x l a p f t @ A 200 f 300
(hou's/houit's)! | (h o u s 200/h o u i t s 200)
(lah/löht) ne la bambele! | (l A/l 2 200 t) n @ l A b A m b @ l @ _ 20
schmöck(sch/it) wie bschüttigs Chrützimähl! | S m 2 k 200 h 50 (S/i t) w i @ b S y t 200 i g s x r y 200 t s i m a 200 l
schnor(sch/it) grusig wiene Moore! | S n O r (S/i t) g r u 200 s i g w i @ 50 n @ m O 200 r @ _ 20
schnäggel(isch/it) grad ziemlech us dr Gosche! | S n a k 200 @ l (i S/@ t) g r A d t s i @ m l @ x u s d @ 50 r g O S 200 @ _ 20
(tue/tüet) mer am Gätzi rätsche! | (t u @/t y @ t) m @ r A m g a t s i r a 200 t S @
(tue/tüet) mou richtig wärche! | (t u @/t y @ t) m o u r I x t i g w a r x @
(tue/tüet) nid chafle! | (t u @/t y @ t) n I d x A f l @
(tue/tüet) nid mit em Gagu spile! | (t u @/t y @ t) n I d m I t 200 @ m g A g u S p I l @
(tue/tüet) nid so affig! | (t u @/t y @ t) n I d s O A f 200 i k 200
(tue/tüet) nid soublöd! | (t u @/t y @ t) n I d s o u b l 2 200 t
(tue/tüet) nid töipele! | (t u @/t y @ t) n I d _ 20 t 2 i p 200 @ l @ _ 20
(tue/tüet) z'Nüni näh! | (t u @/t y @ t) t s n y 200 n i n a 200
(tuesch/tüet der) hurti öpis härejufle? | (t u @ S/t y @ t 200 @ r) h u r t i 2 p 200 i s h a r @ i u f l @
(wosch/weit der) e Chlapf a Grind? | (w O S/w e i t 200 @ r) @ x l A p f A g r i N g
wär(sch/it) froh hätt(isch/it der) en einzige nuesige Schiggeler uf em Lugipfupf! | w a r (S/@ t) f r O 200 h a t 200 (i S/@ t 200 @ r) @ n e i n t s i g @ n u e s i g @ S I k 200 @ l @ r u f @ m l u g i p f u p f
(wäsch der/wäschit nech) d'Chlööpe! | (w a S 200 d @ r/w a S 200 i t n @ x) d x l 2 200 p 200 @ _ 20
zieh(/t) Fäde! | z i @ (/t) f a d @ _ 20
Houptsach es rouchnet, Housi! | h o 50 u p t s A x @ s r o u x n @ t h o u s i
aber süsch (bisch/sit der) no gsung? | A b @ r s Y S _ 50 (b I S/s i t 200 @ r) n o g s u N g
aber süsch geit's? | A b @ 50 r s Y S _ 50 g e i t s
adiemerssi! | A d i @ m e r s 200 i
bi (dir/öich) chauberet doch der Brüggstock! | b I (d I 200 r/2 i x) x A u b @ r @ t d o x d e b r Y k 200 S t o k
blos(/it) mer id Schueh! | b l O 200 s (/i t) m @ r i d S u @ _ 20
bohr(/it) nid i de Ohre! | b O 200 r (/i t) n I d i d @ O 300 r @ _ 20
bääg(/it) doch nid so blöd! | b a 200 k 200 (/i t) d O x n I d s O b l 2 200 t
chlemm(/it) ab! | x l e m 200 (/i t) _ 50 A p 200 h 50
chotz(/it) nid so! | x O t s (/i t) n I d s O
chunnt de Wurschtsalat zrügg? | x u n t d @ w u r S t s A l A 200 t _ 50 t s r Y k 200
chätsch(/it) nid so grusig! | x a t S (/i t) n I d s O g r u 200 s i g
dampf(/it) ab! | d A m p f (/i t) _ 50 A p 200 h 50
das geit bachab mit (dir/öich)! | d A s g e i t b A x A p m I t (d I 200 r/2 i x)
das git Lämpe! | d A s g I t l a m p @ _ 20
do he(sch/it der) es Foto fürs Böögenalbum! | d O h e (S/i t 200 @ r) @ s f O t 200 O f Y r s b 2 200 k 200 @ n A l b u m _ 20
fahr(/it) ab! | f A 200 r (/i t 150) _ 20 A p 200
fertig luschtig jetz! | f e r t i g l u S t i g i e t s
fertig schnätz! | f e r t i g S n a t s
furz(/it) nid so i der Chile! | f u 200 r t s (/i t) n I d s O i d r x I l @ _ 20
fäut's (der/nech)? | f a 200 u t s (d @ r/n @ x)
geit's eigentlech no? | g e i t s e i g @ n t l @ x n O 200
grunz(/it) nid so grusig! | g r u n t s (/i t) n I d s O g r u 200 s i g
gump(/it) doch ine Glungge! | g u m p (/i t) d O x i n @ g l u N k 200 @ _ 20
guuggets (der/nech) im Schissächerli? | g u 200 k 200 @ t s (d @ r/n @ x) i m S i s a x 200 @ 50 r l i
hantli is Bett! | h A n t 200 l i i s b e t 200
haut(/it) der Latz! | h A u t 200 (/ i t) d O x d @ r l A t s 200
haut(/it) s'Gfräs! | h A u t 200 (/ i t) s g f r a 250 s 200
het's (dr/nech) i Weize gschneit? | h e t s (d @ r/n @ x) _ 20 i w e i t s @ g S n e i t 200
het's (dr/nech) is Hirni geschisse? | h e t s (d @ r/n @ x) i s h I r n i g S I s 200 @
häb(/it) d'Talpe wäg! | h a p (/i t) _ 50 t A u p 200 @ w a k 200 h 50
häb(/it) doch mau d'Schnure! | h a p (/i t) d O x m O u d S n u r @
häb(/it) ke Dummi! | h a p (/i t) k 200 h 50 e d u m 200 i
hör(/it) uf gfätterle! | h 2 r (/i t) u f g f a t 200 @ 50 r l @
hör(/it) uf gigampfe! | h 2 r (/i t) u f g i g A m p f @
hör(/it) uf lauere! | h 2 r (/i t) u f l A u @ r @
hör(/it) uf liire! | h 2 r (/i t) u f l i 200 r @
hör(/it) uf spöifere! | h 2 r (/i t) u f S p 2 i f @ r @ _ 20
hör(/it) uf zaagge! | h 2 r (/i t) u f t s A 200 k 200 @
hüt (geisch/göht der) z'Bode! | h y t (g e i S/g Y 200 t 200 @ r) t s b O d @ _ 20
i bole (der/nech) eis! | I b O l @ (d @ r/n @ x) e i s
i bringe (di/nech) uf d'Gnagihoschtet! | I b r I N @ (d i/n @ x) u f d g n A 200 g i h O S t @ t
i brätsche (der/nech) eis! | I b r a t S @ (d @ r/n @ x) _ 20 e i s
i drücke (der/nech) d'Chäspedau i Gring! | I d r Y k h 50 @ (d @ r/n @ x) d x a 200 s p e d A 200 u i g r I N g
i gheie (di/nech) i Ghüder! | I g h e 200 i @ (d i/n @ x) _ 50 i g h Y d @ r
i gibe (der/nech) eis uf'd Rösti! | I g I b @ (d @ r/n @ x) e i s u f _ 20 d r 2 200 S t i
i gibe (der/nech) mit der Wedele! | I g I b @ (d @ r/n @ x) _ 20 m I t 200 @ 50 r w e d @ l @ _ 20
i gibe (der/nech) mit em Teppichchlopfer! | I g I p @ (d @ r/n @ x) m I t 200 @ 50 m t 200 e p 200 i x x l o p f @ r
i gorbse (der/nech) i Gring! | I k O 200 r b s @ (d @ r/n @ x) i g r I N g
i gschweigge (di/nech) grad! | I g S w e i k 200 @ (d i/n @ x) g r A t
i müpfe (di/nech) i See! | I m Y p f @ (d i/n @ x) i s e 300
i nimme (di/nech) am Grännihaar! | I n I m @ (d i/n @ x) A m g r a n 200 i h O 200 r
i packe (di/nech) am Chrage! | I _ 20 p 200 A k 200 h 50 @ (d i/n @ x) A m x r A g @ _ 20
i paniere (der/nech) eis! | I p A n i @ r @ (d @ r/n @ x) e i s 200
i passe (der/nech) ab! | I p A s 200 @ (d @ r/n @ x) A p 200 h 50
i poliere (der/nech) s'Gröibschi | I p o l i @ r @ (d @ r/n @ x) s g r 2 i b S i
i putze (der/nech) d'Chuttle! | I p u t s @ (d @ r/n @ x) _ 20 d x u t 200 l @ _ 20
i pänggle (der/nech) e Chnebu zwüsche d'Bei! | I p a N k 200 l @ (d @ r/n @ x) @ x n e b u t s w Y S 200 @ d b e i
i schisse (der/nech) id Chappe! | I S i 200 s 200 @ (d @ r/n @ x) i d x A p 200 @ _ 20
i schrisse (di/nech) übers Näscht ab! | I S r i 200 s 200 @ (d I/n @ x) Y b @ r s n a S t A p 200 h 50
i schutte (der/nech) eis i Arsch! | I S u t 200 @ (d @ r/n @ x) e i s i A 200 r S 200
i säge (der/nech) au Gott Schand! | I s a k @ (d @ r/n @ x) A u g O t 200 S A N g
i treichle (der/nech) öpis! | I t r e i x l @ (d @ r/n @ x) 2 p 200 i s
i tue (der/nech) ds Gurli fiegge! | I t u @ (d @ r/n @ x) s g u r l i f i @ k 200 @
i tue (der/nech) eini abewäsche! | I t u @ (d @ r/n @ x) e i n i A b @ w a S 200 @ _ 20
i tätsche (der/nech) eis! | I t a t S @ (d @ r/n @ x) e i s
i verminggle (der/nech) s'Bätzi dass (/der) d'Osterpföteler ghör(sch/it) zawanggle! | I f @ r m i N k 200 l @ (d @ r/n @ x) s b a t 200 s i d A s 200 (/d @ r) d O 200 S t @ r p f 2 200 t 200 @ l @ r g h 2 r (S/i t) t s A w A n k 200 l @
i vermöckle (der/nech) de Schtirps mit em Flarzise! | I f @ r m 2 k 200 h 50 l @ (d @ r/n @ x) d e S t I r p s m I t @ m f l A r t s i s @
i verschwarte (di/nech)! | I f @ r S w A 200 r t @ (d i/n @ x)
i zeige (der/nech) wo de Bartli de Most hout! | I _ 20 t s e i k 200 @ (d @ r/n @ x) w O d @ b A 200 r t l i d @ m O S t h o u t 200
i zeih (der/nech) d'Gängeretalpli läng! | I _ 20 t s i e (d @ r/n @ x) _ 20 d g a N 200 @ r @ t A l p l i l a N g
i zwurgle (di/nech) mit em Gürchu! | I _ 20 t s w u r g l @ (d i/n @ x) m I t 200 @ m g Y 200 r x u _ 20
jetz fähl(sch/it der) de grad! | i e t s f a 200 l (S/i t t 200 @ r) d e g r A t 200
jetz git's ufs Dach! | i e t s g I t s u f s d A 200 x 200
jetz räblet's! | i @ t s r a b l @ t s
läck(/it) mi am Arsch! | l a k 200 (/i t) m i A m A 200 r S 200
mach(/it) kes Gabaree! | m A x 150 (/i t) k h 50 e s g A b A r e 200 _ 20
mach(/it) kes Ghöi! | m A x 150 (/i t) k h 50 e s k h 2 i
mach(/it) kes Gschiss! | m A x 150 (/i t) k h 50 e s g S i 200 s 200
mach(/it) nid s'Chaub! | m A x 150 (/i t) n I d s x A u p 200
muess me (di/nech) dängele? | m u @ s m @ (d i/n @ x) d a N 200 @ l @ _ 20
muess me (di/nech) früsch griene? | m u @ s m @ (d i/n @ x) f r Y S g r i @ n @ _ 20
putz(/it) (di/nech) furt! | p u t s (/i t) (d i/n @ x) _ 20 f u r t 200
red(/it) ke Bläch! | r e d (/i t) k 200 h 50 e b l a 200 x 200
rum(/it) (di/öie) Göppu dänne! | r u m (/i t) (d i/2 i @) g 2 p 200 u d a n 200 @ _ 20
schieb(/it) ne! | S i @ b (/i t) n @
schlift's? | S l i 250 f t s
schläck(/it) nid a de Böögge! | S l a k 200 (/i t) n I d A d @ b 2 200 k 200 @ _ 20
schnütz(/it) (di/nech) mou! | S n y t s (/i t) (d i/n @ x) m O 200 u _ 20
strich(/it) (der/nech) das ads Bei! | S t r i 200 x (/i t) _ 20 (d @ r/n @ x) d A 200 s A s b e i
sug(/it) a! | s u 200 g (/i t) _ 50 A 300
verreis(/it)! | f @ r r e i (s 200/s i t)
verzeu(/it) vo (dim/öiem) Umfall. | f @ r t s @ u (/i t) f O (d i m/2 i @ m) u m f A u _ 20
was bosg(isch/git der) wieder? | w A s p O 200 s g (i S/i t 200 @ r) w I d @ r
was chnübl(isch/it der) do? | w A s x n y 200 b l (i S/i t 200 @ r) d O 250
was fuscht(isch/it der) do? | w A s f u 200 S t (i S/i t 200 @ r) d O 250
was he(sch/it der) gänggelet? | w A s h @ (S/i t 200 @ r) k a N k 200 @ l @ t
was holei(isch/it der) wieder? | w A s h o l e i (i S/i t 200 @ r) w I d @ r
was (lisisch/läsit der) für nes Chäsblatt? | w A s (l I s i S/l a s i t 200 @ r) f Y r 50 n @ s x a 200 s b l A t 200
was mach(sch/it der) für ne Lätsch? | w A s m A x (S/i t 200 @ r) f Y r n @ l a t S 200
was schil(isch/it der)? | w A s S I l (i S/i t 200 @ r)
was (tuesch/tüet der) wieder absüdere? | w A s (t u @ S/t y @ t 200 @ r) w I d @ r A b s Y d @ r @ _ 20
was isch mit (dim/öiem) Hosegschingg? | w A s I S m I t (d i m/2 i @ m) h O s @ g S I N k 200
wenn i (dis/öies) Gsicht aluege, bin i mit mim Füdle ganz z'fride. | w e n I 200 (d i s/2 i @ s) g s I x t A l u @ g @ b I n I m I t m i m f Y d l @ 50 g A n t s _ 20 t s f r I d @ _ 20
wird (der/nech) gschmuech? | w I r (t 200 @ r/t n @ x) g S m u @ x
wäm (bisch/sit der) wieder a Chare gfahre? | w a m (b I S/s i t 200 @ r) w I d @ r A x A r @ g f A 200 r @ _ 20
""".trimLines().map { line -> Entry.of(line) { Action(it) } }
}