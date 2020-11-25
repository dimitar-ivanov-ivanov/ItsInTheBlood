package com.company.core.factories;

import com.company.models.interfaces.Organic;
import com.company.core.factories.interfaces.OrganicFactory;
import com.company.models.Organism;

/**
 * The type Organism factory.
 */
public class OrganismFactory implements OrganicFactory {

    /**
     * Create new organism from the given data
     *
     * @param organismName the organism name
     * @return the organism
     */
    @Override
    public Organic createOrganism(String organismName) {
        return new Organism(organismName);
    }
}
