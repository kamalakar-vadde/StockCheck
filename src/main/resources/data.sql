DROP TABLE IF EXISTS product;

CREATE TABLE product (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  is_blocked BOOLEAN DEFAULT FALSE,
  min_Stock_Level INT DEFAULT 0,
  current_Stock_Level INT DEFAULT 0
);

INSERT INTO product (name, is_blocked, min_Stock_Level,current_Stock_Level) VALUES
  ('a', FALSE, 4,5);
INSERT INTO product (name, is_blocked, min_Stock_Level,current_Stock_Level) VALUES
  ('b', TRUE, 4,8);
  INSERT INTO product (name, is_blocked, min_Stock_Level,current_Stock_Level) VALUES
  ('c', FALSE, 4,2);
  INSERT INTO product (name, is_blocked, min_Stock_Level,current_Stock_Level) VALUES
  ('d', FALSE, 8,0);
  INSERT INTO product (name, is_blocked, min_Stock_Level,current_Stock_Level) VALUES
  ('e', FALSE, 4,1);