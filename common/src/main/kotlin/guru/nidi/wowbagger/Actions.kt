package guru.nidi.wowbagger

import guru.nidi.wowbagger.Wowbagger.trimLines

object Actions {
    val list = """
aber süsch bisch no gsung? | A b @ r s Y S _ 50 b I S n o g s 10 100 u N g 100 120
aber süsch geit's? | A b @ r s 2 S _ 50 g e 10 100 i t s 100 120
adiemerssi! | A d i @ m e r s 200 10 100 i 100 80
bi dir chauberet doch der Brüggstock! | b I d I 200 r x A u b @ r @ t d o x d e b r Y k 200 S t o k
bisch bisse? | b I S b 10 100 I 100 120 s 200 @ 150
bisch nid ganz bache? | b I S n I d g A n t s b 10 100 A 200 100 110 x 150 @
bisch nid ganz hundert? | b I S n I d g A n t s h 10 100 u 150 100 110 n d @ r t
bisch ir Gäggelischuel blibe hocke? | b I S i r g a 200 k 200 @ l i S u @ l b l I b @ 10 100 h o 100 110 k 200 h 50 @
bisch mit em Gertu usgrütscht? | b I S m I t @ m _ 20 g e 150 r t u _ 20 u s g r 10 100 y 100 110 t S t
bisch ir Spinnhumbbele blibe stecke? | b I S I r S p i n 200 h u m p 200 @ l @ b l i b @ S t 10 100 e 100 110 k 200 h 50 @
bisch am Haag a? | b I S A m h A 200 g 10 100 A 300 100 110
chunsch de is Chefi! | x u n S d e _ 20 i s x e f i
du hesch so ne längi Leitig! | d u h e S s O 200 n @ l a 150 N g i l e i t 200 i k
fahr ab! | f A 200 r _ 20 A p 200
gang doch go bääbele! | g A N d O x g O p a 200 p @ l @
geit's eigentlech no? | g e i t s e i g @ n t l @ x n O 200
haut der Latz! | h A u t d O x d @ r l A t s 200
haut s'Gfräs! | h A u t s g f r a 200 s 200
hesch e Flick furt? | h e S @ _ 20 f l I k 200 h 50 f u r t 200
hesch e Knick ir Fichte? | h e S @ _ 20 k n I k 200 h 50 i r f I x t @
hesch en Egge ab? | h e S @ n _ 20 e k 200 e A p 200
hesch es warms Joghurt im Sack? | h e S @ s w A 200 r m s i o g u r t i m s A k 200
hesch Mähl am Ermu? | h e S m a 200 u A m e r m u
hesch z'heiss badet? | h e S t s h e i s 200 b A d @ t
hesch z'vüu Bätziwasser gha? | h e S t s f Y u b a t s i w A s 200 @ r g h A 200
hesch ir Bschütti badet? | h e S i r b S Y t 200 i b A d @ t
hesch de Gluggsi? | h e S d @ g l u k 200 s i
hesch e dräckige Naselumpe! | h e S @ d r a k 200 i g @ n A s @ l u m 200 p @
heschs Gschtäutli verlore? | h e S s g S t a u t l i f @ 50 r l O 200 r @
hesch nüm aui Lätsche ar Lismete? | h e S n Y m A u i l a t S @ 150 _ 20 A r l I s m @ t 200 @
hesch e stumpfe Hegu? | h e S @ S t u m p f @ h e g u
hesch nid aui Scheieli am Hag? | h e S n I d A u 200 i S e i @ l i A m h A 200 k
hesch z'vüu ploderet? | h e S t s f Y u p l O d @ r @ t
heschs Ohremüggeli? | h e S s _ 20 O 200 r @ m Y k 200 @ l i
hesch Gsüchti? | h e S g s y x t i
hesch es Gnusch im Fadechörbli? | h e S _ 20 @ s g n u 200 S i m f A d @ x 2 200 r b l i
het's dr i Weize gschneit? | h e t s d r _ 20 i w e i t s @ g S n e i t 200
het's dr is Hirni geschisse? | h e t s d r i s h I r n i g S I s 200 @
hou's! | h o u s 200
häb doch mau d'Schnure! | h a p d O x m O u d S n u r @
hör uf gfätterle! | h 2 r u f g f a t 200 @ 50 r l @
hör uf lauere! | h 2 r u f l A u @ r @
hör uf gigampfe! | h 2 r u f g i g A m p f @
hör uf zaagge! | h 2 r u f t s A 200 k 200 @
hör uf liire! | h 2 r u f l i 200 r @
i brätsche der eis! | I b r a t S @ d @ r _ 20 e i s
i gheie di i Ghüder! | I g h e 200 i @ d i _ 50 i g h Y d @ r
i gib der mit em Teppichchlopfer! | I g I p d r m I t @ 50 m t 200 e p 200 i x x l o p f @ r
i gorbse der i Gring! | I k O 200 r b s @ d @ r i g r I N g
i müpfe di i See! | I m Y p f @ d i i s e 200
i putz der d'Chuttle! | I p u t s d @ r _ 20 d x u t 200 l @
i tätsche der eis! | I t a t S @ d @ r e i s
i gib der mit der Wedele! | I g I b t @ r _ 20 m I t 200 @ 50 r w e d @ l @
i nimm di am Grännihaar! | I n I m 200 d i A m g r a n 200 i h O 200 r
i poliere der s'Gröibschi | I p o l i @ r @ d @ r s g r 2 i b S i
i tue der ds Gurli fiegge! | I t u @ d @ r d s g u r l i f i @ k 200 @
i säg der au Gott Schand! | I s a k d @ r A u g O t 200 S A N g
i verminggle dir s'Bätzi dass d'Osterpföteler ghörsch zawanggle! | I f @ r m i N k 200 l @ d @ r s b a t 200 s i d A s 200 d O 200 S t @ r p f 2 200 t 200 @ l @ r g h 2 r S t s A w A n k 200 l @
i zeih der d'Gängeretalpli läng! | I _ 20 t s i e d @ r _ 20 d g a N 200 @ r @ t A l p l i l a N g
i vermöckle der de Schtirps mit em Flarzise! | I f @ r m 2 k 200 h 50 l @ d @ r d e S t I r p s m I t @ m f l A r t s i s @
i zwurgle di mit em Gürchu! | I _ 20 t s w u r g l @ d i m I t 200 @ m g Y 200 r x u
i bring di uf d'Gnagihoschtet! | I b r I N d i u f d g n A 200 g i h O S t @ t
i treichle der öpis! | I t r e i x l @ d @ r 2 p 200 i s
i gib der eis uf'd Rösti! | I g I b d @ r e i s u f _ 20 d r 2 200 S t i
i zeig dr wo de Bartli de Most hout! | I _ 20 t s e i k 200 d @ r w O d @ b A 200 r t l i d @ m O S t h o u t 200
läck mi am Arsch! | l a k 200 m i A m A 200 r S 200
mach kes Gschiss! | m A x k h 50 e s g S i 200 s 200
putz di furt! | p u t s d i _ 20 f u r t 200
schieb ne! | S i @ b n @
schlift's? | S l i 200 f t s
tue nid töipele! | t u @ n I d _ 20 t 2 i p 200 @ l @
tue mou richtig wärche! | t u @ m o u r I x t i g w a r x @
tue mer am Gätzi rätsche! | t u @ m @ r A m g a t s i r a 200 t S @
tuesch hurti öpis härejufle? | t u @ S h u r t i 2 p 200 i s h a r @ i u f l @
tue nid mit em Gagu spile! | t u @ n I d m I t 200 @ m g A g u S p I l @
tue z'Nüni näh! | t u @ t s n y 200 n i n a 200
tue nid chafle! | t u @ n I d x A f l @
verreis! | f @ r r e i s 200
wosch e Chlapf a Grind? | w O S @ x l A p f A g r i N g
was isch mit dim Hosegschingg? | w A s I S m I t d i m h O s @ g S I N k 200
was hesch gänggelet? | w A s h @ S k a N k 200 @ l @ t
was schilisch? | w A s S I l i S
was fuschtisch do? | w A s f u 200 S t i S d O 200
was machsch für ne Lätsch? | w A s m A x S f Y r n @ l a t S 200
wärsch froh hättisch en einzige nuesige Schiggeler uf em Lugipfupf! | w a r S f r O 200 h a t 200 i S @ n e i n t s i g @ n u e s i g @ S I k 200 @ l @ r u f @ m l u g i p f u p f
wird der gschmuech? | w I r t @ 50 r g S m u @ x
was chnüblisch do? | w A s x n y 200 b l i S d O 200
wenn i dis Gsicht aluege, bin i mit mim Füdle ganz z'fride. | w e n I 200 d i s g s I x t A l u @ g @ b I n I m I t m i m f Y d l @ 50 g A n t s _ 20 t s f r I d @
verzeu vo dim Umfall. | f @ r t s @ u f O d i m u m f A u _ 20
mues me di dängele? | m u @ s m @ d i d a N 200 @ l @ _ 20
gang dänne! | g A N g 50 d a n 200 @ _ 20
dir muess me s'Füdle fäge! | d I r m u @ s m @ s f Y d l @ f a g @ _ 20
geisch mer ufs Gäder! | g e i S m @ r u f s g a d @ r
gump doch ine Glungge! | g u m p d O x i n @ g l u N k 200 @ _ 20
muess me di früsch griene? | m u @ s m @ d i f r Y S g r i @ n @ _ 20
hantli is Bett! | h A n t 200 l i i s b e t 200
gang doch ar Aare nah! | g A 150 N d O x A r A 250 r @ n A 300
gsesch us wie nes Meertrübeli! | g s e 200 S u 200 s w i @ 50 n @ s m e 200 r t r y b @ l i
du meggisch! | d u m e k 200 i S 200
schnütz di mou! | S n y t s d i m O 200 u _ 20
bääg doch nid so blöd! | b a 200 k 200 d O x n I d s O b l 2 200 t
jetz räblet's! | i @ t s r a b l @ t s
Houptsach es rouchnet, Housi! | h o 50 u p t s A x @ s r o u x n @ t h o u s i
du bisch zum schiesse! | d u b I S t s u m S i @ s 200 @ _ 20
hör uf spöifere! | h 2 r u f S p 2 i f @ r @ _ 20
häb d'Talpe wäg! | h a b _ 50 t A u p 200 @ w a k 200 h 50
gang go z'Acher fahre! | g A N g _ 20 g O t s A x 200 @ r f A 200 r @
rum di Göppu dänne! | r u m d i g 2 p 200 u d a n 200 @ _ 20
bohr nid i de Ohre! | b O 200 r n I d i d @ O 300 r @ _ 20
chotz nid so! | x O t s n I d s O
chunsch grad usem Chätschäbertrog? | x u n S g r A d u s @ m x a t S a b @ 50 r t r O 200 k
chunnt de Wurschtsalat zrügg? | x u n t d @ w u r S t s A l A 200 t _ 50 t s r Y k 200
du chasch nid mou s'Gräppli im Hotschmägli bleike! | d u x A S n I d m o u s g r a p 200 l i I m h O t S m a g l i b l e i k 200 h 50 @ _ 20
furz nid so i der Chile! | f u 200 r t s n I d s O i d r x I l @ _ 20
friss nid us der Chatzechischte! | f r I s n I d u s d @ 50 r x A t s @ x I S t @ _ 20
grunz nid so grusig! | g r u n t s n I d s O g r u 200 s i g
guuggets der im Schissächerli? | g u 200 k 200 @ t s d @ r i m S i s a x 200 @ 50 r l i
schnäggelisch grad ziemlech us dr Gosche! | S n a k 200 @ l i S g r A d t s i @ m l @ x u s d @ 50 r g O S 200 @ _ 20
schmöcksch wie bschüttigs Chrützimähl! | S m 2 k 200 h 50 S w i @ b S y t 200 i g s x r y 200 t s i m a 200 l
schnorsch grusig wiene Moore! | S n O r S g r u 200 s i g w i @ 50 n @ m O 200 r @ _ 20
schläck nid a de Böögge! | S l a k 200 n I d A d @ b 2 200 k 200 @ _ 20
sug a! | s u 200 g _ 50 A 300
dampf ab! | d A m p f _ 50 A p 200 h 50
i tue der eini abewäsche! | I t u @ d @ 50 r e i n i A b @ w a S 200 @ _ 20
bisch wieder abghaset? | b I S w I d @ r A b g h A s @ t 200
mach nid s'Chaub! | m A x n I d s x A u p 200
tue nid soublöd! | t u @ n I d s o u b l 2 200 t
i passe der ab! | I p A s 200 @ d @ 50 r A p 200 h 50
i verschwarte di! | I f @ r S w A r t @ d i
was tuesch wieder absüdere? | w A s t u @ S w I d @ r A b s Y d @ r @ _ 20
di muess me abtue! | d I 200 m u @ s m @ A p t u @ _ 20
i schrisse di übers Näscht ab! | I S r i 200 s 200 @ d I Y b @ r s n a S t A p 200 h 50
tue nid so affig! | t u @ n I d s O A f 200 i k 200
chasch mer am Ranze hange! | x A S m @ r A m r A n t s @ 50 h A N 200 @ _ 20
das geit bachab mit dir! | d A s g e i t b A x A p m I t d I 200 r
lah ne la bambele! | l A n @ l A b A m b @ l @ _ 20
bisch go blüemele? | b I S g O b l y @ m @ l @ _ 20
strich der das ads Bei! | S t r i 200 x _ 20 d r d A 200 s A s b e i
i paniere der eis! | I p A n i @ r @ d @ r e i s 200
hesch öppis gseit, oder nume ds Bis gwächslet? | h e S 2 p 200 i s g s e i t O d @ r n u m @ d s b I 200 s g w a x s l @ t
bruchsch e Bisiblätz? | b u 200 x S @ b i s i b l a t s
red ke Bläch! | r e d k 200 h 50 e b l a 200 x 200
blos mer id Schueh! | b l O 200 s m @ r i d S u @ _ 20
hesch es blutts Näll? | h e S @ s b l u t 200 s n a l 200
hüt geisch z'Bode! | h Y t g e i S t s b O d @ _ 20
hesch de Bröcklihueschte? | h e S d @ b r 2 k 200 h 50 l i h u @ S t @ _ 20
i bole der eis! | I b O l @ d @ r e i s
do hesch es Foto fürs Böögenalbum! | d O h e S @ s f O t 200 O f Y r s b 2 200 k 200 @ n A l b u m _ 20
was bosgisch wieder? | w A s p O 200 s g i S w I d @ r
hesch e Bränte glade? | h e S @ b r a n 200 t @ g l A 200 d @ _ 20
du böckelisch! | d u b 2 k 200 h 50 @ l i S 200
bisch blind uf de Ouge? | b I S b l I N u f d @ _ 50 o u g @ _ 20
das git Lämpe! | d A s g I t l a m p @ _ 20
i schutte der eis i Arsch! | I S u t 200 @ d @ r e i s i A 200 r S 200
gang doch anes Chäferfescht! | g A N d O x A n @ s x a f @ r f e S t
i schisse der id Chappe! | I S i 200 s 200 @ d @ r i d x A p 200 @ _ 20
wäm bisch wieder a Chare gfahre? | w a m b I S w @ d @ r A x A r @ g f A 200 r @ _ 20
was lisisch für nes Chäsblatt? | w A s l I s i S f Y r 50 n @ s x a 200 s b l A t 200
i drück der d'Chäspedau i Gring! | I d r Y k h 50 d @ 50 r d x a 200 s p e d A 200 u i g r I N g
chätsch nid so grusig! | x a t S n I d s O g r u 200 s i g
hesch e Fige wie ne gchläpfte Aff! | h e S @ f i g @ w i @ n @ g x l a p f t @ A 200 f 300
jetz fählsch de grad! | i e t s f a 200 l S d e g r A t 200
chlemm ab! | x l e m 200 _ 50 A p 200 h 50
wäsch der d'Chlööpe! | w a S 200 d @ r d x l 2 200 p 200 @ _ 20
i pänggle der e Chnebu zwüsche d'Bei! | I p a N k 200 l @ d @ 50 r @ x n e b u t s w Y S 200 @ d b e i
i packe di am Chrage! | I _ 20 p 200 A k 200 h 50 @ d i A m x r A g @ _ 20
du chunsch nie id Chränz! | d u x u n S n i @ i d x r a n t s
du chunsch nid usem Schider! | d u x u n S n I d u s @ m S n i 200 d @ r
dis Chrutzli legi der zäme! | d i s x r u t s l i l e g i d @ r t s a m @ _ 20
hesch e Churze ide Hose? | h e S @ x u 200 r t s @ i d @ h O s @ _ 20
jetz git's ufs Dach! | i e t s g I t s u f s d A 200 x 200
hesch id Hose gmacht? | h e S i d h O s @ g m A x t
du bisch dschuld! | d u b I S t S u l d
häb ke Dummi! | h a b k 200 h 50 e d u m 200 i
zieh Fäde! | z i @ f a d @ _ 20
hesch e Fädilätsch im Hirni? | h e S @ f a d i l a t S i m h I r n i
fäut's der? | f a 200 u t s d @ r
fertig schnätz! | f e r t i g S n a t s
fertig luschtig jetz! | f e r t i g l u S t i g i e t s
figg di! | f I k 200 d i
chunsch de flach use! | x u n S d e f l A x 200 u s @ _ 20
hesch es Fröideli? | h e S @ s f r 2 i d @ l i
mach kes Gabaree! | m A x k h 50 e s g A b A r e 200 _ 20
mach kes Ghöi! | m A x k h 50 e s k h 2 i
was holeiisch wieder? | w A s h o l e i i S w I d @ r
gib ihm chli! | g I b i m x l i
hesch de Glöggeler nid agha? | h e S d @ g l 2 k 200 @ l @ r n I d A 300 g h A 200
du bisch zum göögge! | d u b I S t s u m S i @ s 200 @ _ 20
i gschweigge di grad! | I g S w e i k 200 @ d i g r A t
geisch uf d'Gsüchtihoschtet? | g e i S u f d g s Y x t i h O S t @ t
du bisch zum Haaröuseiche! | d u b I S t s u m h A 200 r 2 200 u s e i x @ _ 20
""".trimLines().map { Entry.of(it) { it } }
}