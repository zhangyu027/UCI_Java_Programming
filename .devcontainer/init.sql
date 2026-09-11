CREATE DATABASE IF NOT EXISTS University;
CREATE DATABASE IF NOT EXISTS library_db;

CREATE USER IF NOT EXISTS 'javauser'@'localhost' IDENTIFIED BY 'JavaClass2026';
CREATE USER IF NOT EXISTS 'javauser'@'127.0.0.1' IDENTIFIED BY 'JavaClass2026';

ALTER USER 'javauser'@'localhost' IDENTIFIED BY 'JavaClass2026';
ALTER USER 'javauser'@'127.0.0.1' IDENTIFIED BY 'JavaClass2026';

GRANT ALL PRIVILEGES ON University.* TO 'javauser'@'localhost';
GRANT ALL PRIVILEGES ON library_db.* TO 'javauser'@'localhost';
GRANT ALL PRIVILEGES ON University.* TO 'javauser'@'127.0.0.1';
GRANT ALL PRIVILEGES ON library_db.* TO 'javauser'@'127.0.0.1';

FLUSH PRIVILEGES;

USE University;

CREATE TABLE IF NOT EXISTS Students (
  student_id INT PRIMARY KEY,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  email VARCHAR(200),
  major VARCHAR(150)
);

CREATE TABLE IF NOT EXISTS Courses (
  course_id INT PRIMARY KEY AUTO_INCREMENT,
  course_name VARCHAR(200) NOT NULL
);

INSERT IGNORE INTO Students
(student_id, first_name, last_name, email, major)
VALUES
(1001, 'Alex', 'Chen', 'alex@uci.edu', 'Computer Science');

USE library_db;

CREATE TABLE IF NOT EXISTS books (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  available_copies INT NOT NULL DEFAULT 0
);
