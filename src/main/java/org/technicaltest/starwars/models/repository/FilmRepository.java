package org.technicaltest.starwars.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.technicaltest.starwars.models.entities.Film;

import java.util.Optional;

import static org.technicaltest.starwars.utils.SystemConstants.FILM_EPISODE_QUERY;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

    @Query(value = FILM_EPISODE_QUERY)
    Optional<Film> searchByEpisode(@Param("episode") Integer episodeId);
}