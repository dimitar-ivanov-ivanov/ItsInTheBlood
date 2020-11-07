package com.company.core.commands;

import com.company.annotations.Inject;
import com.company.data.interfaces.HealthManager;
import com.company.models.interfaces.Organic;
import com.company.core.factories.interfaces.OrganicFactory;

public class CreateOrganismCommand extends Command {

    @Inject
    private OrganicFactory organicFactory;
    @Inject
    private HealthManager healthManager;

    public CreateOrganismCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        Organic organism = organicFactory.createOrganism(super.getData()[1]);
        String result = healthManager.createOrganism(organism);
        return result;
    }
}
