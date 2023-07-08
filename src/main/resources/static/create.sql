DROP TABLE IF EXISTS mutual_likes;
DROP TABLE IF EXISTS users_likes;
DROP TABLE IF EXISTS preferences;
DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS profiles_pics;
DROP TABLE IF EXISTS profiles_hobbies;
DROP TABLE IF EXISTS profiles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS cities;
DROP TABLE IF EXISTS countries;
DROP TABLE IF EXISTS goals;
DROP TABLE IF EXISTS zodiac_signs;
DROP TABLE IF EXISTS alcohol_attitudes;
DROP TABLE IF EXISTS smoking_attitudes;
DROP TABLE IF EXISTS sport_attitudes;
DROP TABLE IF EXISTS pet_attitudes;
DROP TABLE IF EXISTS hobbies;

CREATE TABLE users
(
    id       INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name     VARCHAR(50) NOT NULL,
    age      INT         NOT NULL,
    email    VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);
CREATE TABLE roles
(
    id           INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name_of_role VARCHAR(50) NOT NULL
);
CREATE TABLE zodiac_signs
(
    id                  INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name_of_zodiac_sign VARCHAR(50) NOT NULL
);
CREATE TABLE countries
(
    id              INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name_of_country VARCHAR(50) NOT NULL
);
CREATE TABLE cities
(
    id           INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    country_id   INT REFERENCES countries (id) NOT NULL,
    name_of_city VARCHAR(50)                   NOT NULL
);
CREATE TABLE goals
(
    id           INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name_of_goal VARCHAR(50) NOT NULL
);
CREATE TABLE alcohol_attitudes
(
    id                       INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name_of_alcohol_attitude VARCHAR(50) NOT NULL
);
CREATE TABLE smoking_attitudes
(
    id                       INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name_of_smoking_attitude VARCHAR(50) NOT NULL
);
CREATE TABLE sport_attitudes
(
    id                     INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name_of_sport_attitude VARCHAR(50) NOT NULL
);
CREATE TABLE pet_attitudes
(
    id                   INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name_of_pet_attitude VARCHAR(50) NOT NULL
);
CREATE TABLE hobbies
(
    id            INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name_of_hobby VARCHAR(50) NOT NULL
);
CREATE TABLE profiles
(
    id                  INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    user_id             INT REFERENCES users (id)             NOT NULL UNIQUE,
    gender              VARCHAR(10),
    height              INT,
    about               VARCHAR(500),
    zodiac_sign_id      INT REFERENCES zodiac_signs (id)      NOT NULL,
    location_country_id INT REFERENCES countries (id)         NOT NULL,
    location_city_id    INT REFERENCES cities (id)            NOT NULL,
    goal_id             INT REFERENCES goals (id)             NOT NULL,
    alcohol_attitude_id INT REFERENCES alcohol_attitudes (id) NOT NULL,
    smoking_attitude_id INT REFERENCES smoking_attitudes (id) NOT NULL,
    sport_attitude_id   INT REFERENCES sport_attitudes (id)   NOT NULL,
    pet_attitude_id     INT REFERENCES pet_attitudes (id)     NOT NULL
);
CREATE TABLE profiles_hobbies
(
    id         INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    profile_id INT REFERENCES profiles (id) NOT NULL,
    hobby_id   INT REFERENCES hobbies (id)  NOT NULL
);
CREATE TABLE preferences
(
    id          INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    user_id     INT REFERENCES users (id) NOT NULL UNIQUE,
    min_age_gap INT                       NOT NULL,
    max_age_gap INT                       NOT NULL
);
CREATE TABLE profiles_pics
(
    id         INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    profile_id INT REFERENCES profiles (id) NOT NULL,
    picture    BYTEA                        NOT NULL
);
CREATE TABLE users_roles
(
    id      INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    user_id INT REFERENCES users (id) NOT NULL UNIQUE,
    role_id INT REFERENCES roles (id) NOT NULL
);
CREATE TABLE users_likes
(
    id                    INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    like_provider_user_id INT REFERENCES users (id) NOT NULL,
    like_receiver_user_id INT REFERENCES users (id) NOT NULL
);
CREATE TABLE mutual_likes
(
    id             INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    first_user_id  INT REFERENCES users (id) NOT NULL,
    second_user_id INT REFERENCES users (id) NOT NULL
);

-- Insert sample data into the users table

INSERT INTO users (name, age, email, password)
VALUES ('Джон Доу', 25, 'john.doe@example.com', 'password123'),
       ('Джейн Смит', 30, 'jane.smith@example.com', 'pass456'),
       ('Майкл Джонсон', 28, 'michael.johnson@example.com', 'secure789'),
       ('Майкл Сторен', 20, 'michael.storen@example.com', '12345'),
       ('Алиса Вулф', 19, 'alice.wolf@example.com', '123456'),
       ('Бритни Спирс', 24, 'britney.spears@example.com', '54321'),
       ('Кейт Денсон', 18, 'kate.denson@example.com', 'password'),
       ('Микаэла Рид', 21, 'michaela.reid@example.com', 'password123'),
       ('Анжела Уайт', 23, 'angela.white<3@example.com', 'qwerty'),
       ('Люсиль Хортон', 25, 'lucille.horton@example.com', 'ytrewq');

