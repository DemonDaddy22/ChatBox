CREATE TABLE IF NOT EXISTS USERS {
    userId Integer PRIMARY KEY auto_increment,
    username VARCHAR,
    firstName VARCHAR(20),
    lastname VARCHAR(20),
    password VARCHAR,
    salt VARCHAR
};

CREATE TABLE IF NOT EXISTS MESSAGES {
    messageId Integer PRIMARY KEY auto_increment,
    username VARCHAR NOT NULL,
    message VARCHAR NOT NULL
};