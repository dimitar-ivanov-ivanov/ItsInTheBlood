package com.company.data.interfaces;

import com.company.models.interfaces.Cellular;
import com.company.models.interfaces.Clustercentric;
import com.company.models.interfaces.Organic;

public interface HealthManager {

    String checkCondition(String organismName);

    String createOrganism(Organic organism);

    String addCluster(Clustercentric clusterable, String organismName);

    String addCellToCluster(Cellular cell, String organismName, String clusterId);

    String activateCluster(String organism);
}