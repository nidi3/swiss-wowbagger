package guru.nidi.wowbagger

import guru.nidi.wowbagger.Wowbagger.trimLines

object Names {
    val list = """
m Ädu | a d u
f Andle | A n d 50 l @
m Ändu | a n d u
f Ännele | a n 200 @ l @
f Annebäbi | A n 200 @ b a 200 b i
m Aschi | A S i
f Beetli | b e 200 t 150 l i
m Beätu | b e a 200 t 200 u
m Bidu | b i d u
m Beni | b e n i
m Bänz | b a n t s
m Brünu | b r y n u
m Chlöisu | x l 2 i s u
m Chrigu | x r I g u
f Chrige | x r I g @
m Chäschpu | x a S p u
m Dänu | d a n u
m Dävu | d a f u
m Dölf | d 2 u f
m Fäbu | f a b u
m Fige | f i g @
m Fippu | f i p 200 u
m Fixu | f i g s u
m Flöru | f l 2 2 r u
m Fränzu | f r a n t s u
m Fredu | f r e d u
m Fridu | f r I d u
m Fritzu | f r I t s u
m Godi | k O d i
m Gusti | g u S t i
m Gödu | g 2 d u
f Heidle | h e i d l @
m Hene | h e 50 n @
m Housi | h o u s i
m Jänu | i a 200 n u
f Jole | i o l @
m Jüre | i y r @
m Köbu | k h 50 2 b u
m Kari | k h 50 A r i
m Käru | k h 50 a r u
m Kusi | k h 50 u s i
m Küsu | k h 50 y s u
m Küre | k h 50 y r @
m Lexu | l e g s u
f Lise | l i s @
m Lüku | l y k h 50 u
m Mänu | m a n u
m Märgu | m a r k u
m Märsu | m a r s u
m Märu | m a r u
m Mäthu | m a t 200 u
m Michu | m i x 200 u
f Möne | m 2 n @
m Niku | n i k 200 h 50 u
f Nigge | n i k 200 @
m Ölu | 2 l u
m Päscu | p a s g u
m Pädu | p h 50 a d u
m Pöilu | p h 50 2 i l u
m Pesche | p e S @
m Räffu | r a f 200 u
m Res | r e 200 s
m Retölu | r e 200 t 200 2 200 l 50 u
m Role | r O l @
m Rölu | r 2 l u
m Röschu | r 2 S u
m Röifu | r 2 i f u
m Römu | r 2 m u
m Rüfe | r y f @
m Rüedu | r y @ d u
f Sabe | s A b @
m Sämu | s a m u
m Sändu | s a n d u
m Säschu | s a S 200 u
m Sebu | s e b u
f Sile | s I l @
m Simu | s i m u
f Sime | s i m @
f Söne | s 2 n @
m Steffu | S t e f 200 u
m Stifu | S t i f u
f Susle | s u s l @
m Seppu | s e p 200 u
m Schämpu | S a m p u
f Schane | S A n @
m Stöffu | S t 2 f 200 u
f Tesi | t e s i
f Tesle | t e s l @
m Tinu | t i n u
f Trixle | t r i g s l @
f Trudle | t r u d l @
m Tömu | t 2 m u
m Tönu | t 2 n u
m Üelu | y @ l u
m Ürsu | y r s u
m Wale | w A l @
m Wäutu | w a u t u
m Wernu | w e r n u
m Werni | w e r n i
f Vane | w A n @
m Vidu | w i d u
f Vrene | f r e n @
""".trimLines().map { Entry.of(it) { Gendered(it) } }
}