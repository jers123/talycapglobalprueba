package org.technicaltest.starwars.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.technicaltest.starwars.models.Base;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FilmDTO extends Base {
    private Integer idFilm;
    private Integer episode_id;
    private String title;
    //private LocalDate release_date;
    private Date release_date;
}