package com.company.core.factories;

import com.company.interfaces.Cellular;
import com.company.interfaces.CellularFactory;
import com.company.models.Cell;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CellFactory implements CellularFactory {
    private final String CELLS_PACKAGE_NAME =
            "com.company.models.cells.";

    @Override
    public Cellular createCell(String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) throws ExecutionControl.NotImplementedException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String fullName = CELLS_PACKAGE_NAME + cellType;
        Class<?> reflection = Class.forName(fullName);
        Constructor<?> constructor = reflection.getDeclaredConstructor(String.class, int.class, int.class, int.class, int.class);
        constructor.setAccessible(true);

        Cellular cell = (Cellular) constructor.newInstance(cellId, health, positionRow, positionCol, additionalProperty);

        return cell;
    }
}
