package org.technicaltest.starwars.utils;

import org.technicaltest.starwars.models.dto.FilmAPI;
import org.technicaltest.starwars.models.dto.FilmDTO;
import org.technicaltest.starwars.models.entities.Film;

import java.time.LocalDateTime;

public class Mapper {
    public Film create(FilmAPI filmAPI) {
        Film entity = new Film();
        entity.setEpisodeId(filmAPI.getEpisode_id());
        entity.setTitle(filmAPI.getTitle());
        entity.setReleaseDate(filmAPI.getRelease_date());
        return entity;
    }

    public FilmDTO read(Film entity) {
        FilmDTO entityDto = new FilmDTO();
        entityDto.setIdFilm(entity.getIdFilm());
        entityDto.setEpisode_id(entity.getEpisodeId());
        entityDto.setTitle(entity.getTitle());
        entityDto.setRelease_date(entity.getReleaseDate());
        return entityDto;
    }

    public Film update(FilmDTO entityDto, Film entity) {
        entity.setEpisodeId(entityDto.getEpisode_id());
        entity.setTitle(entityDto.getTitle());
        entity.setReleaseDate(entityDto.getRelease_date());
        return entity;
    }

    public Film updateAPI(FilmAPI filmAPI, Film entity) {
        entity.setEpisodeId(filmAPI.getEpisode_id());
        entity.setTitle(filmAPI.getTitle());
        entity.setReleaseDate(filmAPI.getRelease_date());
        return entity;
    }
}
