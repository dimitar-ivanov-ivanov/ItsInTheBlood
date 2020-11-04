package com.company.core.commands;

import com.company.annotations.Inject;
import com.company.interfaces.HealthManager;
import com.company.interfaces.Organic;
import com.company.interfaces.OrganicFactory;
import com.company.models.Organism;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

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
