package com.xelita.commons;

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
    fun getId(): String;

    /**
     * Return the type of the object.
     *
     * @return String
     */
    fun getType(): String;
}
