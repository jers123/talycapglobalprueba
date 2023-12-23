package org.technicaltest.starwars.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.technicaltest.starwars.models.dto.FilmAPI;
import org.technicaltest.starwars.models.dto.FilmDTO;
import org.technicaltest.starwars.models.entities.Film;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapperTest {

    private Mapper mapper;

    @BeforeEach
    public void setup() {
        mapper = new Mapper();
    }

    @Test
    public void create() {
        FilmAPI filmApi = new FilmAPI();
        filmApi.setTitle("A New Hope");
        filmApi.setEpisode_id(4);
        filmApi.setOpening_crawl("It is a period of civil war.\r\nRebel spaceships, striking\r\nfrom a hidden base, have won\r\ntheir first victory against\r\nthe evil Galactic Empire.\r\n\r\nDuring the battle, Rebel\r\nspies managed to steal secret\r\nplans to the Empire's\r\nultimate weapon, the DEATH\r\nSTAR, an armored space\r\nstation with enough power\r\nto destroy an entire planet.\r\n\r\nPursued by the Empire's\r\nsinister agents, Princess\r\nLeia races home aboard her\r\nstarship, custodian of the\r\nstolen plans that can save her\r\npeople and restore\r\nfreedom to the galaxy....");
        filmApi.setDirector("George Lucas");
        filmApi.setProducer("Gary Kurtz, Rick McCallum");
        filmApi.setRelease_date(new Date(1977,04,25));
        List<String> characters = new ArrayList<>();
        characters.add("https://swapi.dev/api/people/1/");
        characters.add("https://swapi.dev/api/people/2/");
        characters.add("https://swapi.dev/api/people/3/");
        characters.add("https://swapi.dev/api/people/4/");
        characters.add("https://swapi.dev/api/people/5/");
        characters.add("https://swapi.dev/api/people/6/");
        characters.add("https://swapi.dev/api/people/7/");
        characters.add("https://swapi.dev/api/people/8/");
        characters.add("https://swapi.dev/api/people/9/");
        characters.add("https://swapi.dev/api/people/10/");
        characters.add("https://swapi.dev/api/people/12/");
        characters.add("https://swapi.dev/api/people/13/");
        characters.add("https://swapi.dev/api/people/14/");
        characters.add("https://swapi.dev/api/people/15/");
        characters.add("https://swapi.dev/api/people/16/");
        characters.add("https://swapi.dev/api/people/18/");
        characters.add("https://swapi.dev/api/people/19/");
        characters.add("https://swapi.dev/api/people/81/");
        filmApi.setCharacters(characters);
        List<String> planets = new ArrayList<>();
        planets.add("https://swapi.dev/api/planets/1/");
        planets.add("https://swapi.dev/api/planets/2/");
        planets.add("https://swapi.dev/api/planets/3/");
        filmApi.setPlanets(planets);
        List<String> starships = new ArrayList<>();
        starships.add("https://swapi.dev/api/starships/2/");
        starships.add("https://swapi.dev/api/starships/3/");
        starships.add("https://swapi.dev/api/starships/5/");
        starships.add("https://swapi.dev/api/starships/9/");
        starships.add("https://swapi.dev/api/starships/10/");
        starships.add("https://swapi.dev/api/starships/11/");
        starships.add("https://swapi.dev/api/starships/12/");
        starships.add("https://swapi.dev/api/starships/13/");
        filmApi.setStarships(starships);
        List<String> vehicles = new ArrayList<>();
        vehicles.add("https://swapi.dev/api/vehicles/4/");
        vehicles.add("https://swapi.dev/api/vehicles/6/");
        vehicles.add("https://swapi.dev/api/vehicles/7/");
        vehicles.add("https://swapi.dev/api/vehicles/8/");
        filmApi.setVehicles(vehicles);
        List<String> species = new ArrayList<>();
        species.add("https://swapi.dev/api/species/1/");
        species.add("https://swapi.dev/api/species/2/");
        species.add("https://swapi.dev/api/species/3/");
        species.add("https://swapi.dev/api/species/4/");
        species.add("https://swapi.dev/api/species/5/");
        filmApi.setSpecies(species);
        filmApi.setCreated(LocalDateTime.parse("2014-12-10T14:23:31"));
        filmApi.setEdited(LocalDateTime.parse("2014-12-20T19:49:45"));
        filmApi.setUrl("https://swapi.dev/api/films/1/");

        Film film = mapper.create(filmApi);

        assertEquals(filmApi.getEpisode_id(), film.getEpisodeId());
        assertEquals(filmApi.getTitle(), film.getTitle());
        assertEquals(filmApi.getRelease_date(), film.getReleaseDate());
    }

    @Test
    public void read() {
        Film film = new Film();
        film.setIdFilm(1);
        film.setEpisodeId(4);
        film.setTitle("A New Hope");
        film.setReleaseDate(new Date(1977,04,25));

        FilmDTO filmDto = mapper.read(film);

        assertEquals(film.getIdFilm(), filmDto.getIdFilm());
        assertEquals(film.getEpisodeId(), filmDto.getEpisode_id());
        assertEquals(film.getTitle(), filmDto.getTitle());
        assertEquals(film.getReleaseDate(), filmDto.getRelease_date());
    }

    @Test
    public void update() {
        Film film = new Film();
        film.setIdFilm(1);
        film.setEpisodeId(4);
        film.setTitle("A New Hope");
        film.setReleaseDate(new Date(1977,04,25));

        FilmDTO filmDto = new FilmDTO();
        filmDto.setIdFilm(1);
        filmDto.setEpisode_id(8);
        filmDto.setTitle("New Episode");
        filmDto.setRelease_date(new Date(2023,11,22));

        Film filmUpdate = mapper.update(filmDto, film);

        assertEquals(filmUpdate.getIdFilm(), film.getIdFilm());
        assertEquals(filmUpdate.getEpisodeId(), filmDto.getEpisode_id());
        assertEquals(filmUpdate.getTitle(), filmDto.getTitle());
        assertEquals(filmUpdate.getReleaseDate(), filmDto.getRelease_date());
    }

    @Test
    public void updateAPI() {
        FilmAPI filmApi = new FilmAPI();
        filmApi.setTitle("A New Hope");
        filmApi.setEpisode_id(4);
        filmApi.setOpening_crawl("It is a period of civil war.\r\nRebel spaceships, striking\r\nfrom a hidden base, have won\r\ntheir first victory against\r\nthe evil Galactic Empire.\r\n\r\nDuring the battle, Rebel\r\nspies managed to steal secret\r\nplans to the Empire's\r\nultimate weapon, the DEATH\r\nSTAR, an armored space\r\nstation with enough power\r\nto destroy an entire planet.\r\n\r\nPursued by the Empire's\r\nsinister agents, Princess\r\nLeia races home aboard her\r\nstarship, custodian of the\r\nstolen plans that can save her\r\npeople and restore\r\nfreedom to the galaxy....");
        filmApi.setDirector("George Lucas");
        filmApi.setProducer("Gary Kurtz, Rick McCallum");
        filmApi.setRelease_date(new Date(1977,04,25));
        List<String> characters = new ArrayList<>();
        characters.add("https://swapi.dev/api/people/1/");
        characters.add("https://swapi.dev/api/people/2/");
        characters.add("https://swapi.dev/api/people/3/");
        characters.add("https://swapi.dev/api/people/4/");
        characters.add("https://swapi.dev/api/people/5/");
        characters.add("https://swapi.dev/api/people/6/");
        characters.add("https://swapi.dev/api/people/7/");
        characters.add("https://swapi.dev/api/people/8/");
        characters.add("https://swapi.dev/api/people/9/");
        characters.add("https://swapi.dev/api/people/10/");
        characters.add("https://swapi.dev/api/people/12/");
        characters.add("https://swapi.dev/api/people/13/");
        characters.add("https://swapi.dev/api/people/14/");
        characters.add("https://swapi.dev/api/people/15/");
        characters.add("https://swapi.dev/api/people/16/");
        characters.add("https://swapi.dev/api/people/18/");
        characters.add("https://swapi.dev/api/people/19/");
        characters.add("https://swapi.dev/api/people/81/");
        filmApi.setCharacters(characters);
        List<String> planets = new ArrayList<>();
        planets.add("https://swapi.dev/api/planets/1/");
        planets.add("https://swapi.dev/api/planets/2/");
        planets.add("https://swapi.dev/api/planets/3/");
        filmApi.setPlanets(planets);
        List<String> starships = new ArrayList<>();
        starships.add("https://swapi.dev/api/starships/2/");
        starships.add("https://swapi.dev/api/starships/3/");
        starships.add("https://swapi.dev/api/starships/5/");
        starships.add("https://swapi.dev/api/starships/9/");
        starships.add("https://swapi.dev/api/starships/10/");
        starships.add("https://swapi.dev/api/starships/11/");
        starships.add("https://swapi.dev/api/starships/12/");
        starships.add("https://swapi.dev/api/starships/13/");
        filmApi.setStarships(starships);
        List<String> vehicles = new ArrayList<>();
        vehicles.add("https://swapi.dev/api/vehicles/4/");
        vehicles.add("https://swapi.dev/api/vehicles/6/");
        vehicles.add("https://swapi.dev/api/vehicles/7/");
        vehicles.add("https://swapi.dev/api/vehicles/8/");
        filmApi.setVehicles(vehicles);
        List<String> species = new ArrayList<>();
        species.add("https://swapi.dev/api/species/1/");
        species.add("https://swapi.dev/api/species/2/");
        species.add("https://swapi.dev/api/species/3/");
        species.add("https://swapi.dev/api/species/4/");
        species.add("https://swapi.dev/api/species/5/");
        filmApi.setSpecies(species);
        filmApi.setCreated(LocalDateTime.parse("2014-12-10T14:23:31"));
        filmApi.setEdited(LocalDateTime.parse("2014-12-20T19:49:45"));
        filmApi.setUrl("https://swapi.dev/api/films/1/");

        Film film = new Film();
        film.setIdFilm(1);
        film.setEpisodeId(8);
        film.setTitle("New Episode");
        film.setReleaseDate(new Date(2023,11,22));

        Film filmUpdate = mapper.updateAPI(filmApi, film);

        assertEquals(filmUpdate.getIdFilm(), film.getIdFilm());
        assertEquals(filmUpdate.getEpisodeId(), filmApi.getEpisode_id());
        assertEquals(filmUpdate.getTitle(), filmApi.getTitle());
        assertEquals(filmUpdate.getReleaseDate(), filmApi.getRelease_date());
    }
}