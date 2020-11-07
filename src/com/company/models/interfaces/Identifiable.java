package com.company.models.interfaces;

/**
 * Any object that contains id must implement this interface
 *
 * @author Dimitar Ivanov
 * @version 1.4
 * @since 06.11.2020
 */

public interface Identifiable {

    /**
     * Get the id of the object which will fit a certain pattern
     *
     * @return the id of the object
     */
    String getId();
}
