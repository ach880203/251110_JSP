use edudb;

create table fruit(
num int primary key auto_increment,
pass varchar(30) not null, 
title varchar(30) , 
date varchar (30),
views int default 0,
text TEXT (50)
);

desc fruit;

INSERT INTO fruit (title,pass, date, text) 
VALUES ('제철과일','1234', '2025-11-22','이 게시물은 일반 테스트 데이터입니다. 상세 내용이 없습니다.');

INSERT INTO fruit (title,pass, date, text) 
VALUES ('공지사항입니다','2234', '2025-11-23','안녕하세요, 서비스에 중요한 공지사항입니다. 자세한 내용은 아래를 참조해 주세요.\n\n[주요 내용]: 긴급 패치 예정'); 

INSERT INTO fruit (title,pass, date, text) 
VALUES ('서버 점검 일정 안내','3234', '2025-11-24', '안정적인 서비스 제공을 위해 서버 점검이 예정되어 있습니다.\n일시: 2025년 12월 1일 새벽 2시 ~ 5시 (3시간)\n이용에 불편을 드려 죄송합니다.');

INSERT INTO fruit (title,pass, date, text) 
VALUES ('신규 기능 업데이트 내용','4234', '2025-11-25', '새로운 기능 A와 기능 B가 추가되었습니다. 사용법은 [링크]를 참고해 주세요.');

INSERT INTO fruit (title,pass, date, text) 
VALUES ('사용자 가이드 FAQ',5234, '2025-11-26','자주 묻는 질문 모음입니다. 계정 문제, 결제 문제, 오류 해결법 등을 확인하실 수 있습니다.');

commit;

select * from fruit;

select * from fruit where num = 5;

select * from fruit order by num desc;

update fruit set views = views+1 where num = 5;

insert into fruit(title,pass, date,text) 
values('공지사항','6234','2025-11-22','이 게시물은 일반 테스트 데이터입니다. 상세 내용이 없습니다.');

delete from fruit where num = 8;

