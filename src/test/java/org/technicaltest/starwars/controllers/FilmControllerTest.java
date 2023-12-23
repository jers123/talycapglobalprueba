package org.technicaltest.starwars.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.technicaltest.starwars.models.dto.FilmDTO;
import org.technicaltest.starwars.models.entities.Film;
import org.technicaltest.starwars.services.FilmService;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.technicaltest.starwars.utils.SystemConstants.STARWARS_PATH;

@WebMvcTest
public class FilmControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FilmService service;

    @Test
    public void getById() throws Exception {
        FilmDTO filmDto = new FilmDTO();
        filmDto.setIdFilm(1);
        filmDto.setEpisode_id(4);
        filmDto.setTitle("A New Hope");
        filmDto.setRelease_date(new Date(1977,05,25));
        Integer idApi = 1;

        given(service.consumeAPI(idApi)).willAnswer((invocation) -> invocation.getArgument(0));
        ResultActions resultActions = mockMvc.perform(get(STARWARS_PATH + "/film/" + idApi + "/")
                .contentType(MediaType.APPLICATION_JSON));

        resultActions.andDo(print()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.idFilm", is(filmDto.getIdFilm())))
                .andExpect(jsonPath("$.episode_id", is(filmDto.getEpisode_id())))
                .andExpect(jsonPath("$.title", is(filmDto.getTitle())))
                .andExpect(jsonPath("$.release_date", is(filmDto.getRelease_date())));
    }
}