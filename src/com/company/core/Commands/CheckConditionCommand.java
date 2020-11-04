package com.company.core.commands;

import com.company.annotations.Inject;
import com.company.interfaces.HealthManager;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class CheckConditionCommand extends Command {

    @Inject
    private HealthManager manager;

    public CheckConditionCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String organismName = data[1];
        return manager.checkCondition(organismName);
    }
}
