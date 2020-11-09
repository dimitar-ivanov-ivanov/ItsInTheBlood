package com.company.core.commands;

import com.company.annotations.Inject;
import com.company.models.interfaces.Cellular;
import com.company.core.factories.interfaces.CellularFactory;
import com.company.data.interfaces.HealthManager;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

/**
 * The type Add cell command.
 *
 * @author Dimitar Ivanov
 * @version 1.4
 * @see Command
 */
public class AddCellCommand extends Command {

    @Inject
    private HealthManager manager;
    @Inject
    private CellularFactory cellFactory;

    /**
     * Instantiates a new Add cell command.
     *
     * @param data the data
     */
    public AddCellCommand(String[] data) {
        super(data);
    }

    /**
     * Create cell from the injected factory and execute the addCellToCluster function of the injected manager
     *
     * @return a message to indicate successful execution
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ExecutionControl.NotImplementedException
     * @throws InvocationTargetException
     * @throws ClassNotFoundException
     * @see CellularFactory#createCell(String, String, int, int, int, int)
     * @see HealthManager#addCellToCluster(Cellular, String, String) (String)
     */
    @Override
    public String execute() throws NoSuchMethodException, IllegalAccessException, InstantiationException, ExecutionControl.NotImplementedException, InvocationTargetException, ClassNotFoundException {
        String organismName = data[1];
        String clusterId = data[2];
        String cellType = data[3];
        String cellId = data[4];
        int health = Integer.parseInt(data[5]);
        int positionRow = Integer.parseInt(data[6]);
        int positionCol = Integer.parseInt(data[7]);
        int additionalProperty = Integer.parseInt(data[8]);

        Cellular cell = cellFactory.createCell(cellType, cellId, health, positionRow, positionCol, additionalProperty);

        return manager.addCellToCluster(cell, organismName, clusterId);
    }
}
