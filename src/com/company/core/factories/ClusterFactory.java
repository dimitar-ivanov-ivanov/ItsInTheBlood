package com.company.core.factories;

import com.company.interfaces.Clusterable;
import com.company.interfaces.ClusterableFactory;
import com.company.models.Cluster;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class ClusterFactory implements ClusterableFactory {
    private final String CLUSTER_PACKAGE_NAME = "com.company.models.Cluster";


    @Override
    public Clusterable createCluster(String clusterId, int rows, int cols) {
        return new Cluster(clusterId, rows, cols);
    }
}
