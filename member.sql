DROP TABLE IF EXISTS member;

CREATE TABLE member(
  user_id INTEGER PRIMARY KEY,
  user_name TEXT NOT NULL,
  address TEXT NOT NULL,
  tel TEXT NOT NULL,
  email TEXT NOT NULL,
  enter_day DATE NOT NULL,
  leave_day DATE
);

ALTER TABLE member OWNER TO admin;
