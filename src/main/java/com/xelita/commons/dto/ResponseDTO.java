package com.xelita.commons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

/**
 * ResponseDTO
 *
 * @author xelita
 */
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
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

    public ResponseDTO(String appName, T data) {
        this();
        this.context = new ContextDTO(appName);
        this.data = data;
    }

    public ResponseDTO(String appName, T data, boolean success) {
        this(appName, data);
        this.success = success;
        this.data = data;
    }
}
