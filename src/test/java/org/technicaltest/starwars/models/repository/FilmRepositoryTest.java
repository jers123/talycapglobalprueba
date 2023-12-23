package org.technicaltest.starwars.models.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.technicaltest.starwars.models.entities.Film;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class FilmRepositoryTest {

    @Autowired
    private FilmRepository repository;

    private Film film;

    @BeforeEach
    public void setup() {
        film = new Film();
        film.setEpisodeId(4);
        film.setTitle("A New Hope");
        film.setReleaseDate(new Date(1977,04,25));
    }

    @Test
    public void saveFilmTest() {
        Film filmSave = repository.save(film);

        assertThat(filmSave).isNotNull();
        assertThat(filmSave.getIdFilm()).isGreaterThan(0);
    }

    @Test
    public void findFilmByIdTest() {
        film = repository.save(film);
        Film filmSave = repository.findById(film.getIdFilm()).get();

        assertThat(filmSave).isNotNull();
    }

    @Test
    public void findFilmByEpisodeIdTest() {
        film = repository.save(film);
        Film filmSave = repository.searchByEpisode(film.getEpisodeId()).get();

        assertThat(filmSave).isNotNull();
    }

    @Test
    public void updateFilmTest() {
        film = repository.save(film);
        Film filmSave = repository.findById(film.getIdFilm()).get();
        filmSave.setTitle("New Episode");
        filmSave.setReleaseDate(new Date(2023,11,22));
        filmSave = repository.save(filmSave);

        assertThat(filmSave.getTitle()).isEqualTo("New Episode");
        assertThat(filmSave.getReleaseDate()).isEqualTo(new Date(2023,11,22));
    }

    @Test
    public void deleteFilmTest() {
        film = repository.save(film);
        repository.deleteById(film.getIdFilm());
        Optional<Film> filmDeleted = repository.findById(film.getIdFilm());

        assertThat(filmDeleted).isEmpty();
    }
}