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

CREATE TABLE movies
(
    movieID       SERIAL NOT NULL PRIMARY KEY,
    nameRussian   varchar,
    nameNative    varchar,
    yearOfRelease integer,
    country       varchar,
    description   varchar,
    picturePath   varchar,
    rating        double precision,
    price         double precision

);

CREATE TABLE genres
(
    genreID SERIAL NOT NULL PRIMARY KEY,
    genre   varchar
);


CREATE TABLE MovieGenreRelation
(
    movieID integer NOT NULL,
    genreID integer NOT NULL,
    FOREIGN KEY (movieID) REFERENCES movies (movieID),
    FOREIGN KEY (genreID) REFERENCES genres (genreID),
    UNIQUE (movieID, genreID)
);



