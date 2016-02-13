package com.xelita.commons.controller;

import com.xelita.commons.dto.ExceptionDTO;
import com.xelita.commons.dto.ResponseDTO;
import com.xelita.commons.exception.TrackableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * Rest controller.
 *
 * @author xelita
 */
@Slf4j
@Controller
public class BaseController {

    /**
     * UID generator used for easy log retrieval.
     */
    private static final Random UID_GENERATOR = new Random();

    @Value("${app.key}")
    public String appKey;

    // *************************************************************************
    //
    // Exception Handlers
    //
    // *************************************************************************

    /**
     * ExceptionHandler on TrackableException.
     *
     * @param exception the thrown exception
     * @return ResponseDTO
     */
    @SuppressWarnings("unchecked")
    @ExceptionHandler(TrackableException.class)
    @ResponseBody
    public ResponseDTO<ExceptionDTO> handleHttpExceptionException(HttpServletResponse response, TrackableException exception) {
        log.debug("IN TrackableException");

        // Setting HTTP response status
        response.setStatus(exception.getStatusCode());

        ExceptionDTO exceptionDTO = new ExceptionDTO(exception, String.valueOf(Math.abs(UID_GENERATOR.nextInt())), exception.getKey());
        log.warn("TrackableException with UID : [{}] occurred.", exceptionDTO.getUid(), exception);

        return new ResponseDTO<>(exceptionDTO, false, this.appKey);
    }

    /**
     * ExceptionHandler on Exception.
     *
     * @param exception the thrown exception
     * @return ResponseDTO
     */
    @SuppressWarnings("unchecked")
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseDTO<ExceptionDTO> handleException(Exception exception) {
        log.debug("IN HandleException");

        ExceptionDTO exceptionDTO = new ExceptionDTO(exception, String.valueOf(Math.abs(UID_GENERATOR.nextInt())), "UNKNOWN_EXCEPTION");
        log.warn("Exception with UID : [{}] occurred.", exceptionDTO.getUid(), exception);

        return new ResponseDTO<>(exceptionDTO, false, this.appKey);
    }
}
