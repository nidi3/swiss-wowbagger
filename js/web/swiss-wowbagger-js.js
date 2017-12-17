if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'swiss-wowbagger-js'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'swiss-wowbagger-js'.");
}
this['swiss-wowbagger-js'] = function (_, Kotlin) {
  'use strict';
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  var lines = Kotlin.kotlin.text.lines_gw00vp$;
  var equals = Kotlin.equals;
  var Enum = Kotlin.kotlin.Enum;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var throwISE = Kotlin.throwISE;
  var contains = Kotlin.kotlin.text.contains_li3zpu$;
  var Regex = Kotlin.kotlin.text.Regex_61zpoe$;
  var numberToInt = Kotlin.numberToInt;
  var capitalize = Kotlin.kotlin.text.capitalize_pdl1vz$;
  Gender.prototype = Object.create(Enum.prototype);
  Gender.prototype.constructor = Gender;
  function Actions() {
    Actions_instance = this;
    this.list = Wowbagger_getInstance().trimLines_7efafi$("\naber s\xFCsch bisch no gsung?\naber s\xFCsch geit's?\nadiemerssi!\nbi dir chauberet doch der Br\xFCggstock!\nbisch bisse?\nbisch nid ganz bache?\nbisch nid ganz hundert?\nbisch ir G\xE4ggelischuel blibe hocke?\nbisch mit em Gertu usgr\xFCtscht?\nbisch ir Spinnhumbbele blibe stecke?\nbisch am Haag a?\nchunsch de is Chefi!\ndu hesch so ne l\xE4ngi Leitig!\nfahr ab!\ngang doch go b\xE4\xE4bele!\ngeit's eigentlech no?\nhaut der Latz!\nhaut s'Gfr\xE4s!\nhesch e Flick furt?\nhesch e Knick ir Fichte?\nhesch en Egge ab?\nhesch es warms Joghurt im Sack?\nhesch M\xE4hl am Ermu?\nhesch z'heiss badet?\nhesch z'v\xFCu B\xE4tziwasser gha?\nhesch ir Bsch\xFCtti badet?\nhesch de Gluggsi?\nhesch e dr\xE4ckige Naselumpe!\nheschs Gscht\xE4utli verlore?\nhesch n\xFCm aui L\xE4tsche ar Lismete?\nhesch e stumpfe Hegu?\nhesch nid aui Scheieli am Hag?\nhesch z'v\xFCu ploderet?\nheschs Ohrem\xFCggeli?\nhesch Gs\xFCchti?\nhesch es Gnusch im Fadech\xF6rbli?\nhet's dr i Weize gschneit?\nhet's dr is Hirni geschisse?\nhou's!\nh\xE4b doch mau d'Schnure!\nh\xF6r uf gf\xE4tterle!\nh\xF6r uf lauere!\nh\xF6r uf gigampfe!\nh\xF6r uf zaagge!\nh\xF6r uf liire!\ni br\xE4tsche der eis!\ni gheie di i Gh\xFCder!\ni gib der mit em Teppichchlopfer!\ni gorbse der i Gring!\ni m\xFCpfe di i See!\ni putz der d'Chuttle!\ni t\xE4tsche der eis!\ni gib der mit der Wedele!\ni nimm di am Gr\xE4nnihaar!\ni poliere der s'Gr\xF6ibschi\ni tue der ds Gurli fiegge!\ni s\xE4g der au Gott Schand!\ni verminggle dir s'B\xE4tzi dass d'Osterpf\xF6teler gh\xF6rsch zawanggle!\ni zeih der d'G\xE4ngeretalpli l\xE4ng!\ni verm\xF6ckle der de Schtirps mit em Flarzise!\ni zwurgle di mit dem G\xFCrchu!\ni bring di auf d'Gnagihoschtet!\ni treichle der \xF6pis!\ni gib der eis uf'd R\xF6sti!\ni zeig dr wo de Bartli de Most hout!\nl\xE4ck mi am Arsch!\nmach kes Gschiss!\nputz di furt!\nschieb ne!\nschlift's?\ntue nid t\xF6ipele!\ntue mou richtig w\xE4rche!\ntue mer am G\xE4tzi r\xE4tsche!\ntuesch hurti \xF6pis h\xE4rejufle?\ntue nid mit em Gagu spile!\ntue z'N\xFCni n\xE4h!\ntue nid chafle!\nverreis!\nwosch e Chlapf a Grind?\nwas isch mit dim Hosegschingg?\nwas hesch g\xE4nggelet?\nwas schilisch?\nwas fuschtisch do?\nwas machsch f\xFCr ne L\xE4tsch?\nw\xE4rsch froh h\xE4ttisch en einzige nuesige Schiggeler uf em Lugipfupf!\nwird der gschmuech?\nwas chn\xFCblisch do?\nwenn i dis Gsicht aluege, bin i mit mim F\xFCdle ganz z'fride.\nverzeu vo dim Umfall.\nmues me di d\xE4ngele?\ngang d\xE4nne!\ndir muess me s'F\xFCdle f\xE4ge!\ngeisch mer ufs G\xE4der!\ngump doch ine Glungge!\nmuess me di fr\xFCsch griene?\nhantli is Bett!\ngang doch ar Aare nah!\ngsesch us wie nes Meertr\xFCbeli!\ndu meggisch!\nschn\xFCtz di mou!\nb\xE4\xE4g doch nid so bl\xF6d!\njetz r\xE4blet's!\nHouptsach es rouchnet, Housi!\ndu bisch zum schiesse!\nh\xF6r uf sp\xF6ifere!\nh\xE4b d'Talpe w\xE4g!\ngang go z'Acher fahre!\nrum di G\xF6ppu d\xE4nne!\nbohr nid i de Ohre!\nchotz nid so!\nchunsch grad usem Ch\xE4tsch\xE4bertrog?\nchunnt de Wurschtsalat zr\xFCgg?\ndu chasch nid mou s'Gr\xE4ppli im Hotschm\xE4gli bleike!\nfurz nid so i der Chile!\nfriss nid us der Chatzechischte!\ngrunz nid so grusig!\nguuggets der im Schiss\xE4cherli?\nschn\xE4ggelisch grad ziemlech us dr Gosche!\nschm\xF6cksch wie bsch\xFCttigs Chr\xFCtzim\xE4hl!\nschnorsch grusig wiene Moore!\nschl\xE4ck nid a de B\xF6\xF6gge!\nsug a!\ndampf ab!\ni tue der eini abew\xE4sche!\nbisch wieder abghaset?\nmach nid s'Chaub!\ntue nid soubl\xF6d!\ni passe der ab!\ni verschwarte di!\nwas tuesch wieder abs\xFCdere?\ndi muess me abtue!\ni schrisse di \xFCbers N\xE4scht ab!\ntue nid so affig!\nchasch mer am Ranze hange!\ndas geit bachab mit dir!\nlah ne la bambele!\nbisch go bl\xFCemele?\nstrich der das ads Bei!\ni paniere der eis!\nhesch \xF6ppis gseit, oder nume ds Bis gw\xE4chslet?\nbruchsch e Bisibl\xE4tz?\nred ke Bl\xE4ch!\nblos mer id Schueh!\nhesch es blutts N\xE4ll?\nh\xFCt geisch z'Bode!\nhesch de Br\xF6cklihueschte?\ni bole der eis!\ndo hesch es Foto f\xFCrs B\xF6\xF6genalbum!\nwas bosgisch wieder?\nhesch e Br\xE4nte glade?\ndu b\xF6ckelisch!\nbisch blind uf de Ouge?\ndas git L\xE4mpe!\ni schutte der eis i Arsch!\ngang doch anes Ch\xE4ferfescht!\ni schisse der id Chappe!\nw\xE4m bisch wieder a Chare gfahre?\nwas lisisch f\xFCr nes Ch\xE4sblatt?\ni dr\xFCck der d'Ch\xE4spedau i Gring!\nch\xE4tsch nid so grusig!\nhesch e Fige wie ne gchl\xE4pfte Aff!\njetz f\xE4hlsch de grad!\nchlemm ab!\nw\xE4sch der d'Chl\xF6\xF6pe!\ni p\xE4ngle der e Chnebu zw\xFCsche d'Bei!\ni packe di am Chrage!\ndu chunsch nie id Chr\xE4nz!\ndu chunsch nid usem Schider!\ndis Chrutzli legi der z\xE4me!\nhesch e Churze ide Hose?\njetz git's aufs Dach!\nhesch id Hose gmacht?\ndu bisch dschuld!\nh\xE4b ke Dummi!\nzieh F\xE4de!\n");
  }
  Actions.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Actions',
    interfaces: []
  };
  var Actions_instance = null;
  function Actions_getInstance() {
    if (Actions_instance === null) {
      new Actions();
    }
    return Actions_instance;
  }
  var collectionSizeOrDefault = Kotlin.kotlin.collections.collectionSizeOrDefault_ba2ldo$;
  var ArrayList_init = Kotlin.kotlin.collections.ArrayList_init_ww73n8$;
  function Adjectives() {
    Adjectives_instance = this;
    var $receiver = Wowbagger_getInstance().trimLines_7efafi$('\naarig\naabr\xF6nt\naabislet\naagchaflet\naagch\xE4tschet\naagfigget\nabegmechet\nabgfigget\nabgnaget\nabgs\xE4rblet\nabgschiffet\nabverheit\naghotschet\nagn\xF6ttelet\nagschissen\narrogant\nbl\xF6d\nbireweich\nbockst\xF6ssig\nbreitarschig\nb\xF6ckelig\nb\xFCnzlig\ncharesaubig\ncheib\ncheibedoof\nchlingh\xFCselet\nchn\xFCtschblau\nchoderpflotschig\nchotzbrockem\xE4ssig\nchotzp\xE4ngglig\nch\xE4ferf\xFCdletroch\nch\xE4sig\ndegoutant\ndoof\ndoppuchinig\ndrischaagget\ndumm\nd\xFCregheit\nel\xE4nd\nel\xE4nd(e/s/i) huere(//)\nfausch glismet\nfeiss\nfutzdumm\nf\xFCdleblutt\ngagug\xE4lb\ngch\xE4ppelet\ngibuhaarig\ngnietig\ngrusig\ngopfertecku(//)\ngopferdammt\ngruebegr\xE4sslech\ngschiferlig\ngschl\xE4fzig\ngschniglet\ngstabig\ng\xE4\xE4j\nhalbbatzig\nhimutrurig\nhingereglitzt\nhingerfotzig\nhingerbiggelig\nhingerletscht\nhingerletscht(e/s/i) huere(//)\nhohl\nhuere(//)\nichegschw\xE4rzelet\nid Chn\xF6de gl\xF6tet\nidiotisch\nis Hirni gschissen\nkuurlig\nlamaschig\nl\xE4ufig\nl\xFCtzl\nmies(e/es/i)\nmiggerig\nmuderig\nn\xFC\xFCtratzig\nn\xFC\xFCtw\xE4rchig\nobergruusig\npseudogschiid\np\xE4gguhaarig\nquergvoglet\nranzig\nrumpelsuurig\nschitter\nschnarchnasig\nschn\xE4derfr\xE4sig\nschwauderig\nsteih\xE4sslech\nstrub\ns\xFCderig\ntunggig\nt\xFCfus\xFCchtig\numegschl\xE4berlet\nunerchannt\nungerbeliechtet\nulidig\nugantlig\nuschaflig\nverbib\xE4bbelet\nverbrunzet\nverchiset\nverchoderet\nverdammt\nverfigget\nverhudlet\nverreckt\nversiechet\nversouet\nvervoglet\nvom Aff bissen\nw\xE4ltsch(e/es/i)\nw\xFCescht\n');
    var destination = ArrayList_init(collectionSizeOrDefault($receiver, 10));
    var tmp$;
    tmp$ = $receiver.iterator();
    while (tmp$.hasNext()) {
      var item = tmp$.next();
      destination.add_11rb$(new Adjective(item));
    }
    this.list = destination;
  }
  Adjectives.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Adjectives',
    interfaces: []
  };
  var Adjectives_instance = null;
  function Adjectives_getInstance() {
    if (Adjectives_instance === null) {
      new Adjectives();
    }
    return Adjectives_instance;
  }
  function Interjections() {
    Interjections_instance = this;
    this.list = Wowbagger_getInstance().trimLines_7efafi$("\nalemarsch\napropo\nbigoscht\nbissoguet\nblasius\nBockmischt\nChutzemischt\nChabis\nChnebuschissi\nChr\xFCckem\xFCnz\nChuepl\xE4tter\nDonnergueg\nDonnerschiess\nDonnerw\xE4tter\ndumms Gl\xF6\xF6l\ndumms Z\xFCg\nE du verruckt\nEichuzyste\nF\xE4regsch\xE4derli und M\xF6uchgr\xF6\xF6tzi\nFigugegl\ngopfertami\ngopfertecku nomou\ngopfertoori\ngopfrid Stutz\ngoppeletti\nGschm\xF6is\ngschtoche Bock\nHafech\xE4s\nHammersack\nHawasch\nheimatland\nheilandsack\nheilandtonner\nheilige Beck\nheitere Fahne\nhenusode\nherrgotttonnerw\xE4tter\nherrgott St\xE4rne\nhimupl\xFCtter\nhuere Moorerei do\nhueresiech\ni Gotts Name\ni mache es Chr\xFCtz ad Tili\nim Fau\njo was ch\xE4tzers\nleidi Sach\nl\xE4ck\nmi Gotts T\xFCri\nmitz id Chuchi\noha l\xE4tz\nPfiffetechu\npotz Himurieme\npotz Holz\xF6pfel und Zipfelchappe\npotztusig\nschiss ad Wang\nSchissdr\xE4ck am Loufmeter\nSchnuder im Telefon\nst\xE4cket\xF6\xF6ri\nSt\xE4rnef\xF6ifi\ntamisiech\nverdammt\nverfluecht\nvou chr\xFC\xFCsch\nweiss der Gugger\nz'eis Dapf\nz'Gotts B\xE4ri\nZeiech\xE4s\n\xE4u\xE4 nid\n\xE4u\xE4 scho\n\xE4tsch\n\xFC\xFC\xFCble Sache\n");
  }
  Interjections.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Interjections',
    interfaces: []
  };
  var Interjections_instance = null;
  function Interjections_getInstance() {
    if (Interjections_instance === null) {
      new Interjections();
    }
    return Interjections_instance;
  }
  function Names() {
    Names_instance = this;
    var $receiver = Wowbagger_getInstance().trimLines_7efafi$('\nm \xC4du\nf Andle\nm \xC4ndu\nf \xC4nnele\nf Anneb\xE4bi\nm Aschi\nf Beetli\nm Be\xE4tu\nm Bidu\nm Beni\nm B\xE4nz\nm Br\xFCnu\nm Chl\xF6isu\nm Chrigu\nf Chrige\nm Ch\xE4schpu\nm D\xE4nu\nm D\xE4vu\nm D\xF6lf\nm F\xE4bu\nm Fige\nm Fippu\nm Fixu\nm Fl\xF6ru\nm Fr\xE4nzu\nm Fredu\nm Fritzli\nm Godi\nm Gusti\nf Heidle\nm Hene\nm Housi\nm J\xE4nu\nf Jole\nm J\xFCre\nm K\xF6bu\nm Kari\nm K\xE4ru\nm Kusi\nm K\xFCsu\nm K\xFCre\nm Lexu\nf Lise\nm L\xFCku\nm M\xE4nu\nm M\xE4rgu\nm M\xE4rsu\nm M\xE4ru\nm M\xE4thu\nm Michu\nf M\xF6ne\nm Niku\nf Nigge\nm \xD6lu\nm P\xE4scu\nm P\xE4du\nm P\xF6ilu\nm Pesche\nm R\xE4ffu\nm Res\nm Ret\xF6lu\nm Role\nm R\xF6lu\nm R\xF6schu\nm R\xFCfe\nm R\xF6ifu\nm R\xF6mu\nf Sabe\nm S\xE4mu\nm S\xE4ndu\nm S\xE4schu\nm Sebu\nf Sile\nm Simu\nf Sime\nf S\xF6ne\nm Steffu\nm Stifu\nf Susle\nm Seppu\nm Sch\xE4mpu\nf Schane\nm St\xF6ffu\nf Tesi\nf Tesle\nm Tinu\nf Trixle\nf Trudle\nm T\xF6mu\nm T\xF6nu\nm \xDCelu\nm \xDCrsu\nm Wale\nm W\xE4utu\nm Wernu\nm Werni\nf Vane\nm Vidu\nf Vrene\n');
    var destination = ArrayList_init(collectionSizeOrDefault($receiver, 10));
    var tmp$;
    tmp$ = $receiver.iterator();
    while (tmp$.hasNext()) {
      var item = tmp$.next();
      destination.add_11rb$(Gendered_init(item));
    }
    this.list = destination;
  }
  Names.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Names',
    interfaces: []
  };
  var Names_instance = null;
  function Names_getInstance() {
    if (Names_instance === null) {
      new Names();
    }
    return Names_instance;
  }
  function Subjects() {
    Subjects_instance = this;
    var $receiver = Wowbagger_getInstance().trimLines_7efafi$('\nm Aargouer Outofahrer\nf Acherm\xE4hre\nn Alpechalb\nm Aff\nm Angschthas\nm Arschch\xE4fer\nf Arschgige\nm Arschgigu\nn Arschkantefilet\nm Aschi\nn Aupechaub\nf Baabe\nf Bagglimoore\nn Baslerbebbi\nm Batzechlemmer\nm Bettseicher\nn Bipperlisi\nm Bisibueb\nn Bisib\xE4\xE4bi\nm Bisitrinker\nm Blickl\xE4ser\nm Bl\xF6dian\nm Bl\xF6ffsack\nn Bohneross\nf Bohnestange\nm Braschti\nm Br\xE4mest\xE4nder\nm Bschishung\nf B\xE4nnesou\nf B\xE4rg\xE4nte\nm B\xE4se\nn B\xE4ser\xE4\xE4f\nm B\xE4\xE4ggisiech\nf Bire\nm Birewixer\nm Bhouptisiech\nm B\xF6\xF6ggefr\xE4sser\nm B\xFCffu\nm B\xFCnzli\nm B\xFCrokolleg\nm Chafler\nm Chaflicheib\nm Chatzestrecker\nm Chegelebr\xE4gler\nm Cheib\nm Chirschig\xE4gger\nm Chiubi-Gigu\nf Chleechue\nf Chlefe\nn Chlepfschit\nm Chnorzi\nm Chn\xFCblisiech\nm Chotzch\xFCbu\nm Choderi\nm Cholesack\nm Chouderi\nm Chr\xFCppucheib\nm Chr\xFCppuhung\nn Chuderluuri\nn Chuef\xFCdle\nm Chutzemischt\nm Ch\xFCttenechotzer\nm Chuttlefr\xE4sser\nm Ch\xE4\xE4ri\nm Ch\xF6\xF6zi\nn Dascheli\nn Doggeli\nm Dorfmuni\nm Dr\xE4cksack\nm D\xFCppugring\nn Eiterbibeli\nm Figgf\xE4hler\nn Fin\xF6ggeli\nm Fr\xE4sshung\nm Fuschti\nm Futz\nm Futzbuur\nm Futzgring\nm F\xFCdlib\xFCrger\nn F\xE4gn\xE4scht\nf F\xE4rlimore\nm F\xF6tzu\nm F\xF6tzucheib\nm F\xF6tzusiech\nm Gal\xF6\xF6ri\nm Gartefeschtplouderi\nf Gibe\nm Gigu\nm Gigusiech\nm Gitzeler\nm Gitzgn\xE4pper\nn Gj\xE4tt\nm Globivogu\nm Gl\xF6gglifr\xF6sch\nm Gl\xFCnggi\nm Gl\xFCschteler\nm Gnieti\nm Gorilla Blauarsch\nm Grittib\xE4nz\nm Groggermooslaferi\nm Gr\xE4nni\nm Gr\xFCsu\nm Gschtabi\nm Gschtabicheib\nm Gummihaus\nf Gumsle\nm G\xE4derh\xE4chu\nn G\xE4deriwyb\nn G\xE4derimanndli\nn G\xFCezi\nm Haagge\nn Haaghuuri\nm Habasch\nf Hafehuer\nm Hagu\nm Heilandtonner\nm Hornochs\nm Hudilump\nn Hundshammli\nf Hundsniere\nm Hueresiech\nm Hurli-Gwaag\nm Hurrlibueb\nm H\xF6seler\nm H\xF6uzu\nm Im-Kreisu-Links-Blinker\nm Krouteri\nn Kamuff\nm Laferi\nm Lafericheib\nm Laferisiech\nm Laggaff\nm Lappi\nm Lauerisiech\nm Lumpehung\nm Lyrib\xE4nz\nm L\xFCmu\nf Memme\nn Miuchmubi\nn Mischtschwibeli\nm Mongo\nm Mongobilly\nf Moore\nm Motzi\nm Mulaff\nm Muggigring\nm M\xE4rebr\xE4tscher\nm M\xF6\xF6gigring\nm M\xF6ngu\nm M\xF6ff\nm M\xFCrggu\nm Nasep\xF6\xF6ggu\nm N\xE4rvsack\nm Pajass\nf Panne\nm Plouderi\nm Pflock\nm Pflotsch\nm Pfoschte\nm PHP-Programmierer\nm Pralaaggi\nm Praschaueri\nf Pumpi\nm P\xFCntu\nm P\xFC\xFCru\nm Quadratsp\xFCntu\nn Ranggif\xFCdle\nn R\xE4\xE4f\nf Rosshode\nm Rosspigger\nn Rybise\nf Schabe\nm Schafsecku\nm Schib\xFCtzu\nm Schiissigurgler\nm Schiissiputzer\nm Schissgring\nm Schlarpisiech\nm Schlimschisser\nm Schminggu\nm Schnuddergoof\nm Schnudderi\nm Schn\xE4biz\xE4gg\nm Schn\xE4bich\xE4tscher\nm Schn\xE4bischpienzler\nf Schn\xE4dere\nm Schwafler\nm Schwanzlurch\nm Schwauderi\nm Schw\xFCppu\nm Sch\xF6ggeler\nm Sch\xF6nw\xE4tterschl\xF6fler\nm Secku\nm Seckupeter\nm Siech\nm Solothurner\nm Soucheib\nm Souhung\nf Soumoore\nm Sousiech\nm Spr\xE4nzu\nm St\xFCrmi\nm St\xE4rnesiech\nm St\xFCrmisiech\nm S\xF6iferludi\nm S\xF6iniggu\nm S\xFCchu\nm S\xFCffu\nm S\xFCrmu\nn Theresli\nm Toggu\nm Totsch\nm Traliwatsch\nm Troschtpris\nf Tr\xE4ne\nm Tr\xF6chni\nm Tr\xF6unagu\nm Tschaupisiech\nm Tschirpegigu\nm Tschugger\nm Tschumppuhung\nm Tschumpu\nm Tubu\nn T\xFCpfi\nn Tussi\nm T\xF6fflibueb\nm T\xFCpflischisser\nm Uhung\nm Vagant\nm Voupfoschte\nm Voutotsch\nm Weichschn\xE4beler\nf Wixbire\nf Wurzle\nm W\xE4bst\xFCbeler\nm Zablisiech\nm Ziegu\nm Zirpegigu\nm Zwick\nm Zw\xE4nggring\nf Zw\xE4tschge\nm Z\xE4ief\xF6hner\nm Z\xFCrcher\nf auti Hafehuer\nm genetische M\xFCuhuufe\nm \xC4scheb\xE4cher\nm \xC4tti mit Huet\n');
    var destination = ArrayList_init(collectionSizeOrDefault($receiver, 10));
    var tmp$;
    tmp$ = $receiver.iterator();
    while (tmp$.hasNext()) {
      var item = tmp$.next();
      destination.add_11rb$(Gendered_init(item));
    }
    this.list = destination;
  }
  Subjects.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Subjects',
    interfaces: []
  };
  var Subjects_instance = null;
  function Subjects_getInstance() {
    if (Subjects_instance === null) {
      new Subjects();
    }
    return Subjects_instance;
  }
  function Wowbagger() {
    Wowbagger_instance = this;
  }
  Wowbagger.prototype.adjective_mcmt2t$ = function (gender) {
    return this.choose_0(Adjectives_getInstance().list).with_mcmt2t$(gender);
  };
  Wowbagger.prototype.subject_hfhiae$ = function (gender) {
    if (gender === void 0)
      gender = null;
    return this.choose_0(this.with_0(Subjects_getInstance().list, gender));
  };
  Wowbagger.prototype.name_hfhiae$ = function (gender) {
    if (gender === void 0)
      gender = null;
    return this.choose_0(this.with_0(Names_getInstance().list, gender));
  };
  Wowbagger.prototype.action = function () {
    return this.choose_0(Actions_getInstance().list);
  };
  Wowbagger.prototype.interjection = function () {
    return this.choose_0(Interjections_getInstance().list);
  };
  var isBlank = Kotlin.kotlin.text.isBlank_gw00vp$;
  Wowbagger.prototype.trimLines_7efafi$ = function ($receiver) {
    var $receiver_0 = lines($receiver);
    var destination = ArrayList_init();
    var tmp$;
    tmp$ = $receiver_0.iterator();
    while (tmp$.hasNext()) {
      var element = tmp$.next();
      if (!isBlank(element))
        destination.add_11rb$(element);
    }
    return destination;
  };
  Wowbagger.prototype.choose_0 = function ($receiver) {
    return $receiver.get_za3lpa$(Environment_getInstance().random_za3lpa$($receiver.size));
  };
  Wowbagger.prototype.with_0 = function ($receiver, gender) {
    var destination = ArrayList_init();
    var tmp$;
    tmp$ = $receiver.iterator();
    while (tmp$.hasNext()) {
      var element = tmp$.next();
      if (gender == null || equals(gender, element.gender))
        destination.add_11rb$(element);
    }
    return destination;
  };
  Wowbagger.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Wowbagger',
    interfaces: []
  };
  var Wowbagger_instance = null;
  function Wowbagger_getInstance() {
    if (Wowbagger_instance === null) {
      new Wowbagger();
    }
    return Wowbagger_instance;
  }
  function Gender(name, ordinal) {
    Enum.call(this);
    this.name$ = name;
    this.ordinal$ = ordinal;
  }
  function Gender_initFields() {
    Gender_initFields = function () {
    };
    Gender$M_instance = new Gender('M', 0);
    Gender$F_instance = new Gender('F', 1);
    Gender$N_instance = new Gender('N', 2);
  }
  var Gender$M_instance;
  function Gender$M_getInstance() {
    Gender_initFields();
    return Gender$M_instance;
  }
  var Gender$F_instance;
  function Gender$F_getInstance() {
    Gender_initFields();
    return Gender$F_instance;
  }
  var Gender$N_instance;
  function Gender$N_getInstance() {
    Gender_initFields();
    return Gender$N_instance;
  }
  Gender.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Gender',
    interfaces: [Enum]
  };
  function Gender$values() {
    return [Gender$M_getInstance(), Gender$F_getInstance(), Gender$N_getInstance()];
  }
  Gender.values = Gender$values;
  function Gender$valueOf(name) {
    switch (name) {
      case 'M':
        return Gender$M_getInstance();
      case 'F':
        return Gender$F_getInstance();
      case 'N':
        return Gender$N_getInstance();
      default:throwISE('No enum constant guru.nidi.wowbagger.Gender.' + name);
    }
  }
  Gender.valueOf_61zpoe$ = Gender$valueOf;
  function Gendered(name, gender) {
    this.name = name;
    this.gender = gender;
  }
  Gendered.prototype.toString = function () {
    return this.name;
  };
  Gendered.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Gendered',
    interfaces: []
  };
  function Gendered_init(s, $this) {
    $this = $this || Object.create(Gendered.prototype);
    Gendered.call($this, s.substring(2), Gender$valueOf(s.substring(0, 1).toUpperCase()));
    return $this;
  }
  Gendered.prototype.component1 = function () {
    return this.name;
  };
  Gendered.prototype.component2 = function () {
    return this.gender;
  };
  Gendered.prototype.copy_jxp3fh$ = function (name, gender) {
    return new Gendered(name === void 0 ? this.name : name, gender === void 0 ? this.gender : gender);
  };
  Gendered.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.name) | 0;
    result = result * 31 + Kotlin.hashCode(this.gender) | 0;
    return result;
  };
  Gendered.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.name, other.name) && Kotlin.equals(this.gender, other.gender)))));
  };
  function Adjective(name) {
    this.name_0 = name;
  }
  Adjective.prototype.with_mcmt2t$ = function (gender) {
    var tmp$, tmp$_0, tmp$_1, tmp$_2, tmp$_3;
    if (contains(this.name_0, '(')) {
      tmp$_1 = this.name_0;
      tmp$ = Regex('\\((.*?)/(.*?)/(.*?)\\)');
      if (equals(gender, Gender$M_getInstance()))
        tmp$_0 = '$1';
      else if (equals(gender, Gender$N_getInstance()))
        tmp$_0 = '$2';
      else if (equals(gender, Gender$F_getInstance()))
        tmp$_0 = '$3';
      else
        tmp$_0 = Kotlin.noWhenBranchMatched();
      var replacement = tmp$_0;
      return tmp$.replace_x2uqeu$(tmp$_1, replacement);
    }
     else {
      tmp$_3 = this.name_0;
      if (equals(gender, Gender$M_getInstance()))
        tmp$_2 = 'e';
      else if (equals(gender, Gender$N_getInstance()))
        tmp$_2 = 's';
      else if (equals(gender, Gender$F_getInstance()))
        tmp$_2 = 'i';
      else
        tmp$_2 = Kotlin.noWhenBranchMatched();
      return tmp$_3 + tmp$_2;
    }
  };
  Adjective.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Adjective',
    interfaces: []
  };
  Adjective.prototype.component1_0 = function () {
    return this.name_0;
  };
  Adjective.prototype.copy_61zpoe$ = function (name) {
    return new Adjective(name === void 0 ? this.name_0 : name);
  };
  Adjective.prototype.toString = function () {
    return 'Adjective(name=' + Kotlin.toString(this.name_0) + ')';
  };
  Adjective.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.name_0) | 0;
    return result;
  };
  Adjective.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && Kotlin.equals(this.name_0, other.name_0))));
  };
  function Environment() {
    Environment_instance = this;
  }
  Environment.prototype.random_za3lpa$ = function (range) {
    return numberToInt(Math.random() * range);
  };
  Environment.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Environment',
    interfaces: []
  };
  var Environment_instance = null;
  function Environment_getInstance() {
    if (Environment_instance === null) {
      new Environment();
    }
    return Environment_instance;
  }
  function insult() {
    var int = capitalize(Wowbagger_getInstance().interjection());
    var name = Wowbagger_getInstance().name_hfhiae$();
    var subject = Wowbagger_getInstance().subject_hfhiae$(name.gender);
    var adj1 = Wowbagger_getInstance().adjective_mcmt2t$(subject.gender);
    var adj2 = Wowbagger_getInstance().adjective_mcmt2t$(subject.gender);
    var action = Wowbagger_getInstance().action();
    return int + ' ' + name + ', du ' + adj1 + ' ' + adj2 + ' ' + subject + ', ' + action;
  }
  var package$guru = _.guru || (_.guru = {});
  var package$nidi = package$guru.nidi || (package$guru.nidi = {});
  var package$wowbagger = package$nidi.wowbagger || (package$nidi.wowbagger = {});
  Object.defineProperty(package$wowbagger, 'Actions', {
    get: Actions_getInstance
  });
  Object.defineProperty(package$wowbagger, 'Adjectives', {
    get: Adjectives_getInstance
  });
  Object.defineProperty(package$wowbagger, 'Interjections', {
    get: Interjections_getInstance
  });
  Object.defineProperty(package$wowbagger, 'Names', {
    get: Names_getInstance
  });
  Object.defineProperty(package$wowbagger, 'Subjects', {
    get: Subjects_getInstance
  });
  Object.defineProperty(package$wowbagger, 'Wowbagger', {
    get: Wowbagger_getInstance
  });
  Object.defineProperty(Gender, 'M', {
    get: Gender$M_getInstance
  });
  Object.defineProperty(Gender, 'F', {
    get: Gender$F_getInstance
  });
  Object.defineProperty(Gender, 'N', {
    get: Gender$N_getInstance
  });
  package$wowbagger.Gender = Gender;
  package$wowbagger.Gendered_init_61zpoe$ = Gendered_init;
  package$wowbagger.Gendered = Gendered;
  package$wowbagger.Adjective = Adjective;
  Object.defineProperty(package$wowbagger, 'Environment', {
    get: Environment_getInstance
  });
  package$wowbagger.insult = insult;
  Kotlin.defineModule('swiss-wowbagger-js', _);
  return _;
}(typeof this['swiss-wowbagger-js'] === 'undefined' ? {} : this['swiss-wowbagger-js'], kotlin);
