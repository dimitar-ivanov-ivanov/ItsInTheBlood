package com.company.interfaces;

public interface Organic {

    String getName();

    String addCluster(Clustercentric cluster);

    String addCellToCluster(String clusterId, Cellular cell);

    String activateCluster();
}
