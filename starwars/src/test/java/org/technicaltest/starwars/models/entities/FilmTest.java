package org.technicaltest.starwars.models.entities;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FilmTest {
        private static Film film;

        @BeforeClass
        public static void setUpTest() {
            film = new Film();
        }

        @Test
        public void FilmIdGetterTest() {
            Integer id = 1;
            film.setIdFilm(id);
            assertEquals(id, film.getIdFilm());
        }

        @Test
        public void FilmEpisodeIdGetterTest() {
            Integer episodeId = 4;
            film.setEpisodeId(episodeId);
            assertEquals(episodeId, film.getEpisodeId());
        }

        @Test
        public void FilmTitleGetterTest() {
            String title = "A New Hope";
            film.setTitle(title);
            assertEquals(title, film.getTitle());
        }

        @Test
        public void FilmReleaseDateGetterTest() {
            Date releaseDate = new Date(1977,04,25);
            film.setReleaseDate(releaseDate);
            assertEquals(releaseDate, film.getReleaseDate());
        }
}