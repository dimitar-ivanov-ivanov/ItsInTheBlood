package com.company.interfaces;

import com.company.models.Cell;
import com.company.models.Cluster;

public interface HealthManager {

    String checkCondition(String organismName);

    String createOrganism(Organic organism);

    String addCluster(Clusterable clusterable, String organismName);

    String addCell(Cellular cell, String organismName, String clusterId);

    String activateCluster(Cluster cluster);
}
