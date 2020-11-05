package com.company.interfaces;

public interface HealthManager {

    String checkCondition(String organismName);

    String createOrganism(Organic organism);

    String addCluster(Clustercentric clusterable, String organismName);

    String addCellToCluster(Cellular cell, String organismName, String clusterId);

    String activateCluster(String organism);
}
