
CREATE SCHEMA ormlearn; 
USE ormlearn;

CREATE TABLE country (
    co_code VARCHAR(2) PRIMARY KEY, 
    co_name VARCHAR(50)
); 

INSERT INTO country VALUES ('IN', 'India'); [cite: 624]
INSERT INTO country VALUES ('US', 'United States of America'); [cite: 625]

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE country; [cite: 773]
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO country (co_code, co_name) VALUES ("AF", "Afghanistan"); [cite: 774]
INSERT INTO country (co_code, co_name) VALUES ("AL", "Albania"); [cite: 775]
INSERT INTO country (co_code, co_name) VALUES ("DZ", "Algeria"); [cite: 776]

