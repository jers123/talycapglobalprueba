package org.technicaltest.starwars.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.technicaltest.starwars.models.Base;

public class SystemConstants {
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String LOCAL_ORIGIN_PATH = "http://localhost:8080";
    public static final String STARWARS_PATH = "/starwars";

    public static final String ERROR = "error en la solicitud";
    public static final Integer MAXIMUM = 99;
    public static final String FILM_EPISODE_QUERY = "SELECT f FROM Film f WHERE f.episodeId = :episode";


    public static HttpStatus HTTP_STATUS;

    public static String urlApi(Integer id) {
        return "https://swapi.dev/api/films/" + id + "/";
    }

    public static ResponseEntity<Base> answer(Base response) {
        return ResponseEntity
                .status(HTTP_STATUS)
                .header(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(response);
    }

}