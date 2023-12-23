package org.technicaltest.starwars.errors;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static org.technicaltest.starwars.utils.SystemConstants.ERROR;

public class ErrorTest {

    private static ErrorAPI error;

    @BeforeClass
    public static void setUpTest() {
        error = new ErrorAPI();
    }

    @Test
    public void FilmDTOTitleGetterTest() {
        String message = ERROR;
        error.setMessage(message);
        assertEquals(message, error.getMessage());
    }
}
