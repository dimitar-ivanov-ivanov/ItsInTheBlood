package com.company;

import com.company.core.Engine;
import com.company.core.commands.CommandInterpreterImpl;
import com.company.core.factories.CellFactory;
import com.company.core.factories.ClusterFactory;
import com.company.core.factories.OrganismFactory;
import com.company.data.HealthManagerImpl;
import com.company.interfaces.*;
import com.company.models.cells.BloodCell;
import com.company.models.cells.RedBloodCell;
import jdk.jshell.spi.ExecutionControl;

import java.lang.Runnable;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, ExecutionControl.NotImplementedException, InvocationTargetException, ClassNotFoundException {
        solve();
    }

    private static void solve() throws NoSuchMethodException, IllegalAccessException, InstantiationException, ExecutionControl.NotImplementedException, InvocationTargetException, ClassNotFoundException {
        HealthManager manager = new HealthManagerImpl();

        CellFactory cellFactory = new CellFactory();
        ClustercentricFactory clusterableFactory = new ClusterFactory();
        OrganicFactory organicFactory = new OrganismFactory();

        CommandInterpreterImpl interpreter = new CommandInterpreterImpl(manager, cellFactory, clusterableFactory, organicFactory);

        Runnable engine = new Engine(interpreter);
        engine.run();
    }
}
