DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS profiles_pics;
DROP TABLE IF EXISTS profiles_interests;
DROP TABLE IF EXISTS profiles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS countries;
DROP TABLE IF EXISTS cities;
DROP TABLE IF EXISTS goals;
DROP TABLE IF EXISTS alcohol_attitudes;
DROP TABLE IF EXISTS smoking_attitudes;
DROP TABLE IF EXISTS sport_attitudes;
DROP TABLE IF EXISTS pet_attitudes;
DROP TABLE IF EXISTS hobbies;

CREATE TABLE users
(
    id       INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name     VARCHAR(50) NOT NULL,
    age      DATE        NOT NULL,
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
    name_of_city VARCHAR(50) NOT NULL
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
    id               INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    users_id         INT REFERENCES users (id)             NOT NULL UNIQUE,
    height           INT,
    about            VARCHAR(500),
    zodiac_sign      INT REFERENCES zodiac_signs (id)      NOT NULL,
    location_country INT REFERENCES countries (id)         NOT NULL,
    location_city    INT REFERENCES cities (id)            NOT NULL,
    goal             INT REFERENCES goals (id)             NOT NULL,
    alcohol_attitude INT REFERENCES alcohol_attitudes (id) NOT NULL,
    smoking_attitude INT REFERENCES smoking_attitudes (id) NOT NULL,
    sport_attitude   INT REFERENCES sport_attitudes (id)   NOT NULL,
    pet_attitude     INT REFERENCES pet_attitudes (id)     NOT NULL
);
CREATE TABLE profiles_interests
(
    id         INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    profile_id INT REFERENCES profiles (id) NOT NULL,
    hobby_id   INT REFERENCES hobbies (id)  NOT NULL
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
    user_id INT REFERENCES users (id) NOT NULL,
    role_id INT REFERENCES roles (id) NOT NULL
);