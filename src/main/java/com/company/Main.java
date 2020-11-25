package com.company;

import com.company.core.Engine;
import com.company.core.commands.CommandInterpreterImpl;
import com.company.core.factories.CellFactory;
import com.company.core.factories.ClusterFactory;
import com.company.core.factories.OrganismFactory;
import com.company.core.factories.interfaces.ClustercentricFactory;
import com.company.core.factories.interfaces.OrganicFactory;
import com.company.data.HealthManagerImpl;
import com.company.data.interfaces.HealthManager;
import com.company.models.microbes.Fungi;
import com.company.models.microbes.Virus;

import java.lang.Runnable;

public class Main {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        HealthManager manager = new HealthManagerImpl();

        CellFactory cellFactory = new CellFactory();
        ClustercentricFactory clusterableFactory = new ClusterFactory();
        OrganicFactory organicFactory = new OrganismFactory();

        CommandInterpreterImpl interpreter = new CommandInterpreterImpl(manager, cellFactory, clusterableFactory, organicFactory);

        Runnable engine = new Engine(interpreter);
        engine.run();
    }
}
