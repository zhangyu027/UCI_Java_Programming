-- UCI X460.17 Final Project - Student MariaDB setup
CREATE DATABASE IF NOT EXISTS library_db;
USE library_db;

CREATE TABLE IF NOT EXISTS books (
    id INT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(200) NOT NULL,
    available_copies INT NOT NULL CHECK (available_copies >= 0)
);

-- Optional starter data
INSERT IGNORE INTO books(id,title,author,available_copies) VALUES
(1,'Effective Java','Joshua Bloch',2),
(2,'Core Java Volume I','Cay Horstmann',3),
(3,'Clean Code','Robert C. Martin',1);
