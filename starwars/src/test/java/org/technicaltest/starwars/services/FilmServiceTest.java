package org.technicaltest.starwars.services;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.technicaltest.starwars.models.Base;
import org.technicaltest.starwars.models.dto.FilmDTO;
import org.technicaltest.starwars.models.entities.Film;
import org.technicaltest.starwars.models.repository.FilmRepository;
import org.technicaltest.starwars.utils.Mapper;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class FilmServiceTest {

    @Mock
    private FilmRepository repository;

    @InjectMocks
    private FilmService service;

    private Film film;

    @BeforeEach
    public void setup() {
        film = new Film();
        film.setEpisodeId(4);
        film.setTitle("A New Hope");
        film.setReleaseDate(new Date(1977,04,25));
    }

    @Test
    public void consumeAPI() {
        /*String filmJson = "{\n" +
                "    \"idFilm\": 1,\n" +
                "    \"episode_id\": 44,\n" +
                "    \"title\": \"A New Hope\",\n" +
                "    \"release_date\": \"1977-05-25\"\n" +
                "}";
        Gson gson = new Gson();
        FilmDTO filmDto = gson.fromJson(filmJson, FilmDTO.class);
        FilmRepository repository = Mockito.mock(FilmRepository.class);

        given(repository.searchByEpisode(film.getEpisodeId())).willReturn(Optional.empty());
        given(repository.save(film)).willReturn(film);
        Film filmSave = repository.save(film);
        assertThat(filmSave).isNotNull();


        Mockito.when(repository.searchByEpisode(4)).thenReturn(film);
        FilmService service = new FilmService();
        assertEquals(service.consumeAPI(1), filmDto);*/
    }

    @Test
    public void update() {
        given(repository.save(film)).willReturn(film);
        film = repository.save(film);
        assertThat(film).isNotNull();
        assertThat(film.getIdFilm()).isGreaterThan(0);

        film.setTitle("New Episode");
        film.setReleaseDate(new Date(2023,11,22));
        film = repository.save(film);
        Mapper mapper = new Mapper();
        System.out.println(film.getIdFilm());
        Base filmDto = service.update(mapper.read(film));
        System.out.println(filmDto.toString());

        assertThat(filmDto.getClass()).isEqualTo(FilmDTO.class);
        FilmDTO filmTemp = (FilmDTO)filmDto;

        assertThat(filmTemp.getTitle()).isEqualTo(film.getTitle());
        assertThat(filmTemp.getRelease_date()).isEqualTo(film.getReleaseDate());
    }

    @Test
    public void delete() {

    }
}