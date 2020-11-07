package com.company.core.commands;

import com.company.annotations.Inject;
import com.company.data.interfaces.HealthManager;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class ActivateClusterCommand extends Command {

    @Inject
    private HealthManager manager;

    public ActivateClusterCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws NoSuchMethodException, IllegalAccessException, InstantiationException, ExecutionControl.NotImplementedException, InvocationTargetException, ClassNotFoundException {
        String organismName = data[1];
        return manager.activateCluster(organismName);
    }
}
