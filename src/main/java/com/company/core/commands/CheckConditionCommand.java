package com.company.core.commands;

import com.company.annotations.Inject;
import com.company.data.interfaces.HealthManager;

/**
 * The type Check condition command.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 * @see Command
 */
public class CheckConditionCommand extends Command {

    @Inject
    private HealthManager manager;

    /**
     * Instantiates a new Check condition command.
     *
     * @param data the data
     */
    public CheckConditionCommand(String[] data) {
        super(data);
    }

    /**
     * Execute the checkCondition function of the injected manager
     *
     * @return a message to indicate successful execution
     * @see HealthManager#checkCondition(String) 
     */
    @Override
    public String execute() {
        String organismName = data[1];
        return manager.checkCondition(organismName);
    }
}
