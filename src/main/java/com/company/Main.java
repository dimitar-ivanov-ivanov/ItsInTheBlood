package com.company;

import com.company.core.Engine;
import com.company.core.InputOutput.ConsoleReader;
import com.company.core.InputOutput.ConsoleWriter;
import com.company.core.InputOutput.interfaces.Reader;
import com.company.core.InputOutput.interfaces.Writer;
import com.company.core.commands.CommandInterpreterImpl;
import com.company.core.commands.interfaces.CommandInterpreter;
import com.company.core.factories.CellFactory;
import com.company.core.factories.ClusterFactory;
import com.company.core.factories.OrganismFactory;
import com.company.core.factories.interfaces.ClustercentricFactory;
import com.company.core.factories.interfaces.OrganicFactory;
import com.company.data.HealthManagerImpl;
import com.company.data.interfaces.HealthManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        HealthManager manager = new HealthManagerImpl();

        CellFactory cellFactory = new CellFactory();
        ClustercentricFactory clusterableFactory = new ClusterFactory();
        OrganicFactory organicFactory = new OrganismFactory();

        CommandInterpreter interpreter = new CommandInterpreterImpl(manager, cellFactory, clusterableFactory, organicFactory);

        Scanner scanner = new Scanner(System.in);
        Writer writer = new ConsoleWriter();
        Reader reader = new ConsoleReader(scanner);

        Runnable engine = new Engine(interpreter, writer, reader);
        engine.run();
    }
}
