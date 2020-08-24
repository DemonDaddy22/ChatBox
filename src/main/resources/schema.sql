CREATE TABLE IF NOT EXISTS USERS (
    userId INT PRIMARY KEY auto_increment,
    username VARCHAR(40),
    firstName VARCHAR(20),
    lastname VARCHAR(20),
    password VARCHAR,
    salt VARCHAR
);

CREATE TABLE IF NOT EXISTS MESSAGES (
    messageId INT PRIMARY KEY auto_increment,
    username VARCHAR NOT NULL,
    message VARCHAR NOT NULL
);