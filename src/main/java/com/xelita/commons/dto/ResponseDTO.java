package com.xelita.commons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ResponseDTO
 *
 * @author xelita
 */
@ToString
@Getter
public class ResponseDTO<T> implements Serializable {

    private static final long serialVersionUID = 5798904584155568644L;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("context")
    private ContextDTO context;

    @JsonProperty("data")
    private T data;

    // *************************************************************************
    //
    // Constructors
    //
    // *************************************************************************

    public ResponseDTO() {
        this.success = true;
    }

    public ResponseDTO(T data, String appName) {
        this();
        this.context = new ContextDTO(appName);
        this.data = data;
    }

    public ResponseDTO(T data, boolean success, String appName) {
        this(data, appName);
        this.success = success;
    }
}
