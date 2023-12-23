package org.technicaltest.starwars.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.technicaltest.starwars.errors.ErrorAPI;
import org.technicaltest.starwars.models.Base;
import org.technicaltest.starwars.models.dto.FilmAPI;
import org.technicaltest.starwars.models.dto.FilmDTO;
import org.technicaltest.starwars.models.entities.Film;
import org.technicaltest.starwars.models.repository.FilmRepository;
import org.technicaltest.starwars.utils.Mapper;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.technicaltest.starwars.utils.SystemConstants.ERROR;
import static org.technicaltest.starwars.utils.SystemConstants.HTTP_STATUS;
import static org.technicaltest.starwars.utils.SystemConstants.MAXIMUM;
import static org.technicaltest.starwars.utils.SystemConstants.urlApi;

@Service
@Validated
public class FilmService {

    @Autowired
    private FilmRepository repository;

    @Autowired
    private Mapper mapper;

    /*@Autowired
    private Error error;*/

    /*public FilmService(FilmRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }*/

    @Transactional
    public Base consumeAPI(Integer id) {
        if(id > MAXIMUM) {
            HTTP_STATUS = HttpStatus.BAD_REQUEST;
            return new ErrorAPI(ERROR);
        } else {
            try {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<FilmAPI> filmAPI = restTemplate.exchange(
                        urlApi(id),
                        HttpMethod.GET,
                        new HttpEntity<>(httpHeaders),
                        FilmAPI.class
                );
                Optional<Film> film = repository.searchByEpisode(filmAPI.getBody().getEpisode_id());
                Film entity = new Film();
                if(!film.isPresent()) {
                    entity = mapper.create(filmAPI.getBody());
                } else {
                    entity = mapper.updateAPI(filmAPI.getBody(), film.get());
                }
                FilmDTO entityDto = mapper.read(repository.save(entity));
                HTTP_STATUS = HttpStatus.OK;
                return entityDto;
            } catch (HttpClientErrorException e) {
                HTTP_STATUS = HttpStatus.NO_CONTENT;
                return new ErrorAPI(ERROR);
            }
        }
    }

    @Transactional
    public Base update(FilmDTO entityDto) {
        try {
            Film entity = repository.findById(entityDto.getIdFilm()).orElse(null);
            if(entity != null) {
                Optional<Film> film = repository.searchByEpisode(entityDto.getEpisode_id());
                if(!film.isPresent()) {
                    entity = mapper.update(entityDto, entity);
                    entityDto = mapper.read(repository.save(entity));
                    HTTP_STATUS = HttpStatus.OK;
                    return entityDto;
                } else {
                    HTTP_STATUS = HttpStatus.BAD_REQUEST;
                    return new ErrorAPI("El episodio " + entityDto.getEpisode_id() + " ya existe");
                }
            } else {
                HTTP_STATUS = HttpStatus.NOT_FOUND;
                return new ErrorAPI("No se encuentro el film con id " + entityDto.getIdFilm());
            }
        } catch (Exception e) {
            HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ErrorAPI(e.getMessage());
        }
    }

    @Transactional
    public Base delete(Integer id) {
        try {
            Film entity = repository.findById(id).orElse(null);
            if(entity != null) {
                repository.delete(entity);
                HTTP_STATUS = HttpStatus.NO_CONTENT;
                return new ErrorAPI("liminado correctamente");
            } else {
                HTTP_STATUS = HttpStatus.NOT_FOUND;
                return new ErrorAPI("No se encuentra el film con id " + id);
            }
        } catch (Exception e) {
            HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ErrorAPI(e.getMessage());
        }
    }
}