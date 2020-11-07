package com.company.core.factories;

import com.company.models.interfaces.Organic;
import com.company.core.factories.interfaces.OrganicFactory;
import com.company.models.Organism;

public class OrganismFactory implements OrganicFactory {
    @Override
    public Organic createOrganism(String organismName) {
        return new Organism(organismName);
    }
}
