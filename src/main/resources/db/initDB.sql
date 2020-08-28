DROP TABLE user_roles IF EXISTS;
DROP TABLE votes IF EXISTS;
DROP TABLE users IF EXISTS;
DROP TABLE meal IF EXISTS;
DROP TABLE restaurants IF EXISTS;
DROP TABLE address IF EXISTS;
DROP SEQUENCE global_seq IF EXISTS;

CREATE SEQUENCE GLOBAL_SEQ AS INTEGER START WITH 100000;


CREATE TABLE address
(
    id     INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    city   VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    house  INTEGER      NOT NULL,
    phone  VARCHAR(255) NOT NULL
);

CREATE TABLE restaurants
(
    id         INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    address_id INTEGER REFERENCES address ON DELETE CASCADE,
    enabled    BOOLEAN   DEFAULT TRUE  NOT NULL,
    CONSTRAINT unique_address_name_idx UNIQUE (address_id, name)
);

CREATE TABLE meal
(
    meal_id  INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    rest_id  INTEGER      NOT NULL,
    name     VARCHAR(255) NOT NULL,
    price    INTEGER      NOT NULL,
    date_upd DATE         NOT NULL,
    CONSTRAINT unique_upd_per_date_idx UNIQUE (rest_id, date_upd, name),
    FOREIGN KEY (rest_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE users
(
    id         INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    name       VARCHAR(255)            NOT NULL,
    email      VARCHAR(255)            NOT NULL,
    password   VARCHAR(255)            NOT NULL,
    registered TIMESTAMP DEFAULT now() NOT NULL,
    enabled    BOOLEAN   DEFAULT TRUE  NOT NULL
);

CREATE TABLE votes
(
    id      INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    rest_id INTEGER REFERENCES restaurants ON DELETE CASCADE,
    user_id INTEGER REFERENCES users (id),
    date    DATE NOT NULL,
    CONSTRAINT user_vote_unique_idx UNIQUE (user_id, date)
);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR(255),
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);