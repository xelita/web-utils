package com.xelita.commons;

/**
 * Define an identifiable object.
 *
 * @author xelita
 */
public interface Identifiable {

    /**
     * Return the object identifier.
     *
     * @return String
     */
    String getId();

    /**
     * Return the type of the object.
     *
     * @return String
     */
    String getType();
}
