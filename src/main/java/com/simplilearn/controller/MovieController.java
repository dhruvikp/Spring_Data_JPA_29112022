package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.entity.Movie;
import com.simplilearn.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@GetMapping("/movies")
	public List<Movie> getAllMovies() {
		return movieService.getMovies();
	}

	@DeleteMapping("/movies")
	public void deleteMovie(@RequestParam("id") int id) {
		movieService.delete(id);
	}

	@PostMapping("/movies")
	public int saveMove(@RequestBody Movie movie) {
		movieService.saveMovie(movie);
		return movie.getId();
	}

}
