package com.MovieManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.MovieManagementSystem.model.Movie;
import com.MovieManagementSystem.service.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService service;

	@GetMapping
	public String viewMovies(Model model) {
		model.addAttribute("movies", service.getAllMovies());
		return "movie-list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("movie", new Movie());
		return "add-movie";
	}

	@PostMapping("/save")
	public String saveMovie(@ModelAttribute Movie movie) {
		service.saveMovie(movie);
		return "redirect:/movies";
	}

	@GetMapping("/edit/{id}")
	public String editMovie(@PathVariable int id, Model model) {
		model.addAttribute("movie", service.getMovieById(id));
		return "edit-movie";
	}

	@GetMapping("/delete/{id}")
	public String deleteMovie(@PathVariable int id) {
		service.deleteMovie(id);
		return "redirect:/movies";
	}
}
