package com.xelita.commons.exception

import com.xelita.commons.Identifiable
import org.springframework.http.HttpStatus

/**
 * NotFoundException.
 *
 * @author xelita
 */
class NotFoundException : TrackableException {

    constructor(obj: Identifiable) : super(obj.getType() + " with id [" + obj.getId() + "] could not be found,", "NOT_FOUND_EXCEPTION", HttpStatus.NOT_FOUND.value())

    constructor(obj: Identifiable, th: Throwable) : super(obj.getType() + " with id [" + obj.getId() + "] could not be found,", th, "NOT_FOUND_EXCEPTION", HttpStatus.NOT_FOUND.value())
}