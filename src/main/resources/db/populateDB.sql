DELETE FROM user_roles;
DELETE FROM action;
DELETE FROM users;
DELETE FROM meal;
DELETE FROM menu;
DELETE FROM address;
DELETE FROM restaurants;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001),
       ('USER', 100001);

INSERT INTO RESTAURANTS(NAME, REGISTERED)
VALUES ('Crown Fried Chicken','2018-12-03'),
       ('McDonalds','2017-08-11'),
       ('Venice','2020-03-25'),
       ('Tap And Tandoor','2020-05-09'),
       ('Seafood Heaven','2019-04-08');

INSERT INTO ADDRESS(CITY, STREET, HOUSE, PHONE, REST_ID)
VALUES ('Springfield','Main St','20','555-35-35',100002),
       ('Springfield','Maple St','5','333-40-51',100003),
       ('Springfield','High St','13','348-88-13',100004),
       ('Springfield','Park St','3','315-43-12',100005),
       ('Springfield','Union St','22','733-90-11',100006);

INSERT INTO MENU(RESTAURANT_ID, DATE_OF_CREATION)
VALUES (100002,'2020-08-10'),
       (100003, '2020-08-10'),
       (100004, '2020-08-10'),
       (100005, '2020-08-10'),
       (100006, '2020-08-10');

INSERT INTO MEAL(MENU_ID, DESCRIPTION, PRICE)
VALUES (100012,'Fried Chicken',1075),
       (100012,'Fresh Salad',838),
       (100012,'Beer',100),
       (100013,'Big MAC',2580),
       (100013,'Fried potato',500),
       (100013,'Coca-Cola',35),
       (100014,'Pasta',1548),
       (100014,'Cheese plate',525),
       (100014,'Dry vine',150),
       (100015,'Soya Tikka',650),
       (100015,'Fresh Salad',550),
       (100015,'Vegetable Kebab',450),
       (100015,'Fresh Water',20),
       (100016,'Trout on charcoals',2035),
       (100016,'Fried Shrimps',800),
       (100016,'Sea food salad',1095),
       (100016,'White vine',150);

INSERT INTO ACTION(DATE, TIME, USER_ID, MENU_ID)
VALUES ('2020-08-10','10:48:00',100000,100014);

