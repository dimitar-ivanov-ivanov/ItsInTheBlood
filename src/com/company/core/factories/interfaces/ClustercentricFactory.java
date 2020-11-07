package com.company.core.factories.interfaces;

import com.company.models.interfaces.Clustercentric;

public interface ClustercentricFactory {

    Clustercentric createCluster(String clusterId, int rows, int cols);

}
