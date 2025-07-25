package br.com.movieon.repository;

import br.com.movieon.entity.Category;
import br.com.movieon.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findMovieByCategories(List<Category> categories);

    List<Movie> findTop3ByOrderByRatingDesc();
}
