package com.xelita.commons;

import com.fasterxml.jackson.annotation.JsonIgnore

/**
 * Define an identifiable object.
 *
 * @author xelita
 */
interface Identifiable {

    /**
     * Return the object identifier.
     *
     * @return String
     */
    @JsonIgnore
    fun getId(): String;

    /**
     * Return the type of the object.
     *
     * @return String
     */
    @JsonIgnore
    fun getType(): String;
}
