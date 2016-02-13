package com.xelita.commons.exception;

import lombok.Getter;

/**
 * Base exceptions class for application exceptions<br>
 * An application exception does not cause the current transaction to rollback (in JTA mode).
 *
 * @author xelita
 */
@Getter
public class ApplicationException extends Exception {

    private static final long serialVersionUID = 5416776797401325068L;

    // The key for exception localization.
    private String key;

    /**
     * Constructor with message.
     *
     * @param message
     */
    public ApplicationException(String message, String key) {
        super(message);
        this.key = key;
    }

    /**
     * Constructor with exception and key.
     *
     * @param th
     * @param key
     */
    public ApplicationException(Throwable th, String key) {
        super(th);
        this.key = key;
    }

    /**
     * Constructor with message, exception and key.
     *
     * @param message
     * @param th
     * @param key
     */
    public ApplicationException(String message, Throwable th, String key) {
        super(message, th);
        this.key = key;
    }
}