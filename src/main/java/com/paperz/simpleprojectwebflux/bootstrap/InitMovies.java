package com.paperz.simpleprojectwebflux.bootstrap;

import com.paperz.simpleprojectwebflux.domain.Movie;
import com.paperz.simpleprojectwebflux.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class InitMovies implements CommandLineRunner {
    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        movieRepository
                .deleteAll()
                .thenMany(
                        Flux.just(
                                        "El silencio de los corderos",
                                        "Alguien voló sobre el nido del cuco",
                                        "Uno de los nuestros",
                                        "El padrino")
                                .map(Movie::new)
                                .flatMap(movieRepository::save))
                .subscribe(
                        null, null, () -> movieRepository.findAll().subscribe(System.out::println));
    }
}
