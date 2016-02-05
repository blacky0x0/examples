-- CREATE DATABASE library WITH OWNER = postgres ENCODING = 'UTF8' TABLESPACE = pg_default;

CREATE TABLE IF NOT EXISTS author (
  id serial primary key,
  name text NOT NULL
);

insert into author values (1, 'Davis');