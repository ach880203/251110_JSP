use edudb;

create table fruitList(
   code int primary key auto_increment,
    name varchar(30),
    price int,
    origin varchar(30),
    description varchar(1000),
    pictureurl varchar(50)
);

desc fruitList;

insert into fruitList(name, price, origin, description, pictureurl)
values('파인애플', 6500, '태국산', '새콤달콤한 맛이 일품인 골드 파인애플입니다. 손질이 쉽습니다.', 'pineapple.jpg'),
('수박', 10000, '국내산', '달콤하고 시원하며 맛있는 수박입니다. 여름에 제격입니다. (당도 12brix 이상)', 'watermelon.jpg'),
('사과 (부사)', 2500, '국내산', '아삭하고 당도 높은 부사 사과입니다. 개당 가격입니다. (경북 영주산)', 'apple.png'),
('바나나 (1송이)', 4900, '필리핀산', '필리핀산 고당도 바나나 한 송이입니다. 아침 식사 대용으로 좋습니다.', 'banana.jpg'),
('제주 감귤', 8900, '국내산', '새콤달콤한 제주산 감귤 1kg 박스입니다. 비타민 C가 풍부합니다. (무농약)', 'tangerine.webp'),
('딸기 (500g)', 12900, '국내산', '신선하고 향이 좋은 딸기 500g 팩입니다. (논산 특품)', 'strawberry.jpg'),
('블루베리 (냉동 1kg)', 15900, '캐나다산', '캐나다산 냉동 블루베리 1kg입니다. 요거트 토핑으로 활용하세요.', 'blueberry_frozen.webp'),
('아보카도 (2개)', 7500, '멕시코산', '후숙이 필요한 멕시코산 아보카도 2개 세트입니다. (샐러드용)', 'avocado.jpg'),
('망고 (태국산)', 9900, '태국산', '달콤하고 부드러운 태국산 망고입니다. 후식으로 최고입니다.', 'mango.png'),
('샤인머스켓 포도 (1.5kg)', 28000, '국내산', '씨가 없고 껍질째 먹는 고급 포도입니다. (선물용 포장)', 'shinemuscat.jpg');
select * from fruitList;