package br.com.movieon.service;

import br.com.movieon.entity.Category;
import br.com.movieon.entity.Movie;
import br.com.movieon.entity.Streaming;
import br.com.movieon.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private StreamingService streamingService;

    public Movie save(Movie movie) {
        movie.setCategories(this.findCategories(movie.getCategories()));
        movie.setStreamings(this.findStreamings(movie.getStreamings()));
        return movieRepository.save(movie);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    public Optional<Movie> update(Long movieId, Movie updateMovie) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isPresent()) {
            List<Category> categories = this.findCategories(updateMovie.getCategories());
            List<Streaming> streamings = this.findStreamings(updateMovie.getStreamings());

            Movie oldMovie = optionalMovie.get();
            oldMovie.setTitle(updateMovie.getTitle());
            oldMovie.setDescription(updateMovie.getDescription());
            oldMovie.setReleaseDate(updateMovie.getReleaseDate());
            oldMovie.setRating(updateMovie.getRating());

            oldMovie.getCategories().clear();
            oldMovie.getCategories().addAll(categories);

            oldMovie.getStreamings().clear();
            oldMovie.getStreamings().addAll(streamings);

            movieRepository.save(oldMovie);
            return Optional.of(oldMovie);
        }
        return Optional.empty();
    }

    public List<Movie> findByCategory(Long categoryId) {
        return movieRepository.findMovieByCategories(List.of(Category.builder().id(categoryId).build()));
    }

    public List<Movie> findTop3() {
        return movieRepository.findTop3ByOrderByRatingDesc();
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }



    private List<Category> findCategories(List<Category> categories) {
        List<Category> categoriesFound = new ArrayList<>();
       categories.forEach(category ->
               categoryService.findById(category.getId()).ifPresent(categoriesFound::add));
       return categoriesFound;
    }

    private List<Streaming> findStreamings(List<Streaming> streamings) {
        List<Streaming> streamingsFound = new ArrayList<>();
        streamings.forEach(streaming ->
                streamingService.findById(streaming.getId()).ifPresent(streamingsFound::add));
        return streamingsFound;
    }

}
