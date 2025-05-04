
CREATE TABLE IF NOT EXISTS users (
  user_id SERIAL PRIMARY KEY,
  user_name VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(100),
  email VARCHAR(100) UNIQUE,
  date_of_birth DATE
);

INSERT INTO users (user_name, password) VALUES
  ('qwezy', 'qqq');

CREATE TABLE IF NOT EXISTS rooms (
  room_id SERIAL PRIMARY KEY,
  company_name VARCHAR(50) NOT NULL,
  room_name VARCHAR(50) NOT NULL,
  company_email VARCHAR(100),
  company_phone VARCHAR(20),
  location VARCHAR(100),
  price DECIMAL(10, 2),
  type TEXT
);

CREATE TABLE IF NOT EXISTS opinions (
  opinion_id SERIAL PRIMARY KEY,
  user_id INT,
  room_id INT,
  Date_of_publication TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  comment TEXT,
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (room_id) REFERENCES rooms(room_id)
);

CREATE TABLE IF NOT EXISTS room_owners (
  owner_id SERIAL PRIMARY KEY,
  company_name VARCHAR(50) NOT NULL UNIQUE,
  company_email VARCHAR(100) UNIQUE,
  company_phone VARCHAR(20) UNIQUE,
  Company_location VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS shipping_cart(
  user_id INT,
  room_id INT,
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (room_id) REFERENCES rooms(room_id)
);

CREATE TABLE IF NOT EXISTS is_room_avaible(
  room_id INT,
  FOREIGN KEY (room_id) REFERENCES rooms(room_id),
  is_avaible BOOLEAN DEFAULT TRUE
);
CREATE TABLE IF NOT EXISTS logs(
  log_id SERIAL PRIMARY KEY,
  user_id INT,
  action VARCHAR(255),
  timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);
CREATE TABLE IF NOT EXISTS bookmarks(
  user_id INT,
  room_id INT,
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (room_id) REFERENCES rooms(room_id)
);

ALTER TABLE rooms ADD FOREIGN KEY (company_name) REFERENCES room_owners(company_name);

ALTER TABLE rooms ADD FOREIGN KEY (company_email) REFERENCES room_owners(company_email);

ALTER TABLE rooms ADD FOREIGN KEY (company_phone) REFERENCES room_owners(company_phone);
