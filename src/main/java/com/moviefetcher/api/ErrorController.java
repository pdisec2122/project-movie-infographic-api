package com.moviefetcher.api;

import com.moviefetcher.api.json.ErrorJson;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class ErrorController {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ErrorController.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorJson handleGeneric(Exception exception) {

        LOGGER.error(exception.getMessage(), exception);

        var message = "An unexpected error has occurred.";

        return ErrorJson.from(message);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ErrorJson handleMissingServletRequestParameterException(MissingServletRequestParameterException exception) {

        LOGGER.error(exception.getMessage(), exception);

        return ErrorJson.from(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ErrorJson handleIllegalArgumentException(IllegalArgumentException exception) {

        LOGGER.error(exception.getMessage(), exception);

        return ErrorJson.from(exception.getMessage());
    }

}
