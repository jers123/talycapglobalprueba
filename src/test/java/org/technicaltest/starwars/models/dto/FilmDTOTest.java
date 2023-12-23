package org.technicaltest.starwars.models.dto;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FilmDTOTest {
    private static FilmDTO filmDto;

    @BeforeClass
    public static void setUpTest() {
        filmDto = new FilmDTO();
    }

    @Test
    public void FilmDTOIdGetterTest() {
        Integer id = 1;
        filmDto.setIdFilm(id);
        assertEquals(id, filmDto.getIdFilm());
    }

    @Test
    public void FilmDTOEpisodeIdGetterTest() {
        Integer episodeId = 4;
        filmDto.setEpisode_id(episodeId);
        assertEquals(episodeId, filmDto.getEpisode_id());
    }

    @Test
    public void FilmDTOTitleGetterTest() {
        String title = "A New Hope";
        filmDto.setTitle(title);
        assertEquals(title, filmDto.getTitle());
    }

    @Test
    public void FilmDTOReleaseDateGetterTest() {
        Date releaseDate = new Date(1977,04,25);
        filmDto.setRelease_date(releaseDate);
        assertEquals(releaseDate, filmDto.getRelease_date());
    }
}
