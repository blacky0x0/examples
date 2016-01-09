CREATE SCHEMA IF NOT EXISTS library DEFAULT CHARACTER SET utf8;

DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS another_book;

CREATE TABLE IF NOT EXISTS book (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(255),
  PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS another_book (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(255),
  PRIMARY KEY (id)
) ENGINE = InnoDB;

TRUNCATE book;
TRUNCATE another_book;

INSERT INTO book (id, title)
VALUES
  (1, 'Spring book'),
  (2, 'spring Book');

INSERT INTO another_book (id, title)
VALUES
  (1, 'spring book'),
  (2, 'spring book');

