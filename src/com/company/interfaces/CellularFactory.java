package com.company.interfaces;

import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public interface CellularFactory {

    Cellular createCell(String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) throws ExecutionControl.NotImplementedException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
