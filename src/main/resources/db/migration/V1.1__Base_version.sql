CREATE TABLE users
(
    userID              SERIAL NOT NULL PRIMARY KEY,
    userPersonalDetails varchar,
    email               varchar UNIQUE,
    password            varchar
);

CREATE TABLE reviews
(
    reviewID            SERIAL NOT NULL PRIMARY KEY,
    movieTitle          varchar,
    userPersonalDetails varchar,
    reviewText          varchar
);

CREATE TABLE posters
(
    posterID            SERIAL NOT NULL PRIMARY KEY,
    movieTitleInRussian varchar,
    imagePath           varchar
);

CREATE TABLE movies
(
    movieID       SERIAL NOT NULL PRIMARY KEY,
    nameRussian   varchar,
    nameNative    varchar,
    yearOfRelease integer,
    country       varchar,
    genres        varchar[],
    description   varchar,
    picturePath   varchar,
    rating        double precision,
    price         double precision

);

CREATE TABLE genres
(
    posterID SERIAL NOT NULL PRIMARY KEY,
    genre    varchar
);




