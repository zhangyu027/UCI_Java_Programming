CREATE DATABASE IF NOT EXISTS University;
USE University;

CREATE TABLE IF NOT EXISTS Students (
    student_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    major VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Courses (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    credits INT
);

INSERT INTO Students (student_id, first_name, last_name, email, major)
VALUES (1001, 'Alex', 'Chen', 'alex@uci.edu', 'Computer Science')
ON DUPLICATE KEY UPDATE student_id = student_id;
