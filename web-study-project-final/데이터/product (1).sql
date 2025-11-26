use edudb;
CREATE DATABASE IF NOT EXISTS memberdb;
USE memberdb;

DROP TABLE IF EXISTS members;

CREATE TABLE members (
    id INT AUTO_INCREMENT PRIMARY KEY,   
    name VARCHAR(50),
    user_id VARCHAR(50),
    user_pw VARCHAR(100),
    nick VARCHAR(30),
    phone VARCHAR(20),
    admin INT,
    email VARCHAR(100),
    reg_date DATE,
    address VARCHAR(200)
);


INSERT INTO members 
(name, user_id, user_pw, nick,  phone, admin, email, reg_date, address)
VALUES
('이한나', 'leehn', 'A6B3C1D4E9F2G7H8','소금', '010-9284-7821','0', 'hannalee@example.com', '2024-01-10', '서울시 강남구 역삼동'),
('김민준', 'minjun_k', 'B8C7D6E5F4G3H2I1','나무', '010-1234-5678','0', 'minjun.kim@testmail.com', '2024-03-15', '경기도 성남시 분당구'),
('박서연', 'seoyeon_p', 'C9D8E7F6G5H4I3J2','달밤', '010-2345-6789','0', 'park.sy@kmail.net', '2024-05-01', '부산광역시 해운대구'),
('최우진', 'woojin_c', 'D0E1F2G3H4I5J6K7','하늘', '010-3456-7890','0', 'woojinc@mail.co.kr', '2024-06-20', '인천광역시 연수구'),
('정유나', 'yuna_j', 'E1F2G3H4I5J6K7L8','별빛', '010-4567-8901', '0','yuna.j@webmail.com', '2024-07-05', '대구광역시 수성구'),
('강도현', 'dohyun_k', 'F2G3H4I5J6K7L8M9','꼬마', '010-5678-9012','0', 'dohyun88@example.net', '2024-08-18', '광주광역시 서구'),
('장하은', 'haeun_j', 'G3H4I5J6K7L8M9N0','단비', '010-6789-0123','0', 'janghe@test.kr', '2024-09-25', '대전광역시 유성구'),
('윤지호', 'jiho_y', 'H4I5J6K7L8M9N0O1','바람', '010-7890-1234', '0','jiho.yun@mailsite.com', '2024-10-10', '울산광역시 남구'),
('신예림', 'yerim_s', 'I5J6K7L8M9N0O1P2','은하', '010-8901-2345', '0','yerim_shin@email.com', '2024-11-03', '세종특별자치시 아름동'),
('임재현', 'jaehyeon_i', 'J6K7L8M9N0O1P2Q3','햇살', '010-9012-3456','0', 'jh_lim@kcorp.com', '2024-12-07', '제주특별자치도 제주시'),
('전원지','onegee', '1234',  '슬픈 원지','010-4548-6589', '1','one@nate.com','2024-12-07',  '서울 강동구 천호동'),
('김열정','firekim', '1234', '불타는남자', '010-4128-6425','1','fire@gmail.com', '2024-12-07',   '서울 강서구'),
( '안효율','hyhy11', '1234', '효율이중요하지', '010-8576-1789', '1','hyhy111@nate.com','2024-12-07',   '경기도 남양주시'),
('김일단','indan', '1234',  '일단넣어', '010-4548-1231','1','1d1d@nate.com', '2024-12-07',  '서울 강동구 천호동'),
('현지누','jinujinu', '1234',  '지누션?', '010-4548-7658','1','jnu123@nate.com', '2024-12-07',  '서울 강동구 천호동');

TRUNCATE TABLE members;


SELECT * FROM members;
SELECT * FROM members ORDER BY id DESC;

show tables;