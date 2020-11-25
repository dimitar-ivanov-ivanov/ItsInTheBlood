package com.company.core.factories.interfaces;

import com.company.models.interfaces.Cellular;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

/**
 * The interface Cellular factory.
 * All cell factories must implement this interface
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public interface CellularFactory {

    /**
     * Create cell
     *
     * @param cellType           the cell type
     * @param cellId             the cell id
     * @param health             the health
     * @param positionRow        the position row
     * @param positionCol        the position col
     * @param additionalProperty the additional property
     * @return the cell
     * @throws ExecutionControl.NotImplementedException the not implemented exception
     * @throws NoSuchMethodException                    the no such method exception
     * @throws ClassNotFoundException                   the class not found exception
     * @throws IllegalAccessException                   the illegal access exception
     * @throws InvocationTargetException                the invocation target exception
     * @throws InstantiationException                   the instantiation exception
     */
    Cellular createCell(String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) throws ExecutionControl.NotImplementedException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
