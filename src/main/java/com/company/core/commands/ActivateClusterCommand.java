package com.company.core.commands;

import com.company.annotations.Inject;
import com.company.core.commands.interfaces.CommandInterpreter;
import com.company.data.interfaces.HealthManager;

/**
 * The type Activate cluster command.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 * @see Command
 */
public class ActivateClusterCommand extends Command {

    @Inject
    private HealthManager manager;

    /**
     * Instantiates a new Activate cluster command.
     *
     * @param data the data
     */
    public ActivateClusterCommand(String[] data) {
        super(data);
    }

    /**
     * Execute the activateCluster function of the Health manager
     *
     * @return a message to indicate successful execution
     * @see HealthManager#activateCluster(String)
     */
    @Override
    public String execute() {
        String organismName = data[1];
        return manager.activateCluster(organismName);
    }
}
