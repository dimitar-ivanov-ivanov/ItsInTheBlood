package com.company.core.commands;

import com.company.annotations.Inject;
import com.company.data.interfaces.HealthManager;

public class ActivateClusterCommand extends Command {

    @Inject
    private HealthManager manager;

    public ActivateClusterCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String organismName = data[1];
        return manager.activateCluster(organismName);
    }
}
