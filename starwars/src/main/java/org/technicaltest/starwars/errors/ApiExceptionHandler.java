package org.technicaltest.starwars.errors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.technicaltest.starwars.models.Base;

import static org.technicaltest.starwars.utils.SystemConstants.ERROR;
import static org.technicaltest.starwars.utils.SystemConstants.HTTP_STATUS;
import static org.technicaltest.starwars.utils.SystemConstants.answer;

@RestControllerAdvice
public class ApiExceptionHandler {

    /*@Autowired
    private ErrorAPI error;*/

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    @ResponseBody
    public ResponseEntity<Base> httpRequestMethodException(MethodArgumentTypeMismatchException exception) {
        HTTP_STATUS = HttpStatus.BAD_REQUEST;
        return answer(new ErrorAPI(ERROR));
    }
}