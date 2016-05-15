package com.xelita.commons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.NotNull;

/**
 * ContextDTO
 *
 * @author xelita
 */
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContextDTO extends AbstractDTO {

    private static final long serialVersionUID = 5798904584155568644L;

    @JsonProperty("application_name")
    private String appName;

    @NotNull
    @Override
    public String getId() {
        return this.appName;
    }
}
