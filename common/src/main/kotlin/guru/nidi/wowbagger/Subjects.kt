package guru.nidi.wowbagger

import guru.nidi.wowbagger.Wowbagger.trimLines

object Subjects {
    val list = """
m Aargouer Outofahrer | A 200 r g o u @ r _ 50 o u t o f A 200 r @ r 200
f Achermähre | A x 200 @ r m a 200 r @
m Aff | A f 300
m Angschthas | A N S t h A 200 s
m Arschchäfer | A 200 r S x a f @ r
f Arschgige | A 200 r S g i 200 g @
m Arschgigu | A 200 r S g I g u 150
n Arschkantefilet | A 200 r S k 100 h 50 A n t @ f i l e 200
m Aschi | A S i
n Aupechaub | A u p @ x A u b 200
f Baabe | b A 200 p @
f Bagglimoore | b A g 200 l i m O 200 r @
n Baslerbebbi | b A s l @ r b e b 200 i
m Batzechlemmer | b A t s @ x l e m 200 @ r
m Bettseicher | b e t s e i x @ r
n Bipperlisi | b I p 200 @ r l i s i
m Bisibueb | b i s i b u @ b
n Bisibääbi | b i s i b a 200 b i
m Bisitrinker | b i s i t r I N k h 50 @ r
m Blickläser | b l I k 200 h 50 l a s @ r
m Blödian | b l 2 200 d i a 150 n
m Blöffsack | b l 2 f 200 s A k h 50
n Bohneross | b O 200 n @ r O s 300
f Bohnestange | b O 200 n @ S t A 150 N @
m Braschti | b r A S 150 t i
m Brämeständer | b r a 200 m @ S t a n d @ r
m Bschishung | b S i s h u N _ 50
f Bännesou | b a n 200 @ s o u
f Bärgänte | b a r k 200 _ 20 a n t @
m Bäse | b a s @
n Bäserääf | b a s @ r a 250 f 200
m Bääggisiech | b a 200 g 200 i s i @ x
f Bire | b I r @
m Birewixer | b I r @ w I g s @ r
m Bhouptisiech | b 300 h o u p 200 t i s i @ x
m Bööggefrässer | b 2 200 k 200 @ f r a s 200 @ r
m Büffu | b Y f 200 u
m Bünzli | b Y n t s l i
m Bürokolleg | b Y r O k 200 h 20 O l e 200 k 200
m Chafler | x A f l @ r
m Chaflicheib | x A f l i x e i b
m Chatzestrecker | x A t s @ S t r e k 200 h 50 @ r
m Chegelebrägler | x e g @ l @ b r a g l @ r
m Cheib | x e i b
m Chirschigägger | x i r S i 50 g 200 a g 200 @ r
m Chiubi-Gigu | x i u b i k I k u
f Chleechue | x l e 200 x u @
f Chlefe | x l e f @
n Chlepfschit | x l e p f S i t 200 h 50
m Chnorzi | x n O r t s i
m Chnüblisiech | x n y 200 b l i s i e x
m Chotzchübu | x o t s x Y b u
m Choderi | x o d @ r i
m Cholesack | x O l @ s A k 200 h 50
m Chouderi | x O u d @ r i
m Chrüppucheib | x r Y p 200 u x e i b
m Chrüppuhung | x r Y p 200 u h u N g
n Chuderluuri | x u d @ r l u 200 r i
n Chuefüdle | x u @ f Y d l @
m Chutzemischt | x u t s @ m I S d
m Chüttenechotzer | x Y t 200 @ n @ x o t s @ r
m Chuttlefrässer | x u t 200 l @ f r a s 200 @ r
m Chääri | x a 200 r i
m Chöözi | x 2 200 t s i
n Dascheli | d A S @ l i
n Doggeli | d O k 200 @ l i
m Dorfmuni | d O r f m u n i
m Dräcksack | d r a k s A k 200 h 50
m Düppugring | d Y p 200 u g r I N g
n Eiterbibeli | e i t 200 @ r b i b @ l i
m Figgfähler | f I k 200 f a 200 l @ r
f Filzluus | f I u t s l u 200 s
n Finöggeli | f i n 2 k 200 @ l i
m Fleischvogu | f l e i S f O g u
n Flöigehirni | f l 2 i g @ 50 h I r n i
m Fotzucheib | f O t s u x e i b
m Fridhofjödeler | f r I d h O f i 2 d @ l @ r
m Frässhung | f r a s 200 h u N g
m Fuschti | f u 200 S t i
m Futz | f u t s
m Futzbuur | f u t s p u 200 r
m Futzgring | f u t s g r i N g
m Füdlibürger | f Y d 50 l i b Y r g @ r
n Fägnäscht | f a g n a S d
f Färlimore | f a 200 r l i m O 200 r @
m Fätze | f a t s @
m Fötzu | f 2 t s u
m Fötzucheib | f 2 t s u x e i b
m Fötzusiech | f 2 t s u s i e x
m Gaggelari | g A k 200 @ l A 200 r i
m Galööri | g A l 2 200 r i
m Gartefeschtplouderi | g A r t @ f e S t p l o u d @ r i
m Ghüderi | g 200 h Y d @ r i
f Gibe | g i b @
m Gigu | g I g u
m Gigusiech | g I g u s i e x
m Gitzeler | g I t s @ l @ r
m Gitzgnäpper | g i t s g n a p 200 @ r
n Gjätt | k i 50 a d 200
f Gjätthäse | k i 50 a t 200 h a s @
m Gfröörli | g f r 2 200 r l i
m Glaraff | k l A r A f 300
m Globivogu | g l O p i f o g u
m Glögglifrösch | g l 2 g 200 l i f r 2 S 200
m Glünggi | g l Y N k 200 i
m Glüschteler | g l Y S t @ l @ r
m Gmeinsmuni | g m e i n s m u n i
f Gmüetsmoore | g m y @ t s m O 200 r @
m Gnieti | g n i @ t 200 i
m Goof | k O 200 f
m Gorilla Blauarsch | g O r i l 200 A b l A u A r S
n Grillehirni | g r I l 200 @ h I r n i
m Grittibänz | g r I t 200 i b a n t s
m Groggermooslaferi | g r O g 200 @ r m O 200 s l A f @ r i
m Gränni | g r a n 200 i
m Grümscheler | g r Y m S @ l @ r
m Grüsu | g r y 200 s u
m Gschtabi | k S t A b i
m Gschtabicheib | k S t A b i x e i b
n Gschwür | k S w y r
m Gummihaus | g u m i h A u s
f Gumsle | g u m s l @
m Gugaagger | g u g A 200 g 200 @ r
f Gure | g u r @
m Gwaggli | g w A k 200 l i
m Gäderhächu | g a d @ r h a x 200 u
n Gäderiwyb | g a d @ r i w i 200 p h 50
n Gäderimanndli | g a d @ r m A n 200 d l i
m Gäägerehubu | g a 200 k 200 @ r @ h u b u
m Göiferisiech | g 2 i f @ r i s i @ x
m Göiggu | g 2 i k 200 h 10 u
m Göferlimuni | g 2 f @ r l i m u n i
n Güezi | g y @ t s i
m Haagge | h A 200 k 200 @
n Haaghuuri | h A 200 g h u 200 r i
m Habasch | h A 50 b A S 200
f Hafehuer | h A f @ h u @ r
m Hagu | h A g u
m Heilandtonner | h e i l A n d t o n 200 @ r
m Hornochs | h O r n O x s
m Hudilump | h u d i l u m p
n Hundshammli | h u n d s h A m 200 l i
f Hundsniere | h u n d s n i @ r @
m Hueresiech | h u @ r @ s i @ x
m Hurli-Gwaag | h u r l i g w A 200 k 200
m Hurrlibueb | h u r r l i b u @ p
m Höseler | h 2 s @ l @ r
m Höuzu | h 2 u t s u
m Im-Kreisu-Links-Blinker | i m k r e i s u l I n k s b l I N k 200 @ r
m Krouteri | k 200 r o u t 200 @ r i
n Kamuff | k 200 h 10 A m u f 300
m Laferi | l A f @ r i
m Lafericheib | l A f @ r i x e i b
m Laferisiech | l A f @ r i s i e x
m Laggaff | l A k 200 A f 250
m Lappi | l A p 200 i
m Lauerisiech | l A u @ r i s i e x
m Lumpehung | l u m p @ h u N g
m Lyribänz | l i 200 r i b a n t s
m Lümu | l Y m u
f Memme | m e m 200 @
n Miuchmubi | m Y u x b u b i
n Mischtschwibeli | m I S t S w I b @ l i
m Mongo | m O N g O
m Mongobilly | m O N g O b i l i
f Moore | m O 200 r @
m Motzi | m O t s i
m Mulaff | m u l A f 250
m Muggigring | m u k 200 i g r I N g
m Märebrätscher | m a 200 r @ b r a t S @ r
m Möögigring | m 2 200 k 200 i g r I N g
m Möngu | m 2 N g u
m Möff | m 2 f 250
m Mürggu | m Y 200 r k 200 u
m Nasepööggu | n A s @ p 2 200 k 200 u
m Niddörfisiech | n I d _ 10 d 2 r f i s i e x
m Närvsack | n a r f s A k 200
m Pajass | p A i A s 200
f Panne | p h A n 200 @
m Plouderi | p 200 l o u d @ r i
m Pflock | p f l O k 200 h 50
m Pflotsch | p f l O t S 200
m Pfoschte | p f O S t @
m PHP-Programmierer | p 200 e h A p 200 e p r O g r A m i @ r @ r
m Pralaaggi | p r A l A 200 k 200 i
m Praschaueri | p r A S A u @ r i
f Pumpi | p u m p i
m Püntu | p Y n t 200 u
m Püüru | p y 200 r u
m Quadratspüntu | k 200 w A d r A 200 t S p Y n t 200 u
n Ranggifüdle | r A N k i f 2 d l @
n Rääf | r a 200 f 200
f Rosshode | r O s 200 h O d @
m Rosspigger | r O s 200 p i k 200 @ r
n Rybise | r i b i s @
f Schabe | S A b @
m Schafsecku | S O 200 f s e k 200 h 10 u
m Schibützu | S i b y t s u
m Schiissigurgler | S i 200 s 200 i g u r g l @ r
m Schiissiputzer | S i 200 s 200 i p u t s @ r
m Schissgring | S i 200 s 200 g r I N g
m Schlarpisiech | S l A r p i s i e x
m Schlimschisser | S l i 200 m S i 200 s 200 @ r
m Schminggu | S m I N k 200 u
m Schnudergoof | S n u d @ r g O 200 f 200
m Schnuderi | S n u d @ r i
m Schnäbizägg | S n a b i t s a k 200
m Schnäbichätscher | S n a b i x a t S @ r
m Schnäbischpienzler | S n a b i S p i @ n t s l @ r
f Schnädere | S n a d @ r @
m Schwafler | S w A f l @ r
m Schwanzlurch | S w A n t s l u r x
m Schwauderi | S w A u d @ r i
m Schwüppu | S w y p 200 u
m Schöggeler | S 2 k 200 @ l @ r
m Schönwätterschlöfler | S 2 200 n w a t 200 @ r S l 2 200 f l @ r
m Secku | s e k 200 h 20 u
m Seckupeter | s e k 200 h 20 u p e 200 t 200 @ r
m Siech | s i e x
m Solothurner | s O l O t 200 u r n @ r
m Soucheib | s O u x e i b
m Souhung | s O u h u N g
f Soumätz | s O u m a t s
f Soumoore | s O u m O 200 r @
m Sousiech | s O u s i e x
m Spränzu | S p r a n t s u
m Stürmi | S t y r m i
m Stärnesiech | S t a 200 r n @ s i e x
m Stürmisiech | S t y r m i s i e x
m Sufludi | s u f l u d i
m Söiferludi | s 2 i f 200 @ r l u d i
m Söiniggu | s 2 i n i k 200 u
m Süchu | s Y x 200 u
m Süffu | s Y f 200 u
m Sürmu | s Y r m u
n Theresli | t 200 e r e 200 s l i
m Toggu | t O k 200 u
m Totsch | t O t S 200
m Traliwatsch | t r A l i w A t S
m Troschtpris | t r O 200 S t 200 p r i 200 s
f Träne | t r a 200 n @
m Tröchni | t r 2 x 200 n i
m Tröunagu | t r 2 200 u n A g u
m Tschaupisiech | t S A u p i s i e x
m Tschirpegigu | t S I r p @ k I k u
m Tschugger | t S u k 200 @ r
m Tschumppuhung | t S u m p u h u N g
m Tschumpu | t S u m p u
m Tubu | t u p u
n Tüpfi | t y p f i
n Tussi | t 200 u s 200 i
m Töfflibueb | t 2 f 200 l i 50 b u @ p
m Tüpflischisser | t y p f l i S i 200 s 200 @ r
m Uhung | u u h u 200 N g
m Vagant | f A g A 200 n t 200
m Voupfoschte | f O u p f O S t @
m Voutotsch | f O u t 200 O t S 200
m Weichschnäbeler | w e i x S n a b @ l @ r
f Wixbire | w I g s b I r @
f Wurzle | w u r t s l @
m Wäbstübeler | w a b S t Y b @ l @ r
m Zablisiech | t s A b l i s i e x
m Ziegu | t s i @ g u
m Zirpegigu | t s I r p @ k i k u
m Zwick | t s w I k 200 h 20
m Zwänggring | t s w a N g g r I N g
f Zwätschge | t s w a t S g @
m Zäieföhner | t s a 200 i @ f 2 200 n @ r
m Zürcher | t s Y 200 r x @ r
f auti Hafehuer | A u t 200 i h A f @ h u @ r
m genetische Müuhuufe | g e n e 200 t i S @ m Y u h u 200 f 200 @
m Äschebächer | a S 200 @ b a x 200 @ r
m Ätti mit Huet | a t 200 i _ 20 m I t h u @ t
""".trimLines().map { Entry.of(it) { Gendered(it) } }
}