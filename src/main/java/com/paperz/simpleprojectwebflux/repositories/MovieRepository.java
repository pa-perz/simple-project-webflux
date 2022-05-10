package com.paperz.simpleprojectwebflux.repositories;

import com.paperz.simpleprojectwebflux.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {}
