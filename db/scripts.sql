-- CREATE TABLE IF NOT EXISTS carshop.model
-- (
--     id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
--     name text COLLATE pg_catalog."default",
--     price integer,
--     description text COLLATE pg_catalog."default",
--     status integer,
--     release_date bigint,
--     updated_at bigint,
--     created_at bigint,
--     CONSTRAINT model_pkey PRIMARY KEY (id)
-- )


CREATE TABLE model (
	id INT PRIMARY KEY,
  name VARCHAR ( 255 ),
  price INT,
  description TEXT,
  status INT,
  release_date TIMESTAMP,
  updated_at TIMESTAMP,
  created_at TIMESTAMP
);

CREATE TABLE brand (
	id INT PRIMARY KEY,
  name VARCHAR ( 255 ),
  description TEXT,
  status INT,
  release_date TIMESTAMP,
  updated_at TIMESTAMP,
  created_at TIMESTAMP
);

ALTER TABLE model
  ADD CONSTRAINT fk_model_brand FOREIGN KEY (id) 
  REFERENCES brand (brand);
