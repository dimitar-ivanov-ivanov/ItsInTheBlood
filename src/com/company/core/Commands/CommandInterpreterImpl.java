package com.company.core.commands;

import com.company.core.commands.interfaces.CommandInterpreter;
import com.company.core.commands.interfaces.Executable;
import com.company.core.factories.CellFactory;
import com.company.core.factories.interfaces.CellularFactory;
import com.company.core.factories.interfaces.ClustercentricFactory;
import com.company.core.factories.interfaces.OrganicFactory;
import com.company.data.interfaces.HealthManager;
import com.company.common.TypeValidator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMANDS_PACKAGE_NAME = "com.company.core.commands.";

    private HealthManager manager;
    private CellularFactory cellFactory;
    private ClustercentricFactory clusterableFactory;
    private OrganicFactory organicFactory;

    public CommandInterpreterImpl(HealthManager manager, CellFactory cellFactory, ClustercentricFactory clusterableFactory, OrganicFactory organicFactory) {
        this.manager = manager;
        this.cellFactory = cellFactory;
        this.clusterableFactory = clusterableFactory;
        this.organicFactory = organicFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        String className = commandName.substring(0, 1).toUpperCase() + commandName.substring(1);

        Executable executable = null;

        try {

            Class commandInstance = Class.forName(COMMANDS_PACKAGE_NAME + className + "Command");

            Constructor constructor = commandInstance.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            executable = (Executable) constructor.newInstance((Object) data);

            injectsField(executable);

        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return executable;
    }

    private void injectsField(Executable executable) {
        Field[] fieldsToInject = executable.getClass().getDeclaredFields();

        for (Field fieldToInject : fieldsToInject) {
            String firstAnnotation = fieldToInject.getAnnotations()[0].toString();

            if (firstAnnotation.contains("Inject")) {
                checkCurrentFields(executable, fieldToInject);
            }
        }
    }

    private void checkCurrentFields(Executable executable, Field fieldToInject) {
        Field[] currentClassFields = this.getClass().getDeclaredFields();
        boolean injectedField = false;

        for (Field currentField : currentClassFields) {
            if (TypeValidator.checkIfFieldTypesAreEqual(fieldToInject, currentField) &&
                    tryToInjectField(executable, fieldToInject, currentField)) {
                break;
            }
        }
    }

    private boolean tryToInjectField(Executable executable, Field fieldToInject, Field currentField) {
        fieldToInject.setAccessible(true);
        boolean injectedField = false;

        try {
            fieldToInject.set(executable, currentField.get(this));
            injectedField = true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return injectedField;
    }
}
