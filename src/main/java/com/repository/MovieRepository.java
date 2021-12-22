package com.repository;

import com.dto.MovieDto;
import com.entity.Movie;
import com.entity.SortMethod;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT * FROM movies ORDER BY random() LIMIT :count", nativeQuery = true)
    List<Movie> getRandomMovies(@Param("count") int count);

    @Query("SELECT new com.dto.MovieDto(m.id, m.nameRussian, m.nameNative, m.yearOfRelease,  m.rating, m.price, m.picturePath) FROM Movie m " +
            "left join m.genres g WHERE g.id = :genreID")
    List<MovieDto> getMoviesByGenreId(@Param("genreID") Long genreID);

    @Query("SELECT new com.dto.MovieDto(m.id, m.nameRussian, m.nameNative, m.yearOfRelease,  m.rating, m.price, m.picturePath) FROM Movie m")
    List<MovieDto> getAllMovies();

    @Query("SELECT new com.dto.MovieDto(m.id, m.nameRussian, m.nameNative, m.yearOfRelease,  m.rating, m.price, m.picturePath) FROM Movie m")
    List<MovieDto> getAllMoviesSorted(Sort sort);

    @Query("SELECT new com.dto.MovieDto(m.id, m.nameRussian, m.nameNative, m.yearOfRelease,  m.rating, m.price, m.picturePath) FROM Movie m " +
            "left join m.genres g WHERE g.id = :genreID")
    List<MovieDto> getMoviesByGenreIdSorted(@Param("genreID") Long genreID, Sort sort);
}
