package com.company.core.commands;

import com.company.annotations.Inject;
import com.company.interfaces.Clusterable;
import com.company.interfaces.ClusterableFactory;
import com.company.interfaces.HealthManager;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class AddClusterCommand extends Command {

    @Inject
    private HealthManager manager;
    @Inject
    private ClusterableFactory clusterableFactory;

    public AddClusterCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String organismName = data[1];
        String id = data[2];
        int rows = Integer.parseInt(data[3]);
        int cols = Integer.parseInt(data[4]);

        Clusterable cluster = clusterableFactory.createCluster(id, rows, cols);
        return manager.addCluster(cluster, organismName);
    }
}
