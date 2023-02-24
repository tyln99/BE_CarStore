
CREATE TABLE model (
	id SERIAL PRIMARY KEY,
  name VARCHAR ( 255 ),
  logo TEXT,
  price INT,
  description TEXT,
  status INT,
  release_date TIMESTAMP,
  updated_at TIMESTAMP,
  created_at TIMESTAMP
);

CREATE TABLE brand (
	id SERIAL PRIMARY KEY,
  name VARCHAR ( 255 ),
  logo TEXT,
  description TEXT,
  status INT,
  brand_id: INT NOT NULL,
  release_date TIMESTAMP,
  updated_at TIMESTAMP,
  created_at TIMESTAMP
);

ALTER TABLE model
  ADD CONSTRAINT fk_model_brand FOREIGN KEY (id) 
  REFERENCES brand (id);
