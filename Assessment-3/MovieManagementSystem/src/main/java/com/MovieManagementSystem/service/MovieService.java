package com.MovieManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MovieManagementSystem.model.Movie;
import com.MovieManagementSystem.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	public void saveMovie(Movie movie) {
		repository.save(movie);
	}

	public List<Movie> getAllMovies() {
		return repository.findAll();
	}

	public Movie getMovieById(int id) {
		return repository.findById(id).orElse(null);
	}

	public void deleteMovie(int id) {
		repository.deleteById(id);
	}
}