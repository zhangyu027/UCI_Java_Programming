-- UCI I&C SCI X460.17 Final Project
-- Library Management System - MariaDB setup

CREATE DATABASE IF NOT EXISTS library_db;
USE library_db;

CREATE TABLE IF NOT EXISTS books (
    id INT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(200) NOT NULL,
    available_copies INT NOT NULL CHECK (available_copies >= 0)
);

INSERT IGNORE INTO books (id, title, author, available_copies) VALUES
(101, 'Introduction to Java', 'Daniel Liang', 3),
(102, 'Effective Java', 'Joshua Bloch', 2),
(103, 'Clean Code', 'Robert C. Martin', 1);

SELECT * FROM books;
