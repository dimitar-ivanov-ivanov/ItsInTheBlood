package com.company.interfaces;

import com.company.models.Cluster;

public interface HealthManager {

    String checkCondition(String organismName);

    String createOrganism(Organic organism);

    String addCluster(Clustecentric clusterable, String organismName);

    String addCellToCluster(Cellular cell, String organismName, String clusterId);

    String activateCluster(Cluster cluster);
}
