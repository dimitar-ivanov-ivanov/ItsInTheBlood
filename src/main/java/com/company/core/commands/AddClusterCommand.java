package com.company.core.commands;

import com.company.annotations.Inject;
import com.company.models.interfaces.Clustercentric;
import com.company.core.factories.interfaces.ClustercentricFactory;
import com.company.data.interfaces.HealthManager;

/**
 * The type Add cluster command.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 * @see Command
 */
public class AddClusterCommand extends Command {

    @Inject
    private HealthManager manager;
    @Inject
    private ClustercentricFactory clusterableFactory;

    /**
     * Instantiates a new Add cluster command.
     *
     * @param data the data
     */
    public AddClusterCommand(String[] data) {
        super(data);
    }

    /**
     * Execute the addCluster function of the injected manager
     *
     * @return a message to indicate successful execution
     * @see ClustercentricFactory#createCluster(String, int, int) 
     * @see HealthManager#addCluster(Clustercentric, String)
     */
    @Override
    public String execute() {
        String organismName = data[1];
        String id = data[2];
        int rows = Integer.parseInt(data[3]);
        int cols = Integer.parseInt(data[4]);

        Clustercentric cluster = clusterableFactory.createCluster(id, rows, cols);
        return manager.addCluster(cluster, organismName);
    }
}
