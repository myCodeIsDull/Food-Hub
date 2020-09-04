DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS action;
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
    registered DATE    default now() NOT NULL
);

CREATE TABLE address
(
    id      INTEGER DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    city    VARCHAR(20)                       NOT NULL,
    street  VARCHAR(20)                       NOT NULL,
    house   VARCHAR(20)                       NOT NULL,
    phone   VARCHAR(20) CONSTRAINT unique_phone_number UNIQUE NOT NULL,
    rest_id INTEGER REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE menu
(
    id               INTEGER DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    date_of_creation DATE    DEFAULT now()                                 NOT NULL,
    restaurant_id          INTEGER REFERENCES restaurants (id) ON DELETE CASCADE,
    CONSTRAINT unique_upd_per_date_idx UNIQUE (restaurant_id, date_of_creation)
);

CREATE TABLE meal
(
    menu_id     INTEGER REFERENCES menu(id) ON DELETE CASCADE,
    price       INTEGER      NOT NULL,
    description VARCHAR(255) NOT NULL,
    PRIMARY KEY (menu_id, description)
);

CREATE TABLE users
(
    id         INTEGER DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    name       VARCHAR(255)            NOT NULL,
    email      VARCHAR(255) CONSTRAINT unique_email UNIQUE NOT NULL,
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

CREATE TABLE action
(
    date    DATE DEFAULT now()                     NOT NULL,
    time    TIME DEFAULT now()                     NOT NULL,
    user_id INTEGER REFERENCES users (id),
    menu_id INTEGER REFERENCES menu (id) ON DELETE CASCADE,
    PRIMARY KEY (date, user_id)
);
