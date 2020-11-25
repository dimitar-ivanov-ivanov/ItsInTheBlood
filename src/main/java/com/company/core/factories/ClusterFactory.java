package com.company.core.factories;

import com.company.models.interfaces.Clustercentric;
import com.company.core.factories.interfaces.ClustercentricFactory;
import com.company.models.Cluster;

/**
 * The type Cluster factory.
 */
public class ClusterFactory implements ClustercentricFactory {

    /**
     * Create new cluster from the given data
     *
     * @param clusterId the cluster id
     * @param rows      the rows
     * @param cols      the cols
     * @return the cluster
     */
    @Override
    public Clustercentric createCluster(String clusterId, int rows, int cols) {
        return new Cluster(clusterId, rows, cols);
    }
}
