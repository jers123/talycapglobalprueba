package org.technicaltest.starwars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.technicaltest.starwars.models.Base;
import org.technicaltest.starwars.models.dto.FilmDTO;
import org.technicaltest.starwars.services.FilmService;

import static org.technicaltest.starwars.utils.SystemConstants.LOCAL_ORIGIN_PATH;
import static org.technicaltest.starwars.utils.SystemConstants.STARWARS_PATH;
import static org.technicaltest.starwars.utils.SystemConstants.answer;

@RestController
@CrossOrigin(origins = {LOCAL_ORIGIN_PATH}
    ,methods = {RequestMethod.GET,
        RequestMethod.PUT,
        RequestMethod.DELETE
    }
)
@RequestMapping(path = STARWARS_PATH)
public class FilmController {

    @Autowired
    private FilmService service;

    @GetMapping("/film/{id}/")
    public ResponseEntity<Base> getById(@PathVariable("id") Integer id) {
        try {
            return answer(service.consumeAPI(id));
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/update/")
    public ResponseEntity<Base> updateFilm(@RequestBody FilmDTO entityDto) {
        try {
            return answer(service.update(entityDto));
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}/")
    public ResponseEntity<Base> deleteFilm(@PathVariable("id") Integer id) {
        try {
            return answer(service.delete(id));
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}