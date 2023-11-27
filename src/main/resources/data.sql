INSERT INTO Member (id, name, nick_name, email, password, gender, birth_date, phone_number, address, point, status)
VALUES (1, '김건우', 'ken', 'ken@naver.com', '1234', 'MALE', '1998-01-19', '010-1234-1234', '서울특별시 서대문구 남가좌동', 10000, 'ACTIVE');
INSERT INTO Owner (id) VALUES (2);
INSERT INTO Restaurant (id, owner_id, name, category, phone_number, address, status, opening_days, opening_hours, closing_hours)
VALUES (3, 2, 'KenStaurant', '일식', '02-123-1234', '서울특별시 서대문구 남가좌동', 'ACTIVE', '월,화,수,목,금', '09:00', '20:00');
INSERT INTO Mission (id, restaurant_id, content, reward, price, status) VALUES (4, 3, 'KenStaurant 에서 12,000원 이상의 식사를 하세요!', 500, 12000, 'ACTIVE');
INSERT INTO Mission (id, restaurant_id, content, reward, price, status) VALUES (5, 3, 'KenStaurant 에서 24,000원 이상의 식사를 하세요!', 1000, 24000, 'ACTIVE');
INSERT INTO Mission (id, restaurant_id, content, reward, price, status) VALUES (6, 3, 'KenStaurant 에서 36,000원 이상의 식사를 하세요!', 2000, 36000, 'PENDING');
INSERT INTO Member_mission(id, member_id, mission_id, status) VALUES (7, 1, 4, 'STARTED');