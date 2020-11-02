package com.company.data;

import com.company.interfaces.HealthManager;
import com.company.models.Organism;
import jdk.jshell.spi.ExecutionControl;

import java.util.HashMap;
import java.util.Map;

public class HealthManagerImpl implements HealthManager {
    Map<String, Organism> organism;

    public HealthManagerImpl() {
        this.organism = new HashMap<>();
    }

    @Override
    public String checkCondition(String organismName) {
        return null;
    }

    @Override
    public String createOrganism(String name) {
        return null;
    }

    @Override
    public String addCluster(String organismName, String id, int rows, int cols) {
        return null;
    }

    @Override
    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        return null;
    }

    @Override
    public String activateCluster(String organismName) {
        return null;
    }
}