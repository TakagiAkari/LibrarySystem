DROP TABLE IF EXISTS record;

CREATE TABLE record (
  book_id INTEGER PRIMARY KEY,
  isbn INTEGER NOT NULL REFERENCES catalog,
  book_name TEXT NOT NULL,
  stock_day DATE NOT NULL,
  throwout_day DATE,
  memo TEXT
);
