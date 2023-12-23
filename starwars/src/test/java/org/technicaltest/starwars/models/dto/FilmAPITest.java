package org.technicaltest.starwars.models.dto;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FilmAPITest {
    private static FilmAPI filmApi;

    @BeforeClass
    public static void setUpTest() {
        filmApi = new FilmAPI();
    }

    @Test
    public void FilmAPITitleGetterTest() {
        String title = "A New Hope";
        filmApi.setTitle(title);
        assertEquals(title, filmApi.getTitle());
    }

    @Test
    public void FilmAPIEpisodeIdGetterTest() {
        Integer episodeId = 4;
        filmApi.setEpisode_id(episodeId);
        assertEquals(episodeId, filmApi.getEpisode_id());
    }

    @Test
    public void FilmAPIOpening_crawlGetterTest() {
        String opening_crawl = "It is a period of civil war.\r\nRebel spaceships, striking\r\nfrom a hidden base, have won\r\ntheir first victory against\r\nthe evil Galactic Empire.\r\n\r\nDuring the battle, Rebel\r\nspies managed to steal secret\r\nplans to the Empire's\r\nultimate weapon, the DEATH\r\nSTAR, an armored space\r\nstation with enough power\r\nto destroy an entire planet.\r\n\r\nPursued by the Empire's\r\nsinister agents, Princess\r\nLeia races home aboard her\r\nstarship, custodian of the\r\nstolen plans that can save her\r\npeople and restore\r\nfreedom to the galaxy....";
        filmApi.setOpening_crawl(opening_crawl);
        assertEquals(opening_crawl, filmApi.getOpening_crawl());
    }

    @Test
    public void FilmAPIDirectorGetterTest() {
        String director = "George Lucas";
        filmApi.setDirector(director);
        assertEquals(director, filmApi.getDirector());
    }

    @Test
    public void FilmAPIProducerGetterTest() {
        String producer = "Gary Kurtz, Rick McCallum";
        filmApi.setProducer(producer);
        assertEquals(producer, filmApi.getProducer());
    }

    @Test
    public void FilmAPIReleaseDateGetterTest() {
        Date releaseDate = new Date(1977,04,25);
        filmApi.setRelease_date(releaseDate);
        assertEquals(releaseDate, filmApi.getRelease_date());
    }

    @Test
    public void FilmAPICharactersGetterTest() {
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
        assertEquals(characters, filmApi.getCharacters());
    }

    @Test
    public void FilmAPIPlanetsGetterTest() {
        List<String> planets = new ArrayList<>();
        planets.add("https://swapi.dev/api/planets/1/");
        planets.add("https://swapi.dev/api/planets/2/");
        planets.add("https://swapi.dev/api/planets/3/");
        filmApi.setPlanets(planets);
        assertEquals(planets, filmApi.getPlanets());
    }

    @Test
    public void FilmAPIStarshipsGetterTest() {
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
        assertEquals(starships, filmApi.getStarships());
    }

    @Test
    public void FilmAPIVehiclesGetterTest() {
        List<String> vehicles = new ArrayList<>();
        vehicles.add("https://swapi.dev/api/vehicles/4/");
        vehicles.add("https://swapi.dev/api/vehicles/6/");
        vehicles.add("https://swapi.dev/api/vehicles/7/");
        vehicles.add("https://swapi.dev/api/vehicles/8/");
        filmApi.setVehicles(vehicles);
        assertEquals(vehicles, filmApi.getVehicles());
    }

    @Test
    public void FilmAPISpeciesGetterTest() {
        List<String> species = new ArrayList<>();
        species.add("https://swapi.dev/api/species/1/");
        species.add("https://swapi.dev/api/species/2/");
        species.add("https://swapi.dev/api/species/3/");
        species.add("https://swapi.dev/api/species/4/");
        species.add("https://swapi.dev/api/species/5/");
        filmApi.setSpecies(species);
        assertEquals(species, filmApi.getSpecies());
    }

    @Test
    public void FilmAPICreatedGetterTest() {
        LocalDateTime created = LocalDateTime.parse("2014-12-10T14:23:31");
        filmApi.setCreated(created);
        assertEquals(created, filmApi.getCreated());
    }

    @Test
    public void FilmAPIEditedGetterTest() {
        LocalDateTime edited = LocalDateTime.parse("2014-12-20T19:49:45");
        filmApi.setEdited(edited);
        assertEquals(edited, filmApi.getEdited());
    }

    @Test
    public void FilmAPIUrlGetterTest() {
        String url = "https://swapi.dev/api/films/1/";
        filmApi.setUrl(url);
        assertEquals(url, filmApi.getUrl());
    }
}