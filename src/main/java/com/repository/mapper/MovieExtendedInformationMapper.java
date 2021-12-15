package com.repository.mapper;

import com.entity.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class MovieExtendedInformationMapper implements RowMapper<MovieExtendedInformation> {
    private final Set<Country> countriesSet = new HashSet<>();
    private final Set<Genre> genresSet = new HashSet<>();
    private final Set<Review> reviewsSet = new HashSet<>();
    private MovieExtendedInformation movieExtendedInformation = new MovieExtendedInformation();

    @Override
    public MovieExtendedInformation mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        while (resultSet.next()) {
            countriesSet.add(Country.builder()
                    .id(resultSet.getLong("countryid"))
                    .name(resultSet.getString("countryname"))
                    .build());

            genresSet.add(Genre.builder()
                    .id(resultSet.getLong("genreid"))
                    .name(resultSet.getString("genre"))
                    .build());

            reviewsSet.add(Review.builder()
                    .id(resultSet.getLong("reviewid"))
                    .text(resultSet.getString("reviewtext"))
                    .user(User.builder()
                            .id(resultSet.getLong("userid"))
                            .nickname(resultSet.getString("userpersonaldetails"))
                            .build())
                    .build());

            movieExtendedInformation = MovieExtendedInformation.builder()
                    .id(resultSet.getLong("movieid"))
                    .nameRussian(resultSet.getString("namerussian"))
                    .nameNative(resultSet.getString("namenative"))
                    .yearOfRelease(resultSet.getInt("yearofrelease"))
                    .picturePath(resultSet.getString("picturepath"))
                    .description(resultSet.getString("description"))
                    .rating(resultSet.getDouble("rating"))
                    .price(resultSet.getDouble("price"))
                    .countries(countriesSet)
                    .genres(genresSet)
                    .reviews(reviewsSet)
                    .build();
        }
        return movieExtendedInformation;
    }
}
