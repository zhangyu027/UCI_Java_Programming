-- Module 4 in-class database setup
-- Run this as a MariaDB administrative account.

CREATE DATABASE IF NOT EXISTS University;
CREATE DATABASE IF NOT EXISTS company_db;
CREATE DATABASE IF NOT EXISTS hamburger_db;
CREATE DATABASE IF NOT EXISTS student_grade_db;
CREATE DATABASE IF NOT EXISTS warehouse_db;

-- If javauser already exists, grant access to all practice databases.
GRANT ALL PRIVILEGES ON University.* TO 'javauser'@'localhost';
GRANT ALL PRIVILEGES ON company_db.* TO 'javauser'@'localhost';
GRANT ALL PRIVILEGES ON hamburger_db.* TO 'javauser'@'localhost';
GRANT ALL PRIVILEGES ON student_grade_db.* TO 'javauser'@'localhost';
GRANT ALL PRIVILEGES ON warehouse_db.* TO 'javauser'@'localhost';
FLUSH PRIVILEGES;

USE University;
CREATE TABLE IF NOT EXISTS Students (
    student_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    major VARCHAR(100)
);
INSERT INTO Students
(student_id, first_name, last_name, email, major)
VALUES (1001, 'Alex', 'Chen', 'alex@uci.edu', 'Computer Science')
ON DUPLICATE KEY UPDATE student_id = student_id;

USE company_db;
CREATE TABLE IF NOT EXISTS employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

USE hamburger_db;
CREATE TABLE IF NOT EXISTS orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(100) NOT NULL,
    burger_type VARCHAR(100) NOT NULL,
    order_date DATE NOT NULL
);

USE student_grade_db;
CREATE TABLE IF NOT EXISTS student_grades (
    id INT PRIMARY KEY AUTO_INCREMENT,
    midterm_score DECIMAL(5,2) NOT NULL,
    final_score DECIMAL(5,2) NOT NULL,
    average_grade VARCHAR(5) NOT NULL
);

USE warehouse_db;
CREATE TABLE IF NOT EXISTS warehouse_data (
    id INT PRIMARY KEY AUTO_INCREMENT,
    received_items INT NOT NULL,
    item_price DECIMAL(10,2) NOT NULL,
    total_price DECIMAL(12,2) NOT NULL,
    remaining_stock INT NOT NULL
);
