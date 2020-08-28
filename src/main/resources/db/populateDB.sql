DELETE FROM user_roles;
DELETE FROM votes;
DELETE FROM users;
DELETE FROM meal;
DELETE FROM restaurants;
DELETE FROM address;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001),
       ('USER', 100001);

INSERT INTO ADDRESS(CITY, STREET, HOUSE, PHONE)
VALUES ('Springfield','Main St','20','555-35-35'),
       ('Springfield','Maple St','5','333-40-51'),
       ('Springfield','High St','13','348-88-13'),
       ('Springfield','Park St','3','315-43-12'),
       ('Springfield','Union St','22','733-90-11');

INSERT INTO RESTAURANTS(NAME, ADDRESS_ID)
VALUES ('Crown Fried Chicken',100002),
       ('McDonalds',100003),
       ('Venice',100004),
       ('Tap And Tandoor',100005),
       ('Seafood Heaven',100006);

INSERT INTO MEAL(rest_id, name, price, date_upd)
VALUES (100007,'Fried Chicken',1075,'2020-08-10'),
       (100007,'Fresh Salad',838,'2020-08-10'),
       (100007,'Beer',100,'2020-08-10'),
       (100008,'Big MAC',2580,'2020-08-10'),
       (100008,'Fried potato',500,'2020-08-10'),
       (100008,'Coca-Cola',35,'2020-08-10'),
       (100009,'Pasta',1548,'2020-08-10'),
       (100009,'Cheese plate',525,'2020-08-10'),
       (100009,'Dry vine',150,'2020-08-10'),
       (100010,'Soya Tikka',650,'2020-08-10'),
       (100010,'Fresh Salad',550,'2020-08-10'),
       (100010,'Vegetable Kebab',450,'2020-08-10'),
       (100010,'Fresh Water',20,'2020-08-10'),
       (100011,'Trout on charcoals',2035,'2020-08-10'),
       (100011,'Fried Shrimps',800,'2020-08-10'),
       (100011,'Sea food salad',1095,'2020-08-10'),
       (100011,'White vine',150,'2020-08-10');

INSERT INTO VOTES(REST_ID, USER_ID, DATE)
VALUES (100007,100000,'2020-08-10');

