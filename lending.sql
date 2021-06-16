DROP TABLE IF EXISTS lending;

CREATE TABLE lending (
  lend_id INTEGER PRIMARY KEY NOT NULL,
  user_id INTEGER NOT NULL REFERENCES member,
  book_id INTEGER  NOT NULL REFERENCES record,
  lend_day DATE NOT NULL,
  return_limit DATE NOT NULL,
  return_day DATE,
  memo TEXT
);
