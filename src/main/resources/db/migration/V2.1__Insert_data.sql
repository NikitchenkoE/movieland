INSERT INTO users (userPersonalDetails, email, password, role)
VALUES ('Рональд Рейнольдс', 'ronald.reynolds66@example.com',
        '$2a$08$F5rK18KV86WFOEOtUBXb3Odl53xlm2ww9FnJXHmEloIZyaCAaEo.W', 'ROLE_USER'),
       ('Дарлин Эдвардс', 'darlene.edwards15@example.com',
        '$2a$08$rQLJjrXs7m9JMYXOOJ2EvuJjmI7QXF1EEkGGSvT4OOSVdZGIXnLSC', 'ROLE_USER'),
       ('Габриэль Джексон', 'gabriel.jackson91@example.com',
        '$2a$08$6Zh8VHpP7JbDLZmrp4jHdOoNMzY6JZnRh8H7YUTWR6RgFvX4OAGYu', 'ROLE_USER'),
       ('Дэрил Брайант', 'daryl.bryant94@example.com', '$2a$08$7LKpqvWBr1tPsTesyCLdKOFSkxU4et.QwGp0z26rYw.56o938s1x6',
        'ROLE_USER'),
       ('Нил Паркер', 'neil.parker43@example.com', '$2a$08$yv2KThOepP9RR1uwvRL7Vuv0MXkZHtwcj31kEUYDUqjMj2OWkB.Ga',
        'ROLE_USER'),
       ('Трэвис Райт', 'travis.wright36@example.com', '$2a$08$CK3CbUWC3PS4NAhlThw0j.JtQpet7Eiwi7.peRI9OLVh26NvwB9wa',
        'ROLE_USER'),
       ('Амелия Кэннеди', 'amelia.kennedy58@example.com',
        '$2a$08$ap1NA5xjmqND2SCp7JlE.O1RBzgJlKJlk2tNgq./HOtmjZO18g7Ny', 'ROLE_USER'),
       ('Айда Дэвис', 'ida.davis80@example.com', '$2a$08$z0xInEFP/Ighzxr3pGGyRevDmFzacJTyItahfYci7xswnC4ry7KYK',
        'ROLE_USER'),
       ('Джесси Паттерсон', 'jessie.patterson68@example.com',
        '$2a$08$Ofysd/l25njZXur3uV6/6OkUQb1S3AXefMaWITC9nNoqx9wCOytRa', 'ROLE_USER'),
       ('Деннис Крейг', 'dennis.craig82@example.com', '$2a$08$Yo9p/GyEeW2gsUQObZsJrOAI6P5VEaFBUqp8TqXLxu4zoAqfs3P5O',
        'ROLE_USER');


INSERT INTO movies (nameRussian, nameNative, yearOfRelease, description, picturePath, rating,
                    price)
