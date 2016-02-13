package com.xelita.commons.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * TrackableException.
 *
 * @author xelita
 */
@Getter
public class TrackableException extends RuntimeException {

    private static final long serialVersionUID = -1207153914915110691L;

    // The key for exception localization.
    private String key;

    // The status code to be sent to the client (default is 500)
    private int statusCode;

    /**
     * Constructor.
     *
     * @param message the message to be displayed
     * @param key     the key for client side translation
     */
    public TrackableException(String message, String key) {
        this(message, null, key);
    }

    /**
     * Constructor.
     *
     * @param message the message to be displayed
     * @param key     the key for client side translation
     */
    public TrackableException(String message, String key, int statusCode) {
        this(message, null, key, statusCode);
    }

    /**
     * Constructor.
     *
     * @param message the message to be displayed
     * @param th      the exception stack
     * @param key     the key for client side translation
     */
    public TrackableException(String message, Throwable th, String key) {
        this(message, th, key, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    /**
     * Constructor.
     *
     * @param message    the message to be displayed
     * @param th         the exception stack
     * @param key        the key for client side translation
     * @param statusCode the status code
     */
    public TrackableException(String message, Throwable th, String key, int statusCode) {
        super(message, th);
        this.key = key;
        this.statusCode = statusCode;
    }
}