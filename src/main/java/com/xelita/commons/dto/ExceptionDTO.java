package com.xelita.commons.dto;

import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

/**
 * ExceptionDTO.
 *
 * @author sempere
 */
@ToString
@Getter
public class ExceptionDTO extends AbstractDTO {

    private static final long serialVersionUID = -6214385640883839289L;

    private String uid;
    private String code;
    private String type;
    private String message;

    /**
     * Default class constructor.
     *
     * @param exception the exception
     * @param uid       the exception identifier
     * @param code      the exception code
     */
    public ExceptionDTO(Exception exception, String uid, String code) {
        this.uid = uid;
        this.type = exception.getClass().getName();
        this.code = code;
        this.message = exception.getMessage();
    }

    @NotNull
    @Override
    public String getId() {
        return this.uid;
    }
}
