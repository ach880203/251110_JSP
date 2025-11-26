use edudb;

CREATE TABLE member (
    num INT UNIQUE AUTO_INCREMENT,
    userid VARCHAR(30) PRIMARY KEY,
    pass VARCHAR(30) NOT NULL,
    name VARCHAR(30),
    nick VARCHAR(30),
    email VARCHAR(30),
    phone CHAR(13),
    admin INT(1),
    address varchar(50),
    writedate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


desc member;

select * from member;

insert into member(userid, pass, name, nick, email, phone, admin, address)
values('onegee', '1234', '전원지', '슬픈 원지', 'one@nate.com', '010-4548-6589', '1', '서울 강동구 천호동');

insert into member(userid, pass, name, nick, email, phone, admin, address)
values('firekim', '1234', '김열정', '불타는남자', 'fire@gmail.com', '010-4128-6425',  '1', '서울 강서구');

insert into member(userid, pass, name, nick, email, phone, admin, address)
values('hyhy11', '1234', '안효율', '효율이중요하지', 'hyhy111@nate.com', '010-8576-1789',  '1', '경기도 남양주시');

insert into member(userid, pass, name, nick, email, phone, admin, address)
values('indan', '1234', '김일단', '일단넣어', '1d1d@nate.com', '010-4548-1231', '1', '서울 강동구 천호동');

insert into member(userid, pass, name, nick, email, phone, admin, address)
values('jinujinu', '1234', '현지누', '지누션?', 'jnu123@nate.com', '010-4548-7658', '1', '서울 강동구 천호동');

select * from member;
DELETE FROM member WHERE userid = 'onegee';
alter table member add column address varchar(100);