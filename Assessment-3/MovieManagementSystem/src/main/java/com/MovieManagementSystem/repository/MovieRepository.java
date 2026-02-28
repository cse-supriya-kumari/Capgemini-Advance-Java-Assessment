package com.MovieManagementSystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MovieManagementSystem.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}