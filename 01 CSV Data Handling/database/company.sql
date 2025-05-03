CREATE DATABASE IF NOT EXISTS company;
USE company;
CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(50),
    salary DOUBLE
);
INSERT INTO employees VALUES
(1, 'Alice', 'IT', 70000),
(2, 'Bob', 'HR', 60000),
(3, 'Charlie', 'Finance', 65000),
(4, 'David', 'IT', 72000),
(5, 'Eve', 'Marketing', 58000);