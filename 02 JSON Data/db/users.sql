CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    email VARCHAR(100)
);
INSERT INTO users (name, age, email) VALUES
('Alice', 30, 'alice@example.com'),
('Bob', 22, 'bob@example.com'),
('Charlie', 35, 'charlie@example.com');
SELECT * FROM users;
SELECT * FROM users WHERE age > 25;
UPDATE users SET age = 32 WHERE name = 'Alice';
DELETE FROM users WHERE name = 'Bob';
