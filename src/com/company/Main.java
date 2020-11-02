package com.company;

import com.company.core.factories.CellFactory;
import com.company.interfaces.Cellular;
import com.company.interfaces.CellularFactory;
import com.company.models.Cell;
import com.company.models.cells.RedBloodCell;
import com.company.models.cells.WhiteBloodCell;
import com.company.models.microbes.Bacteria;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, ExecutionControl.NotImplementedException, InvocationTargetException, ClassNotFoundException {
        solve();
    }

    private static void solve() throws NoSuchMethodException, IllegalAccessException, InstantiationException, ExecutionControl.NotImplementedException, InvocationTargetException, ClassNotFoundException {
        CellularFactory cellularFactory = new CellFactory();
        Cellular cell = cellularFactory.createUnit("WhiteBloodCell", "WBC", 5, 10, 10, 25);
        System.out.println(cell);
    }
}
