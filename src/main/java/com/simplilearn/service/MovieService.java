package com.simplilearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Movie;
import com.simplilearn.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;

	public List<Movie> getMovies() {
		List<Movie> movies = new ArrayList<Movie>();
		movieRepository.findAll().forEach(movie -> movies.add(movie));
		return movies;
	}
	
	/*public List<Movie> updateMovie(Movie movie) {
		Movie movie1 = movieRepository.findById(movie.getId());
		movie1.setGenre(movie.getGenre());
		movie1.setName(movie.getName());
		movieRepository.save(movie1);
	}*/

	public void saveMovie(Movie movie) {
		movieRepository.save(movie);
	}
	
	public void delete(int id) {
		movieRepository.deleteById(id);
	}

}
