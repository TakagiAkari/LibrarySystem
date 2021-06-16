DROP TABLE IF EXISTS catalog;

CREATE TABLE catalog (
  isbn INTEGER PRIMARY KEY NOT NULL,
  book_name TEXT NOT NULL,
  category INTEGER NOT NULL,
  author TEXT NOT NULL,
  publisher TEXT NOT NULL,
  publish_day DATE NOT NULL
);
