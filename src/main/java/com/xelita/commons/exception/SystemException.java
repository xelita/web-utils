package com.xelita.commons.exception;

import lombok.Getter;

/**
 * Base exceptions class for system exceptions<br>
 * A system exception causes the current transaction to rollback (in JTA mode).
 *
 * @author xelita
 */
@Getter
public class SystemException extends RuntimeException {

    private static final long serialVersionUID = -1207153914915110691L;

    /**
     * Unknown key constant
     */
    public static final String UNKNOWN_KEY = "UNKNOWN";

    // The key for exception localization.
    private String key;

    /**
     * Constructor with message.
     *
     * @param message the message to be displayed
     */
    public SystemException(String message) {
        this(message, UNKNOWN_KEY);
    }

    /**
     * Constructor with message and key.
     *
     * @param message the message to be displayed
     * @param key     the key for client side translation
     */
    public SystemException(String message, String key) {
        super(message);
        this.key = key;
    }

    /**
     * Constructor with exception.
     *
     * @param th the exception stack
     */
    public SystemException(Throwable th) {
        this(th, UNKNOWN_KEY);
    }

    /**
     * Constructor with exception and key.
     *
     * @param th  the exception stack
     * @param key the key for client side translation
     */
    public SystemException(Throwable th, String key) {
        super(th);
        this.key = key;
    }

    /**
     * Constructor with message and exception.
     *
     * @param message the message to be displayed
     * @param th      the exception stack
     */
    public SystemException(String message, Throwable th) {
        this(message, th, UNKNOWN_KEY);
    }

    /**
     * Constructor with message, exception and key.
     *
     * @param message the message to be displayed
     * @param th      the exception stack
     * @param key     the key for client side translation
     */
    public SystemException(String message, Throwable th, String key) {
        super(message, th);
        this.key = key;
    }
}