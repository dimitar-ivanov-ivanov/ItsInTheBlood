package com.company.core.factories.interfaces;

import com.company.models.interfaces.Clustercentric;

/**
 * The interface Clustercentric factory.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public interface ClustercentricFactory {

    /**
     * Create cluster.
     *
     * @param clusterId the cluster id
     * @param rows      the rows
     * @param cols      the cols
     * @return the cluster
     */
    Clustercentric createCluster(String clusterId, int rows, int cols);

}
