package com.company.core.factories;

import com.company.interfaces.Organic;
import com.company.interfaces.OrganicFactory;
import com.company.models.Organism;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class OrganismFactory implements OrganicFactory {
    @Override
    public Organic createOrganism(String organismName) {
        return new Organism(organismName);
    }
}