VALUES ('Побег из Шоушенка',
        'The Shawshank Redemption',
        1994,
        'Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg',
        8.9,
        123.45),
       ('Зеленая миля',
        'The Green Mile',
        1999,
        'Обвиненный в страшном преступлении, Джон Коффи оказывается в блоке смертников тюрьмы «Холодная гора». Вновь прибывший обладал поразительным ростом и был пугающе спокоен, что, впрочем, никак не влияло на отношение к нему начальника блока Пола Эджкомба, привыкшего исполнять приговор.',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1._SY209_CR0,0,140,209_.jpg',
        8.9,
        134.67),
       ('Форрест Гамп',
        'Forrest Gump',
        1994,
        'От лица главного героя Форреста Гампа, слабоумного безобидного человека с благородным и открытым сердцем, рассказывается история его необыкновенной жизни.Фантастическим образом превращается он в известного футболиста, героя войны, преуспевающего бизнесмена. Он становится миллиардером, но остается таким же бесхитростным, глупым и добрым. Форреста ждет постоянный успех во всем, а он любит девочку, с которой дружил в детстве, но взаимность приходит слишком поздно.',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR2,0,140,209_.jpg',
        8.6,
        200.60),
       ('Список Шиндлера',
        'Schindler''s List',
        1993,
        'Фильм рассказывает реальную историю загадочного Оскара Шиндлера, члена нацистской партии, преуспевающего фабриканта, спасшего во время Второй мировой войны почти 1200 евреев.',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg',
        8.7,
        150.50),
       ('1+1',
        'Intouchables',
        2011,
        'Пострадав в результате несчастного случая, богатый аристократ Филипп нанимает в помощники человека, который менее всего подходит для этой работы, — молодого жителя предместья Дрисса, только что освободившегося из тюрьмы. Несмотря на то, что Филипп прикован к инвалидному креслу, Дриссу удается привнести в размеренную жизнь аристократа дух приключений',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxNDA3MDQwNl5BMl5BanBnXkFtZTcwNTU4Mzc1Nw@@._V1._SY209_CR0,0,140,209_.jpg',
        8.3,
        120.00),
       ('Начало',
        'Inception',
        2010,
        'Кобб — талантливый вор, лучший из лучших в опасном искусстве извлечения: он крадет ценные секреты из глубин подсознания во время сна, когда человеческий разум наиболее уязвим. Редкие способности Кобба сделали его ценным игроком в привычном к предательству мире промышленного шпионажа, но они же превратили его в извечного беглеца и лишили всего, что он когда-либо любил',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1._SY209_CR0,0,140,209_.jpg',
        8.6,
        130.00),
       ('Жизнь прекрасна',
        'La vita è bella',
        1997,
        'Во время II Мировой войны в Италии в концлагерь были отправлены евреи, отец и его маленький сын. Жена, итальянка, добровольно последовала вслед за ними. В лагере отец сказал сыну, что все происходящее вокруг является очень большой игрой за приз в настоящий танк, который достанется тому мальчику, который сможет не попасться на глаза надзирателям. Он сделал все, чтобы сын поверил в игру и остался жив, прячась в бараке.',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BYmJmM2Q4NmMtYThmNC00ZjRlLWEyZmItZTIwOTBlZDQ3NTQ1XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR0,0,140,209_.jpg',
        8.2,
        145.99),
       ('Бойцовский клуб',
        'Fight Club',
        1999,
        'Терзаемый хронической бессонницей и отчаянно пытающийся вырваться из мучительно скучной жизни, клерк встречает некоего Тайлера Дардена, харизматического торговца мылом с извращенной философией. Тайлер уверен, что самосовершенствование — удел слабых, а саморазрушение — единственное, ради чего стоит жить.',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BZGY5Y2RjMmItNDg5Yy00NjUwLThjMTEtNDc2OGUzNTBiYmM1XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SY209_CR0,0,140,209_.jpg',
        8.4,
        119.99),
       ('Звёздные войны: Эпизод 4 – Новая надежда',
        'Star Wars',
        1977,
        'Татуин. Планета-пустыня. Уже постаревший рыцарь Джедай Оби Ван Кеноби спасает молодого Люка Скайуокера, когда тот пытается отыскать пропавшего дроида. С этого момента Люк осознает свое истинное назначение: он один из рыцарей Джедай. В то время как гражданская война охватила галактику, а войска повстанцев ведут бои против сил злого Императора, к Люку и Оби Вану присоединяется отчаянный пилот-наемник Хан Соло, и в сопровождении двух дроидов, R2D2 и C-3PO, этот необычный отряд отправляется на поиски предводителя повстанцев — принцессы Леи. Героям предстоит отчаянная схватка с устрашающим Дартом Вейдером — правой рукой Императора и его секретным оружием — «Звездой Смерти».',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BYTUwNTdiMzMtNThmNS00ODUzLThlMDMtMTM5Y2JkNWJjOGQ2XkEyXkFqcGdeQXVyNzQ1ODk3MTQ@._V1._SX140_CR0,0,140,209_.jpg',
        8.1,
        198.98),

       ('Звёздные войны: Эпизод 5 – Империя наносит ответный удар',
        'Star Wars: Episode V - The Empire Strikes Back',
        1980,
        'Борьба за Галактику обостряется в пятом эпизоде космической саги. Войска Императора начинают массированную атаку на повстанцев и их союзников. Хан Соло и принцесса Лейя укрываются в Заоблачном Городе, в котором их и захватывает Дарт Вейдер, в то время как Люк Скайуокер находится на таинственной планете джунглей Дагоба. Там Мастер — джедай Йода обучает молодого рыцаря навыкам обретения Силы. Люк даже не предполагает, как скоро ему придется воспользоваться знаниями старого Мастера: впереди битва с превосходящими силами Императора и смертельный поединок с Дартом Вейдером.',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BYmViY2M2MTYtY2MzOS00YjQ1LWIzYmEtOTBiNjhlMGM0NjZjXkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1._SX140_CR0,0,140,209_.jpg',
        8.2,
        198.98),

       ('Унесённые призраками',
        'Sen to Chihiro no kamikakushi',
        2001,
        'Маленькая Тихиро вместе с мамой и папой переезжают в новый дом. Заблудившись по дороге, они оказываются в странном пустынном городе, где их ждет великолепный пир. Родители с жадностью набрасываются на еду и к ужасу девочки превращаются в свиней, став пленниками злой колдуньи Юбабы, властительницы таинственного мира древних богов и могущественных духов. ',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BOGJjNzZmMmUtMjljNC00ZjU5LWJiODQtZmEzZTU0MjBlNzgxL2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1._SY209_CR0,0,140,209_.jpg',
        8.6,
        145.90),
       ('Титаник',
        'Titanic',
        1997,
        'Молодые влюбленные Джек и Роза находят друг друга в первом и последнем плавании «непотопляемого» Титаника. Они не могли знать, что шикарный лайнер столкнется с айсбергом в холодных водах Северной Атлантики, и их страстная любовь превратится в схватку со смертью…',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1._SY209_CR0,0,140,209_.jpg',
        7.9,
        150.00),
       ('Пролетая над гнездом кукушки',
        'One Flew Over the Cuckoo''s Nest',
        1975,
        'Сымитировав помешательство в надежде избежать тюремного заключения, Рэндл Патрик МакМерфи попадает в психиатрическую клинику, где почти безраздельным хозяином является жестокосердная сестра Милдред Рэтчед. МакМерфи поражается тому, что прочие пациенты смирились с существующим положением вещей, а некоторые — даже сознательно пришли в лечебницу, прячась от пугающего внешнего мира. И решается на бунт. В одиночку.',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BZjA0OWVhOTAtYWQxNi00YzNhLWI4ZjYtNjFjZTEyYjJlNDVlL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR0,0,140,209_.jpg',
        8.7,
        180.00),
       ('Ходячий замок',
        'Hauru no ugoku shiro',
        2004,
        'Злая ведьма заточила 18-летнюю Софи в тело старухи. В поисках того, кто поможет ей вернуться к своему облику, Софи знакомится с могущественным волшебником Хаулом и его демоном Кальцифером. Кальцифер должен служить Хаулу по договору, условия которого он не может разглашать. Девушка и демон решают помочь друг другу избавиться от злых чар…',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BZTRhY2QwM2UtNWRlNy00ZWQwLTg3MjktZThmNjQ3NTdjN2IxXkEyXkFqcGdeQXVyMzg2MzE2OTE@._V1._SY209_CR5,0,140,209_.jpg',
        8.2,
        130.50),
       ('Гладиатор',
        'Gladiator',
        2000,
        'В великой Римской империи не было военачальника, равного генералу Максимусу. Непобедимые легионы, которыми командовал этот благородный воин, боготворили его и могли последовать за ним даже в ад. Но случилось так, что отважный Максимус, готовый сразиться с любым противником в честном бою, оказался бессилен против вероломных придворных интриг. Генерала предали и приговорили к смерти. Чудом избежав гибели, Максимус становится гладиатором.',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BMDliMmNhNDEtODUyOS00MjNlLTgxODEtN2U3NzIxMGVkZTA1L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SY209_CR0,0,140,209_.jpg',
        8.6,
        175.00),
       ('Большой куш',
        'Snatch.',
        2000,
        'Четырехпалый Френки должен был переправить краденый алмаз из Англии в США своему боссу Эви. Но вместо этого герой попадает в эпицентр больших неприятностей. Сделав ставку на подпольном боксерском поединке, Френки попадает в круговорот весьма нежелательных событий. Вокруг героя и его груза разворачивается сложная интрига с участием множества колоритных персонажей лондонского дна — русского гангстера, троих незадачливых грабителей, хитрого боксера и угрюмого громилы грозного мафиози. Каждый норовит в одиночку сорвать Большой Куш.',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BMTA2NDYxOGYtYjU1Mi00Y2QzLTgxMTQtMWI1MGI0ZGQ5MmU4XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1._SY209_CR1,0,140,209_.jpg',
        8.5,
        160.00),
       ('Темный рыцарь',
        'The Dark Knight',
        2008,
        'Бэтмен поднимает ставки в войне с криминалом. С помощью лейтенанта Джима Гордона и прокурора Харви Дента он намерен очистить улицы от преступности, отравляющей город. Сотрудничество оказывается эффективным, но скоро они обнаружат себя посреди хаоса, развязанного восходящим криминальным гением, известным испуганным горожанам под именем Джокер.',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1._SY209_CR0,0,140,209_.jpg',
        8.5,
        199.99),
       ('Как приручить дракона',
        'How to Train Your Dragon',
        2010,
        'Вы узнаете историю подростка Иккинга, которому не слишком близки традиции его героического племени, много лет ведущего войну с драконами. Мир Иккинга переворачивается с ног на голову, когда он неожиданно встречает дракона Беззубика, который поможет ему и другим викингам увидеть привычный мир с совершенно другой стороны…',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BMjA5NDQyMjc2NF5BMl5BanBnXkFtZTcwMjg5ODcyMw@@._V1._SY209_CR0,0,140,209_.jpg',
        8.2,
        182.00),
       ('Молчание ягнят',
        'The Silence of the Lambs',
        1990,
        'Психопат похищает и убивает молодых женщин по всему Среднему Западу Америки. ФБР, уверенное в том, что все преступления совершены одним и тем же человеком, поручает агенту Клариссе Старлинг встретиться с заключенным-маньяком, который мог бы объяснить следствию психологические мотивы серийного убийцы и тем самым вывести на его след.',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BNjNhZTk0ZmEtNjJhMi00YzFlLWE1MmEtYzM1M2ZmMGMwMTU4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SY209_CR1,0,140,209_.jpg',
        8.3,
        150.50),
       ('Гран Торино',
        'Gran Torino',
        2008,
        'Вышедший на пенсию автомеханик Уолт Ковальски проводит дни, починяя что-то по дому, попивая пиво и раз в месяц заходя к парикмахеру. И хотя последним желанием его недавно почившей жены было совершение им исповеди, Уолту — ожесточившемуся ветерану Корейской войны, всегда держащему свою винтовку наготове, — признаваться в общем-то не в чем. Да и нет того, кому он доверял бы в той полной мере, в какой доверяет своей собаке Дейзи.',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTk2OTU1Nl5BMl5BanBnXkFtZTcwMDc3NjAwMg@@._V1._SY209_CR0,0,140,209_.jpg',
        8.1,
        100.50),
       ('Хороший, плохой, злой',
        'Il buono, il brutto, il cattivo',
        1979,
        'В разгар гражданской войны таинственный стрелок скитается по просторам Дикого Запада. У него нет ни дома, ни друзей, ни компаньонов, пока он не встречает двоих незнакомцев, таких же безжалостных и циничных. По воле судьбы трое мужчин вынуждены объединить свои усилия в поисках украденного золота. Но совместная работа — не самое подходящее занятие для таких отъявленных бандитов, как они. Компаньоны вскоре понимают, что в их дерзком и опасном путешествии по разоренной войной стране самое важное — никому не доверять и держать пистолет наготове, если хочешь остаться в живых.',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BOTQ5NDI3MTI4MF5BMl5BanBnXkFtZTgwNDQ4ODE5MDE@._V1._SX140_CR0,0,140,209_.jpg',
        8.5,
        130.00),
       ('Укрощение строптивого',
        'Il bisbetico domato',
        1980,
        'Категорически не приемлющий женского общества грубоватый фермер вполне счастлив и доволен своей холостяцкой жизнью. Но неожиданно появившаяся в его жизни героиня пытается изменить его взгляды на жизнь и очаровать его. Что же из этого получится…',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg',
        7.7,
        120.00),
       ('Блеф',
        'Bluff storia di truffe e di imbroglioni',
        1976,
        'Белль Дюк имеет старые счеты с Филиппом Бэнгом, который отбывает свой срок за решёткой. Для того чтобы поквитаться с Филиппом, Белль Дюк вступает в сговор с другим аферистом по имени Феликс, чтобы тот организовал побег Филиппа Бенга из тюрьмы. Побег удаётся, но парочка заодно обманывает и Белль Дюк, исчезнув прямо из-под её носа. Выясняется, что и Филипп Бэнг, в свою очередь, не прочь отомстить Белль Дюк. Для этого он задумывает грандиозную мистификацию, сродни покерному блефу…',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg',
        7.6,
        100.00),
       ('Джанго освобожденный',
        'Django Unchained',
        2012,
        'Эксцентричный охотник за головами, также известный как «Дантист», промышляет отстрелом самых опасных преступников. Работенка пыльная, и без надежного помощника ему не обойтись. Но как найти такого и желательно не очень дорогого? Беглый раб по имени Джанго — прекрасная кандидатура. Правда, у нового помощника свои мотивы — кое с чем надо разобраться…',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BMjIyNTQ5NjQ1OV5BMl5BanBnXkFtZTcwODg1MDU4OA@@._V1._SY209_CR0,0,140,209_.jpg',
        8.5,
        170.00),
       ('Танцующий с волками',
        'Dances with Wolves',
        1990,
        'Действие фильма происходит в США во времена Гражданской войны. Лейтенант американской армии Джон Данбар после ранения в бою просит перевести его на новое место службы ближе к западной границе США. Место его службы отдалённый маленький форт. Непосредственный его командир покончил жизнь самоубийством, а попутчик Данбара погиб в стычке с индейцами после того, как довез героя до места назначения. Людей, знающих, что Данбар остался один в форте и должен выжить в условиях суровой природы, и в соседстве с кажущимися негостеприимными коренными обитателями Северной Америки, просто не осталось. Казалось, он покинут всеми. Постепенно лейтенант осваивается, он ведет записи в дневнике…',
        'https://images-na.ssl-images-amazon.com/images/M/MV5BMTY3OTI5NDczN15BMl5BanBnXkFtZTcwNDA0NDY3Mw@@._V1._SX140_CR0,0,140,209_.jpg',
        8.0,
        120.55);

