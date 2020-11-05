package com.company.core.factories;

import com.company.interfaces.Clustercentric;
import com.company.interfaces.ClustercentricFactory;
import com.company.models.Cluster;

public class ClusterFactory implements ClustercentricFactory {
    private final String CLUSTER_PACKAGE_NAME = "com.company.models.Cluster";


    @Override
    public Clustercentric createCluster(String clusterId, int rows, int cols) {
        return new Cluster(clusterId, rows, cols);
    }
}
