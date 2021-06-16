DROP TABLE IF EXISTS lending;
DROP TABLE IF EXISTS member;

CREATE TABLE member(
  user_id SERIAL PRIMARY KEY,
  user_name TEXT NOT NULL,
  address TEXT NOT NULL,
  tel TEXT NOT NULL,
  email TEXT NOT NULL,
  enter_day DATE NOT NULL,
  leave_day DATE
);

INSERT INTO member(user_name, address, tel, email, enter_day) VALUES('��� �a�v', '�����s�a�J��','111-1111', '1234@email.com', '20210401');
INSERT INTO member(user_name, address, tel, email, enter_day) VALUES('�c�� �^�|', '�����s���c�J��','222-2222', '5656@email.com', '20200503');
INSERT INTO member(user_name, address, tel, email, enter_day, leave_day) VALUES('�n�� �_��', '�����s�`��','333-3333', '2929@email.com', '20210520', '20210601');

ALTER TABLE member OWNER TO admin;