INSERT INTO genres (genre)
VALUES ('драма'),
       ('криминал'),
       ('фэнтези'),
       ('детектив'),
       ('мелодрама'),
       ('биография'),
       ('комедия'),
       ('фантастика'),
       ('боевик'),
       ('триллер'),
       ('приключения'),
       ('аниме'),
       ('мультфильм'),
       ('семейный'),
       ('вестерн');

INSERT INTO countries(countryname)
VALUES ('США'),
       ('Франция'),
       ('Великобритания'),
       ('Италия'),
       ('Германия'),
       ('Япония'),
       ('Испания');


INSERT INTO reviews (reviewtext, userid, movieid)
VALUES ('Гениальное кино! Смотришь и думаешь «Так не бывает!», но позже понимаешь, что только так и должно быть. Начинаешь заново осмысливать значение фразы, которую постоянно используешь в своей жизни, «Надежда умирает последней». Ведь если ты не надеешься, то все в твоей жизни гаснет, не остается смысла. Фильм наполнен бесконечным числом правильных афоризмов. Я уверена, что буду пересматривать его сотни раз.',
        2, 1),
       ('Кино это является, безусловно, «со знаком качества». Что же до первого места в рейтинге, то, думаю, здесь имело место быть выставление «десяточек» от большинства зрителей вкупе с раздутыми восторженными откликами кинокритиков. Фильм атмосферный. Он драматичный. И, конечно, заслуживает того, чтобы находиться довольно высоко в мировом кинематографе.',
        3, 1),
       ('Перестал удивляться тому, что этот фильм занимает сплошь первые места во всевозможных кино рейтингах. Особенно я люблю когда при экранизации литературного произведение из него в силу специфики кинематографа исчезает ирония и появляется некий сверхреализм, обязанный удерживать зрителя у экрана каждую отдельно взятую секунду.',
        1, 2),
       ('Много еще можно сказать об этом шедевре. И то, что он учит верить, и то, чтобы никогда не сдаваться… Но самый главный девиз я увидел вот в этой фразе: «Занимайся жизнью, или занимайся смертью».',
        5, 3),
       ('Очень хороший фильм, необычный сюжет, я бы даже сказала непредсказуемый. Такие фильмы уже стали редкостью.',
        6, 4),
       ('У меня не найдётся слов, чтобы описать этот фильм. Не хочется быть банальной и говорить какой он отличный, непредсказуемый и т. д., но от этого никуда не деться к сожалению — ведь он ШЕДЕВРАЛЬНЫЙ!',
        9, 5),
       ('Скажу сразу — фильм выглядел многообещающе, даже если не брать в расчет что он находился в топе-250 лучших фильмов. Известные голливудские актеры на главных ролях. Но нет в этом фильме должной атмосферы. Нет такого чувства что вот сейчас случится что-то страшное. Что герои попали в ситуацию из которой не смогут выбраться. В общем, не понравилось.',
        7, 5),
       ('«Все должно быть супер! Супер! Су-пер!» И это именно супер, ну слов других не подберешь.',
        3, 7),
       ('Фильм очень красивый. Не во всем, конечно, но яркие персонажи и костюмы — это уже кое-что.',
        10, 8),
       ('Этот фильм из разряда тех, что могут обеспечить хороший отдых и приподнятое настроение за счёт своей лёгкости, совсем непошлого юмора, умеренной дозы напряжения, динамики нужных скоростей.',
        3, 18),
       ('Назначается Киношедевром среди развлекательных фильмов.',
        5, 18),
       ('Данный кинофильм — нестареющая классика мирового кинематографа, который можно пересматривать до бесконечности и, что удивительно, он не может надоесть.',
        7, 15),
       ('Рекомендую смотреть всем и не обращать внимания на надоевшее уже спасение целого мира одним человеком.',
        4, 17),
       ('Удивлен. Никто не отозвался плохо? Неужели было создано произведение искусства, которое нравится всем, и которое совершенно? Нет. Может, я один такой? Фильм не вызывает во мне никаких эмоций. Неплохая сказочка. Замечательная наивная атмосфера. Местами есть забавные шутки. И, как мне показалось, этот фильм — своего рода стёб над другими боевиками. При этом превосходящий многие боевики.',
        4, 16),
       ('Необыкновенно позитивный фильм. Его можно пересматривать много раз для поднятия настроения, находя много смешных, незаметных на первый взгляд моментов.',
        10, 11),
       ('Легендарный. Культовый. Бессмертный. Три слова. Всего лишь три. А сколько же они выражают неподдельных эмоций и радостных впечатлений по отношению к очередному любимому и уважаемому фильму из минувшего в лету детства? Много. Слишком много. И описать эти сердечные и гарцующие в здравом рассудке чувства обыкновенными строчными предложениями иногда не представляется возможным.',
        7, 9),
       ('Приятного просмотра для всех, кто не видел ещё этого шедевра больше впечатлений для тех, кто пересматривает в надцатый раз. =)',
        6, 16),
       ('Это один из любимых моих фильмов с самого детства. Я видела его столько раз, что знаю практически наизусть. И могу сказать с уверенностью, что посмотрю еще не один раз.',
        5, 16),
       ('Фильм, безусловно, посмотрела уже большая часть населения, которая хоть каким-то образом имеет отношение к кинематографу. Я считаю, что фильм можно пересмотреть еще не один раз.',
        3, 19),
       ('Фильм продуман до мельчайших деталей. Идеальный фильм для улучшения настроения, единственный в своем роде. Обязателен к просмотру!',
        8, 18),
       ('Фильм потрясающий, в нем хватает абсолютно всего: и драк, и музыки, и юмора, и любви.',
        5, 23),
       ('У фильма есть свои мелкие недостатки  и неточности, но многочисленные достоинства в несколько раз перевешивают. Много вдохновляющего креатива!',
        1, 20),
       ('Хоть и не по возрасту мне заводить скрипучую пластинку с мелодией «Раньше и деревья были выше, и трава зеленее…», а хочется. Выражать свою любовь к настолько близкому произведению крайне сложно.',
        2, 19),
       ('Вердикт: прекрасная, нестареющая классика, которая рекомендована мною для всех.',
        8, 23),
       ('Для воскресного вечернего просмотра подходит по всем критериям.',
        4, 21),
       ('Хороший и по-настоящему интересный фильм, с хорошим сюжетом и неплохим музыкальным сопровождением. Всем советую к просмотру.',
        5, 22),
       ('Полагаю, этот фильм должен быть в коллекции каждого уважающего себя киномана.',
        6, 24),
       ('Нетленный шедевр мирового кинематографа, который можно пересматривать десятки раз и получать все такой — же, извините за выражение, кайф от просмотра. Минусы у фильма, конечно, есть, но черт возьми. Их просто не хочется замечать! Ты настолько поглощен просмотром фильма, что просто не хочется придираться к разным мелочам.',
        7, 25),
       ('Фильм только выигрывает от частого просмотра и всегда поднимает мне настроение (наряду с драмой, тут еще и тонкий юмор)',
        8, 24),
       ('Конечно, бесспорно культовый фильм, не реалистичный, наивный, где то глупый, но такой же увлекательный и удивительный, как и много лет назад',
        9, 22),
       ('В итоге мы имеем отличный представитель своего жанра, который прошёл проверку временем и до сих пор отлично смотрится, несмотря на классический сюжет',
        9, 12),
       ('Скажу только одно — как я жалею, что не посмотрела его раньше!',
        10, 13);

