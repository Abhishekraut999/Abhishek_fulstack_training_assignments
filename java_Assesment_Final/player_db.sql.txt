CREATE TABLE players (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    skill VARCHAR(20) NOT NULL,
    exp INT NOT NULL,
    country VARCHAR(50) NOT NULL,
    overall_score DOUBLE NOT NULL
);
