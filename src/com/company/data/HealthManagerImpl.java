package com.company.data;

import com.company.exceptions.modelsExceptions.AlreadyExistsException;
import com.company.exceptions.modelsExceptions.MissingException;
import com.company.interfaces.Cellular;
import com.company.interfaces.Clustercentric;
import com.company.interfaces.HealthManager;
import com.company.interfaces.Organic;
import com.company.messages.ExceptionMessages;
import com.company.messages.OutputMessages;


import java.util.HashMap;
import java.util.Map;

public class HealthManagerImpl implements HealthManager {
    Map<String, Organic> allOrganism;

    public HealthManagerImpl() {
        this.allOrganism = new HashMap<>();
    }

    @Override
    public String checkCondition(String organismName) {
        if (!allOrganism.containsKey(organismName)) {
            throw new MissingException(String.format(ExceptionMessages.MISSING_FAIL, "Organism", organismName));
        }

        return allOrganism.get(organismName).toString();
    }

    @Override
    public String createOrganism(Organic organism) {
        if (allOrganism.containsKey(organism.getName())) {
            throw new AlreadyExistsException(String.format(ExceptionMessages.ALREADY_EXISTS_FAIL, "Organism", organism.getName()));
        }

        allOrganism.put(organism.getName(), organism);
        return String.format(OutputMessages.CREATE_ORGANISM_SUCCESS, organism.getName());
    }

    @Override
    public String addCluster(Clustercentric clusterable, String organismName) {
        if (!allOrganism.containsKey(organismName)) {
            throw new MissingException(String.format(ExceptionMessages.MISSING_FAIL, "Organism", organismName));
        }

        return allOrganism.get(organismName).addCluster(clusterable);
    }

    @Override
    public String addCellToCluster(Cellular cell, String organismName, String clusterId) {
        if (!allOrganism.containsKey(organismName)) {
            throw new MissingException(String.format(ExceptionMessages.MISSING_FAIL, "Organism", organismName));
        }

        allOrganism.get(organismName).addCellToCluster(clusterId, cell);
        return String.format(OutputMessages.ADD_CELL_TO_CLUSTER_IN_ORGANISM, organismName, cell.getId(), clusterId);
    }

    @Override
    public String activateCluster(String organismName) {
        if (!allOrganism.containsKey(organismName)) {
            throw new MissingException(String.format(ExceptionMessages.MISSING_FAIL, "Organism", organismName));
        }

        return allOrganism.get(organismName).activateCluster();
    }
}