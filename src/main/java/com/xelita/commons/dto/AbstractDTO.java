package com.xelita.commons.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Base class for any Data Transfert Object (DTO).
 *
 * @author xelita
 */
@ToString
@NoArgsConstructor
@Getter
@Setter
public abstract class AbstractDTO implements Serializable {

    private static final long serialVersionUID = -6214385640883845689L;
}
