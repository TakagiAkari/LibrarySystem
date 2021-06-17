DROP TABLE IF EXISTS lending;
DROP TABLE IF EXISTS record;
DROP TABLE IF EXISTS catalog;
DROP TABLE IF EXISTS member;

CREATE TABLE lending (
  lend_id INTEGER PRIMARY KEY NOT NULL,
  user_id INTEGER NOT NULL REFERENCES member,
  book_id INTEGER  NOT NULL REFERENCES record,
  lend_day DATE NOT NULL,
  return_limit DATE NOT NULL,
  return_day DATE,
  memo TEXT
);

CREATE TABLE record (
  book_id INTEGER PRIMARY KEY,
  isbn INTEGER NOT NULL REFERENCES catalog,
  book_name TEXT NOT NULL,
  stock_day DATE NOT NULL,
  throwout_day DATE,
  memo TEXT
);

CREATE TABLE catalog (
  isbn INTEGER PRIMARY KEY NOT NULL,
  book_name TEXT NOT NULL,
  category INTEGER NOT NULL,
  author TEXT NOT NULL,
  publisher TEXT NOT NULL,
  publish_day DATE NOT NULL
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

INSERT INTO member(user_name, address, tel, email, birthday,enter_day) VALUES('óÈñÿ òaïv', 'ìåãûìsèaíJãÊ','111-1111', '1234@email.com', '1987/08/13', '20210401');
INSERT INTO member(user_name, address, tel, email, birthday,enter_day) VALUES('ìcíÜ ê^ã|', 'ìåãûìsê¢ìcíJãÊ','222-2222', '5656@email.com', '1993/10/13', '20200503');
INSERT INTO member(user_name, address, tel, email, birthday,enter_day, leave_day) VALUES('ìnï” ç_ìÒ', 'ìåãûìsç`ãÊ','333-3333', '2929@email.com', '1975/12/7','20210520', '20210601');

ALTER TABLE lending OWNER TO admin;
ALTER TABLE record OWNER TO admin;
ALTER TABLE catalog OWNER TO admin;
ALTER TABLE member OWNER TO admin;