INSERT INTO roles (name_of_role)
VALUES ('Admin'),
       ('User');

INSERT INTO zodiac_signs (name_of_zodiac_sign)
VALUES ('Овен'),
       ('Телец'),
       ('Близнецы'),
       ('Рак'),
       ('Лев'),
       ('Дева'),
       ('Весы'),
       ('Скорпион'),
       ('Стрелец'),
       ('Козерог'),
       ('Водолей'),
       ('Рыбы');

INSERT INTO countries (name_of_country)
VALUES ('Соединенные Штаты'),
       ('Канада'),
       ('Великобритания'),
       ('Россия'),
       ('Беларусь'),
       ('Германия'),
       ('Франция'),
       ('Австралия');

INSERT INTO cities (country_id, name_of_city)
VALUES (1, 'Нью-Йорк'),
       (1, 'Лос-Анджелес'),
       (2, 'Торонто'),
       (4, 'Москва'),
       (4, 'Санкт-Петербург'),
       (5, 'Минск'),
       (5, 'Брест'),
       (5, 'Гродно'),
       (5, 'Гомель'),
       (5, 'Могилев'),
       (5, 'Витебск'),
       (6, 'Мюнхен'),
       (6, 'Берлин'),
       (6, 'Гамбург'),
       (6, 'Франкфурт-на-майне'),
       (7, 'Париж'),
       (7, 'Марсель'),
       (7, 'Нант'),
       (7, 'Ницца'),
       (3, 'Эдинбург'),
       (3, 'Ливерпуль'),
       (3, 'Манчестер'),
       (3, 'Лондон');

INSERT INTO goals (name_of_goal)
VALUES ('Карьерный рост'),
       ('Путешествия по всему миру'),
       ('Найти партнера жизни');

INSERT INTO alcohol_attitudes (name_of_alcohol_attitude)
VALUES ('Непьющий'),
       ('Социальный пьющий'),
       ('Иногда пьющий');

INSERT INTO smoking_attitudes (name_of_smoking_attitude)
VALUES ('Некурящий'),
       ('Иногда курящий'),
       ('Регулярно курящий');

INSERT INTO sport_attitudes (name_of_sport_attitude)
VALUES ('Активный'),
       ('Умеренно активный'),
       ('Не интересуюсь');

INSERT INTO pet_attitudes (name_of_pet_attitude)
VALUES ('Люблю животных'),
       ('Безразличен к животным'),
       ('Аллергичен на животных');

INSERT INTO hobbies (name_of_hobby)
VALUES ('Чтение'),
       ('Пеший туризм'),
       ('Фотография'),
       ('Музыка'),
       ('Кино'),
       ('Прогулки'),
       ('Кофе'),
       ('Готовка');

INSERT INTO profiles (user_id,
                      gender,
                      height,
                      about,
                      zodiac_sign_id,
                      location_country_id,
                      location_city_id,
                      goal_id,
                      alcohol_attitude_id,
                      smoking_attitude_id,
                      sport_attitude_id,
                      pet_attitude_id)
VALUES (1, 'Male', 180, 'Обожаю исследовать новое.', 1, 1, 1, 1, 2, 1, 1, 1),
       (2, 'Female', 165, 'Энтузиаст природы и авантюрист.', 3, 3, 4, 2, 1, 2, 2, 2),
       (3, 'Male', 175, 'Страстно увлечен технологиями и спортом.', 5, 1, 1, 3, 3, 3, 3, 3),
       (4, 'Male', 175, 'Страстно увлечен автомобилями.', 5, 1, 1, 3, 3, 3, 3, 3),
       (5, 'Female', 170, 'Люблю природу.', 5, 1, 2, 3, 3, 3, 3, 3),
       (6, 'Female', 165, 'Обожаю музыку.', 5, 1, 2, 3, 3, 3, 3, 3),
       (7, 'Female', 168, 'Звезда кантри-музыки.', 5, 1, 1, 3, 3, 3, 3, 3),
       (8, 'Female', 172, 'Профессиональный фокусник.', 5, 1, 1, 3, 3, 3, 3, 3),
       (9, 'Female', 160, 'Звезда кино <3.', 5, 1, 2, 3, 3, 3, 3, 3),
       (10, 'Female', 167, 'Защищу вас в суде.', 5, 1, 2, 3, 3, 3, 3, 3);

INSERT INTO profiles_hobbies (profile_id, hobby_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (2, 3),
       (3, 1),
       (3, 4),
       (4, 8),
       (4, 6),
       (5, 5),
       (5, 6),
       (6, 8),
       (6, 2),
       (7, 3),
       (7, 5),
       (8, 1),
       (8, 5),
       (9, 2),
       (9, 7),
       (10, 7),
       (10, 3);

INSERT INTO preferences (user_id, min_age_gap, max_age_gap)
VALUES (1, 18, 30),
       (2, 18, 30),
       (3, 18, 30),
       (4, 18, 30),
       (5, 18, 30),
       (6, 18, 30),
       (7, 18, 30),
       (8, 18, 30),
       (9, 18, 30),
       (10, 18, 30);

CREATE INDEX age_index ON users(age);