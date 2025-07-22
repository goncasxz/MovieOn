package br.com.movieon.controller;

import br.com.movieon.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieon/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;
}
