CREATE TABLE authority(
    email VARCHAR(64) UNIQUE NOT NULL,
    authority VARCHAR(64) NOT NULL,
    FOREIGN KEY (email) REFERENCES users (email)
);

INSERT INTO authority(email, authority) VALUES('user@gmail.com', 'ROLE_USER');