INSERT INTO moviecountryrelation (movieid, countryid)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 2),
       (6, 1),
       (6, 3),
       (7, 4),
       (8, 1),
       (8, 5),
       (9, 1),
       (10, 1),
       (11, 6),
       (12, 1),
       (13, 1),
       (14, 6),
       (15, 1),
       (15, 3),
       (16, 1),
       (16, 3),
       (17, 1),
       (17, 3),
       (18, 1),
       (19, 1),
       (20, 1),
       (20, 5),
       (21, 1),
       (21, 4),
       (21, 5),
       (21, 7),
       (22, 4),
       (23, 4),
       (24, 1),
       (25, 1),
       (25, 3);

INSERT INTO moviegenrerelation (movieid, genreid)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (2, 2),
       (2, 3),
       (2, 4),
       (3, 1),
       (3, 5),
       (4, 1),
       (4, 6),
       (5, 1),
       (5, 6),
       (5, 7),
       (6, 8),
       (6, 9),
       (6, 10),
       (6, 1),
       (6, 4),
       (7, 1),
       (7, 5),
       (7, 7),
       (8, 10),
       (8, 1),
       (8, 2),
       (9, 8),
       (9, 3),
       (9, 9),
       (9, 11),
       (10, 8),
       (10, 3),
       (10, 9),
       (10, 11),
       (11, 12),
       (11, 13),
       (11, 3),
       (11, 14),
       (12, 1),
       (12, 5),
       (13, 1),
       (14, 12),
       (14, 13),
       (14, 3),
       (14, 11),
       (15, 1),
       (15, 9),
       (16, 2),
       (16, 7),
       (17, 8),
       (17, 9),
       (17, 10),
       (17, 1),
       (17, 2),
       (18, 13),
       (18, 3),
       (18, 7),
       (18, 11),
       (18, 14),
       (19, 10),
       (19, 2),
       (19, 4),
       (19, 1),
       (20, 1),
       (21, 15),
       (22, 7),
       (23, 7),
       (23, 2),
       (24, 1),
       (24, 15),
       (24, 11),
       (24, 7),
       (25, 1),
       (25, 11),
       (25, 15);



