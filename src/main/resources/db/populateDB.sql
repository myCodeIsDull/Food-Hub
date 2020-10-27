DELETE
FROM user_roles;
DELETE
FROM users;
DELETE
FROM meal;
DELETE
FROM restaurants;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001),
       ('USER', 100001);

INSERT INTO RESTAURANTS(NAME, REGISTERED, CITY, STREET, HOUSE, PHONE)
VALUES ('Crown Fried Chicken', '2018-12-03', 'Springfield', 'Main St', '20', '555-35-35'),
       ('McDonalds', '2017-08-11', 'Springfield', 'Maple St', '5', '333-40-51'),
       ('Venice', '2020-03-25', 'Springfield', 'High St', '13', '348-88-13'),
       ('Tap And Tandoor', '2020-05-09', 'Springfield', 'Park St', '3', '315-43-12'),
       ('Seafood Heaven', '2019-04-08', 'Springfield', 'Union St', '22', '733-90-11');

INSERT INTO MEAL(REST_ID, TITLE, PRICE, PUBLISHED)
VALUES (100002, 'Fried Chicken', 1075, '2020-08-10'),
       (100002, 'Fresh Salad', 838, '2020-08-10'),
       (100002, 'Beer', 100, '2020-08-10'),
       (100003, 'Big MAC', 2580, '2020-08-10'),
       (100003, 'Fried potato', 500, '2020-08-10'),
       (100003, 'Coca-Cola', 35, '2020-08-10'),
       (100004, 'Pasta', 1548, '2020-08-10'),
       (100004, 'Cheese plate', 525, '2020-08-10'),
       (100004, 'Dry vine', 150, '2020-08-10'),
       (100005, 'Soya Tikka', 650, '2020-08-10'),
       (100005, 'Fresh Salad', 550, '2020-08-10'),
       (100005, 'Vegetable Kebab', 450, '2020-08-10'),
       (100005, 'Fresh Water', 20, '2020-08-10'),
       (100006, 'Trout on charcoals', 2035, '2020-08-10'),
       (100006, 'Fried Shrimps', 800, '2020-08-10'),
       (100006, 'Sea food salad', 1095, '2020-08-10'),
       (100006, 'White vine', 150, '2020-08-10');
