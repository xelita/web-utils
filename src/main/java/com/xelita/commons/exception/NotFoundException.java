package com.xelita.commons.exception;

import com.xelita.commons.Identifiable;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * NotFoundException.
 *
 * @author xelita
 */
public class NotFoundException extends TrackableException {

    private static final String EXCEPTION_KEY = "NOT_FOUND_EXCEPTION";


    public NotFoundException(Identifiable identifiable) {
        super(identifiable.getType() + " with id [" + identifiable.getId() + "] could not be found,", EXCEPTION_KEY, HttpStatus.NOT_FOUND.value());
    }

    public NotFoundException(Identifiable identifiable, Throwable th, int statusCode) {
        super(identifiable.getType() + " with id [" + identifiable.getId() + "] could not be found,", th, EXCEPTION_KEY, HttpStatus.NOT_FOUND.value());
    }
}