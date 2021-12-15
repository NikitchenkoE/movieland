CREATE TABLE users
(
    userID              SERIAL NOT NULL PRIMARY KEY,
    userPersonalDetails varchar,
    email               varchar UNIQUE,
    password            varchar
);


CREATE TABLE movies
(
    movieID       SERIAL NOT NULL PRIMARY KEY,
    nameRussian   varchar,
    nameNative    varchar,
    yearOfRelease integer,
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

CREATE TABLE reviews
(
    reviewID   SERIAL NOT NULL PRIMARY KEY,
    reviewText varchar,
    userID     int,
    movieID    int,
    CONSTRAINT fk_userId FOREIGN KEY (userID) REFERENCES users (userID),
    CONSTRAINT fk_movieId FOREIGN KEY (movieID) REFERENCES movies (movieID)
);

CREATE TABLE "countries"
(
    countryID   SERIAL NOT NULL PRIMARY KEY,
    countryName varchar
);


CREATE TABLE movieGenreRelation
(
    movieID integer NOT NULL,
    genreID integer NOT NULL,
    FOREIGN KEY (movieID) REFERENCES movies (movieID),
    FOREIGN KEY (genreID) REFERENCES genres (genreID),
    UNIQUE (movieID, genreID)
);

CREATE TABLE movieCountryRelation
(
    movieID integer NOT NULL,
    countryID integer NOT NULL,
    FOREIGN KEY (movieID) REFERENCES movies (movieID),
    FOREIGN KEY (countryID) REFERENCES countries (countryID),
    UNIQUE (movieID, countryID)
);




