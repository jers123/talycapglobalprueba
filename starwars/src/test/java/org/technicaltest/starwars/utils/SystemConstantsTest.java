package org.technicaltest.starwars.utils;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.technicaltest.starwars.models.Base;
import org.technicaltest.starwars.models.dto.FilmDTO;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.technicaltest.starwars.utils.SystemConstants.CONTENT_TYPE;
import static org.technicaltest.starwars.utils.SystemConstants.HTTP_STATUS;

class SystemConstantsTest {

    @Test
    void urlApi() {
        Integer id = 1;
        String url = "https://swapi.dev/api/films/" + id + "/";
        assertEquals(url, SystemConstants.urlApi(id));
    }

    @Test
    void answer() {
        HttpStatus status = HttpStatus.OK;
        FilmDTO filmDto = new FilmDTO();
        filmDto.setIdFilm(1);
        filmDto.setEpisode_id(4);
        filmDto.setTitle("A New Hope");
        filmDto.setRelease_date(new Date(1977,04,25));
        HTTP_STATUS = status;
        ResponseEntity<Base> response = ResponseEntity
                .status(status)
                .header(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(filmDto);

        assertEquals(response, SystemConstants.answer(filmDto));
    }
}