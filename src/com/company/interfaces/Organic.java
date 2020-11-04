package com.company.interfaces;

public interface Organic {

    String getName();

    String addCluster(Clusterable cluster);

    String addCell(String clusterId, Cellular cell);
}
