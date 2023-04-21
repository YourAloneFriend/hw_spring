CREATE TABLE users(
    id IDENTITY PRIMARY KEY,
    email VARCHAR(64) UNIQUE NOT NULL,
    password VARCHAR(128) NOT NULL
);

INSERT INTO users(email, password) VALUES('user@gmail.com', '$2a$12$4EdbDfHSiDASEs0s.bunBeqAWGRB5vaSPzal7sVWTMnO3DoUisXXe');