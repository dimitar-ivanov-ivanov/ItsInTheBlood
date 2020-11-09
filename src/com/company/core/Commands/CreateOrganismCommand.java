package com.company.core.commands;

import com.company.annotations.Inject;
import com.company.data.interfaces.HealthManager;
import com.company.models.interfaces.Organic;
import com.company.core.factories.interfaces.OrganicFactory;

/**
 * The type Create organism command.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 * @see Command
 */
public class CreateOrganismCommand extends Command {

    @Inject
    private OrganicFactory organicFactory;
    @Inject
    private HealthManager healthManager;

    /**
     * Instantiates a new Create organism command.
     *
     * @param data the data
     */
    public CreateOrganismCommand(String[] data) {
        super(data);
    }

    /**
     * Create an organism from the injected factory and execute createOrganism function of the injected manager
     *
     * @return a message to indicate successful execution
     * @see OrganicFactory#createOrganism(String) 
     * @see HealthManager#createOrganism(Organic)
     */
    @Override
    public String execute() {
        Organic organism = organicFactory.createOrganism(super.getData()[1]);
        String result = healthManager.createOrganism(organism);
        return result;
    }
}
