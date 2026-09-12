CREATE DATABASE IF NOT EXISTS University;
CREATE DATABASE IF NOT EXISTS library_db;
CREATE DATABASE IF NOT EXISTS company_db;
CREATE DATABASE IF NOT EXISTS hamburger_db;
CREATE DATABASE IF NOT EXISTS student_grade_db;
CREATE DATABASE IF NOT EXISTS warehouse_db;
CREATE DATABASE IF NOT EXISTS rental_shop;
CREATE DATABASE IF NOT EXISTS EmployeeManagement;

CREATE USER IF NOT EXISTS 'javauser'@'localhost' IDENTIFIED BY 'JavaClass2026';
CREATE USER IF NOT EXISTS 'javauser'@'127.0.0.1' IDENTIFIED BY 'JavaClass2026';
ALTER USER 'javauser'@'localhost' IDENTIFIED BY 'JavaClass2026';
ALTER USER 'javauser'@'127.0.0.1' IDENTIFIED BY 'JavaClass2026';

GRANT ALL PRIVILEGES ON University.* TO 'javauser'@'localhost';
GRANT ALL PRIVILEGES ON library_db.* TO 'javauser'@'localhost';
GRANT ALL PRIVILEGES ON company_db.* TO 'javauser'@'localhost';
GRANT ALL PRIVILEGES ON hamburger_db.* TO 'javauser'@'localhost';
GRANT ALL PRIVILEGES ON student_grade_db.* TO 'javauser'@'localhost';
GRANT ALL PRIVILEGES ON warehouse_db.* TO 'javauser'@'localhost';
GRANT ALL PRIVILEGES ON rental_shop.* TO 'javauser'@'localhost';
GRANT ALL PRIVILEGES ON EmployeeManagement.* TO 'javauser'@'localhost';
GRANT ALL PRIVILEGES ON University.* TO 'javauser'@'127.0.0.1';
GRANT ALL PRIVILEGES ON library_db.* TO 'javauser'@'127.0.0.1';
GRANT ALL PRIVILEGES ON company_db.* TO 'javauser'@'127.0.0.1';
GRANT ALL PRIVILEGES ON hamburger_db.* TO 'javauser'@'127.0.0.1';
GRANT ALL PRIVILEGES ON student_grade_db.* TO 'javauser'@'127.0.0.1';
GRANT ALL PRIVILEGES ON warehouse_db.* TO 'javauser'@'127.0.0.1';
GRANT ALL PRIVILEGES ON rental_shop.* TO 'javauser'@'127.0.0.1';
GRANT ALL PRIVILEGES ON EmployeeManagement.* TO 'javauser'@'127.0.0.1';
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
INSERT IGNORE INTO Students(student_id, first_name, last_name, email, major)
VALUES (1001, 'Alex', 'Chen', 'alex@uci.edu', 'Computer Science');

USE library_db;
CREATE TABLE IF NOT EXISTS books (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  available_copies INT NOT NULL DEFAULT 0
);

USE company_db;
CREATE TABLE IF NOT EXISTS employees (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(200) NOT NULL
);

USE hamburger_db;
CREATE TABLE IF NOT EXISTS orders (
  order_id INT PRIMARY KEY AUTO_INCREMENT,
  customer_name VARCHAR(200) NOT NULL,
  burger_type VARCHAR(200) NOT NULL,
  order_date DATE NOT NULL
);

USE student_grade_db;
CREATE TABLE IF NOT EXISTS student_grades (
  id INT PRIMARY KEY AUTO_INCREMENT,
  midterm_score DECIMAL(5,2) NOT NULL,
  final_score DECIMAL(5,2) NOT NULL,
  average_grade VARCHAR(2) NOT NULL
);

USE warehouse_db;
CREATE TABLE IF NOT EXISTS warehouse_data (
  id INT PRIMARY KEY AUTO_INCREMENT,
  received_items INT NOT NULL,
  item_price DECIMAL(10,2) NOT NULL,
  total_price DECIMAL(12,2) NOT NULL,
  remaining_stock INT NOT NULL
);

USE rental_shop;
CREATE TABLE IF NOT EXISTS games (
  game_id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  platform VARCHAR(100) NOT NULL
);
CREATE TABLE IF NOT EXISTS rentals (
  rental_id INT PRIMARY KEY AUTO_INCREMENT,
  game_id INT,
  customer_name VARCHAR(255),
  rental_date DATE,
  return_date DATE,
  FOREIGN KEY (game_id) REFERENCES games(game_id)
);
INSERT IGNORE INTO games(game_id, title, platform) VALUES
  (1, 'Sample Adventure', 'PC'),
  (2, 'Sample Racing', 'Nintendo Switch');

USE EmployeeManagement;
CREATE TABLE IF NOT EXISTS employee (
  id INT PRIMARY KEY,
  name VARCHAR(255),
  position VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS hr (
  employee_id INT PRIMARY KEY,
  hr_info VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS payroll (
  employee_id INT PRIMARY KEY,
  salary DECIMAL(10,2)
);
