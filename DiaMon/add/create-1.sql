BEGIN TRANSACTION;
CREATE TABLE help_bu_items (
	id INTEGER PRIMARY KEY, 
	kind_of_item NUMERIC, 
	description TEXT, 
	measure_bu TEXT, 
	measure_wt TEXT);
COMMIT;

CREATE TABLE insulin_items (
	id INTEGER PRIMARY KEY, 
	description 	TEXT, 
	time_start 	REAL, 
	time_end   	REAL, 
	time_max_start 	REAL, 
	time_max_end 	REAL,
	color  		TEXT 
);
COMMIT;

CREATE TABLE profiles (
	id INTEGER PRIMARY KEY, 
	code	 	TEXT, 
	name	 	TEXT, 
	sex 		INT, 
	age	   	INT, 
	height 		INT, 
	weigth	 	REAL,
	picture		TEXT, 
	color  		TEXT 
);
COMMIT;


INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(1,"Хлеб и хлебобулочные изделия","1 ХЕ =","...")                   ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Белый хлеб","1 кусок","20 г")                                   ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Ржаной хлеб","1 кусок","25 г")                                  ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Бородинский хлеб","1 кусок","25 г")                             ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Булочка","1/2 маленькой","20 г")                                ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Крекеры (сухое печенье)","5 штук","15 г")                       ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Сухари (не сладкие)","2 штуки","15 г")                          ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Панировочные сухари","1 ст. ложка","15 г")                      ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Хрустящие хлебцы","2 штуки","25 г")                             ;

INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(1,"Макаронные изделия","1 ХЕ =","...")                             ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Вермишель, лапша, рожки, макароныА","1—2 ст. ложки  зависимости от формы изделия","15 г");
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"— сырые изделия; либо 2—4 ст. ложки отвареных макаронных изделий в зависимости от формы изделия",".",".");
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(1,"Крупы, злаки, мука","1 ХЕ =","...")                             ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Гречневая","1 ст. ложка","15 г")                                ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Кукуруза","1/2 початка","100 г")                                ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Кукурузные хлопья","1 ст. ложка","15 г")                        ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Манная","1 ст. ложка","15 г")                                   ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Мука (любая)","1 ст. ложка","15 г")                             ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Овсяная","1 ст. ложка","15 г")                                  ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Овсяные хлопья","1 ст. ложка","15 г")                           ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Перловая","1 ст. ложка","15 г")                                 ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Пшено","1 ст. ложка","15 г")                                    ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Рис","1 ст. ложка","15 г")                                      ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"— имеется в виду 1 ст. ложка сырой крупы; в варёном виде (каша) 1 ХЕ содержится в 2 ст. ложках продукта. Итак, 2 ст. ложки любой каши = 1 ХЕ!",".",".");
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(1,"Картофель","1 ХЕ =","...")                                      ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Картофель","1 клубень величиной с крупное куриное яйцо","65 г") ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Картофельное пюре","2 ст. ложки (с горкой)","75 г")             ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Жареный картофель","2 ст. ложки с горкой","35 г")               ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Сухой картофель","","25 г")                                     ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(1,"Фрукты и ягоды","1 ХЕ =","...")                                 ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Абрикосы","2—3 штуки","110 г")                                  ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Айва","1 штука, крупная","140 г")                               ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Ананас","1 кусок (поперечный срез)","140 г")                    ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Арбуз","1 кусок","270 г")                                       ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Апельсин","1 штука, средний","150 г")                           ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Банан","1/2 штуки, средний","70 г")                             ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Брусника","7 ст. ложек","140 г")                                ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Виноград","12 штук, небольших","70 г")                          ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Вишня","15 штук","90 г")                                        ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Гранат","1 штука, большой","170 г")                             ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Грейпфрут","1/2 штуки, крупный","170 г")                        ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Груша","1 штука, средняя","90 г")                               ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Дыня","1 кусок","100 г")                                        ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Ежевика","8 ст. ложек","140 г")                                 ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Инжир","1 штука","80 г")                                        ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Киви","1 штука, крупная","110 г")                               ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Клубника","10 штук, средних","160 г")                           ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Крыжовник","6 ст. ложек","120 г")                               ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Малина","8 ст. ложек","150 г")                                  ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Манго","1 штука, небольшое","110 г")                            ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Мандарины","2-3 штуки, средних","150 г")                        ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Персик","1 штука, крупный","120 г")                             ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Сливы","4 штуки, средние","90 г")                               ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Смородина","7 ст. ложек","140 г")                               ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Хурма","1 штука, средняя","70 г")                               ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Черника, чёрная смородина","7 ст. ложек","140 г")               ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Яблоко","1 штука, среднее","90 г")                              ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(1,"— с косточками и кожурой. Свежеприготовленные фруктовые соки подсчитываются как соответствующие сорта фруктов. Около 100 мл сока (без добавления сахара, 100% натуральный сок) содержит примерно 1 ХЕ. 6 — 8 ложек ягод (малина, смородина и так далее), в среднем, соответствует 1 стаканчику (1 чайной чашке) этих ягод. Около 20 г сухофруктов (курага, чернослив, изюм, инжир) содержит примерно 1 ХЕ.",".",".");
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(1,"Молоко и жидкие молочные продукты","1 ХЕ =","...")              ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Молоко","1 стакан","200 мл")                                    ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Кефир","1 стакан","200 мл")                                     ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Сливки","1 стакан","200 мл")                                    ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(1,"Другие продукты","1 ХЕ =","...")                                ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Квас","1 стакан","200 мл")                                      ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Кока-кола","1/2 стакана","100 мл")                              ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"Мороженое","1 порция (без стаканчика)","65 г")                  ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Сахар-песок","1 ст. ложка без горки","10 г")                    ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Сахар рафинад","1 кусок","10 г")                                ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"Зелёный горошек","7 ст. ложек","100 г")                         ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(1,"Примечания:","Пельмени, блины, оладьи, пирожки, сырники, вареники, котлеты также содержат углеводы, но количество ХЕ зависит от размера и способа приготовления.Некоторые овощи (морковь, свёкла, сельдерей, лук) учитываются по ХЕ при употреблении более 200 г.При составлении диеты больному сахарным диабетом не стоит забывать о продуктах, не содержащих ХЕ.","");
