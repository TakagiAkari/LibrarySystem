DROP TABLE IF EXISTS lending;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS record;
DROP TABLE IF EXISTS catalog;



CREATE TABLE catalog (
  isbn BIGINT PRIMARY KEY NOT NULL,
  book_name TEXT NOT NULL,
  category INTEGER NOT NULL,
  author TEXT NOT NULL,
  publisher TEXT NOT NULL,
  publish_day DATE NOT NULL
);

CREATE TABLE record (
  book_id SERIAL PRIMARY KEY,
  isbn BIGINT NOT NULL REFERENCES catalog,
  stock_day DATE NOT NULL,
  throwout_day DATE,
  memo TEXT
);

CREATE TABLE member(
  user_id SERIAL PRIMARY KEY,
  user_name TEXT NOT NULL,
  address TEXT NOT NULL,
  tel TEXT NOT NULL,
  email TEXT NOT NULL,
  birthday DATE NOT NULL,
  enter_day DATE NOT NULL,
  leave_day DATE
);

CREATE TABLE lending (
  lend_id INTEGER PRIMARY KEY NOT NULL,
  user_id INTEGER NOT NULL REFERENCES member,
  book_id INTEGER  NOT NULL REFERENCES record,
  lend_day DATE NOT NULL,
  return_limit DATE NOT NULL,
  return_day DATE,
  memo TEXT
);


INSERT INTO member(user_name, address, tel, email, birthday,enter_day) VALUES('��� �a�v', '�����s�a�J��','111-1111', '1234@email.com', '1987.08.13', '20210401');
INSERT INTO member(user_name, address, tel, email, birthday,enter_day) VALUES('�c�� �^�|', '�����s���c�J��','222-2222', '5656@email.com', '1993.10.13', '20200503');
INSERT INTO member(user_name, address, tel, email, birthday,enter_day, leave_day) VALUES('�n�� �_��', '�����s�`��','333-3333', '2929@email.com', '1975.12.7','20210520', '20210601');

INSERT INTO catalog(isbn, book_name, category, author, publisher, publish_day) VALUES('4906638015', '7�̏K��', '3', '�X�e�B�[�u���ER�E�R�r�[', '�L���O�x�A�[�o��', '1996.12.25');
INSERT INTO catalog(isbn, book_name, category, author, publisher, publish_day) VALUES('4480425993', '�悢���̌N��_', '1', '�ː_�@����', '�}�����[', '2009.05.11');

INSERT INTO record(isbn,stock_day,throwout_day, memo) VALUES('4906638015', '2010.01.07','2003.08.05','�򉻂̂��ߔp��');
INSERT INTO record(isbn, stock_day) VALUES('4906638015',  '2010.01.07');
INSERT INTO record(isbn, stock_day) VALUES('4480425993',  '2015.10.18');

ALTER TABLE member OWNER TO admin;
ALTER TABLE catalog OWNER TO admin;
ALTER TABLE record OWNER TO admin;
ALTER TABLE lending OWNER TO admin;
