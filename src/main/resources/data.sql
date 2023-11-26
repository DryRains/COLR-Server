INSERT INTO Member (id, name, nick_name, email, password, gender, birth_date, phone_number, address, point, status)
VALUES (1, '김건우', 'ken', 'ken@naver.com', '1234', 'MALE', '1998-01-19', '010-1234-1234', '서울특별시 서대문구 남가좌동', 10000, 'ACTIVE');
INSERT INTO Owner (id) VALUES (2);
INSERT INTO Restaurant (id, owner_id, name, category, phone_number, address, status, opening_days, opening_hours, closing_hours)
VALUES (3, 2, 'KenStaurant', '일식', '02-123-1234', '서울특별시 서대문구 남가좌동', 'ACTIVE', '월,화,수,목,금', '09:00', '20:00');