DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS votes;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS meal;
DROP TABLE IF EXISTS menu;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS restaurants;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE GLOBAL_SEQ START WITH 100000;

CREATE TABLE restaurants
(
    id         INTEGER DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    name       VARCHAR(100)          NOT NULL,
    enabled    BOOLEAN DEFAULT TRUE  NOT NULL,
    registered DATE    DEFAULT now() NOT NULL,
    city       VARCHAR(100)          NOT NULL,
    house      VARCHAR(10)           NOT NULL,
    phone      VARCHAR(50)           NOT NULL,
    street     VARCHAR(255)          NOT NULL,
    CONSTRAINT unique_phone_number UNIQUE (phone)
);

CREATE TABLE meal
(
    id        INTEGER   DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    rest_id   INTEGER REFERENCES restaurants (id) ON DELETE CASCADE,
    price     INTEGER                 NOT NULL CHECK (price >= 10 AND price <= 5000),
    title     VARCHAR(255)            NOT NULL,
    published TIMESTAMP DEFAULT now() NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE users
(
    id         INTEGER DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    name       VARCHAR(255)            NOT NULL,
    email      VARCHAR(255)
        CONSTRAINT unique_email UNIQUE NOT NULL,
    password   VARCHAR(255)            NOT NULL,
    registered DATE    DEFAULT now()   NOT NULL,
    enabled    BOOLEAN DEFAULT TRUE    NOT NULL
);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR(255),
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE votes
(
    id         INTEGER   DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    rest_id    INTEGER   REFERENCES restaurants (id) ON DELETE CASCADE,
    user_id    INTEGER   REFERENCES users (id) ON DELETE CASCADE,
    registered TIMESTAMP DEFAULT now() NOT NULL
);