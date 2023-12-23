package org.technicaltest.starwars.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.technicaltest.starwars.models.Base;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FilmAPI extends Base {
    private String title;
    private Integer episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    //private LocalDate release_date;
    private Date release_date;
    private List<String> characters;
    private List<String> planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;
    private LocalDateTime created;
    private LocalDateTime edited;
    private String url;
}