package com.company.core.factories.interfaces;

import com.company.models.interfaces.Organic;

/**
 * The interface Organic factory.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public interface OrganicFactory {

    /**
     * Create organism.
     *
     * @param organismName the organism name
     * @return the organism
     */
    Organic createOrganism(String organismName);

}
