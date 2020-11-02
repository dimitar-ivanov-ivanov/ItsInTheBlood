package com.company.models;

import com.company.exceptions.InvalidNameException;
import com.company.interfaces.Clusterable;
import com.company.interfaces.Organic;
import com.company.validators.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class Organism implements Organic {
    private final String NAME_PATTERN = "^\\b[A-Z][a-z]+\\b$";

    private String name;
    private List<Clusterable> clusters;

    public Organism(String name) {
        setName(name);
        this.clusters = new ArrayList<>();
    }

    private void setName(String name) {
        if (StringValidator.validateStringWithPatter(name, NAME_PATTERN)) {
            throw new InvalidNameException();
        }
        this.name = name;
    }

    @Override
    public void addCluster(Clusterable cluster) {
        this.clusters.add(cluster);
    }
}
