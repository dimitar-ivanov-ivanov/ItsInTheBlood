package com.company.core.factories;

import com.company.models.interfaces.Cellular;
import com.company.core.factories.interfaces.CellularFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * The type Cell factory.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public class CellFactory implements CellularFactory {
    private final String CELLS_PACKAGE_NAME =
            "com.company.models.";

    /**
     * Create a cell from the given data
     * Get the name of the by combining the package name with the type and add a Command at the end
     * Through reflection get the class and constructor that matches the types of the input data
     * Make the constructor accessible and then instantiate the cell
     *
     * @param cellType           the cell type
     * @param cellId             the cell id
     * @param health             the health
     * @param positionRow        the position row
     * @param positionCol        the position col
     * @param additionalProperty the additional property
     * @return the cell
     * @throws NoSuchMethodException     the no such method exception
     * @throws ClassNotFoundException    the class not found exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws InstantiationException    the instantiation exception
     */
    @Override
    public Cellular createCell(String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String folderName = cellType.endsWith("Cell") ? "cells." : "microbes.";

        String fullName = CELLS_PACKAGE_NAME + folderName + cellType;
        Class<?> reflection = Class.forName(fullName);
        Constructor<?> constructor = reflection.getDeclaredConstructor(String.class, int.class, int.class, int.class, int.class);
        constructor.setAccessible(true);

        Cellular cell = (Cellular) constructor.newInstance(cellId, health, positionRow, positionCol, additionalProperty);

        return cell;
    }
}
