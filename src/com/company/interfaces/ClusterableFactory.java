package com.company.interfaces;

import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public interface ClusterableFactory {

    Clusterable createCluster(String clusterId, int rows, int cols);

}
