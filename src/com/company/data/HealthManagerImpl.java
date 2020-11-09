package com.company.data;

import com.company.exceptions.modelsExceptions.AlreadyExistsException;
import com.company.exceptions.modelsExceptions.MissingException;
import com.company.models.Organism;
import com.company.models.interfaces.Cellular;
import com.company.models.interfaces.Clustercentric;
import com.company.data.interfaces.HealthManager;
import com.company.models.interfaces.Organic;
import com.company.messages.ExceptionMessages;
import com.company.messages.OutputMessages;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of Health manager interface
 *
 * @author Dimitar Ivanov
 * @version 1.4
 * @see HealthManager
 */
public class HealthManagerImpl implements HealthManager {
    /**
     * All organisms collected in a map with their name as the key
     */
    Map<String, Organic> allOrganism;

    /**
     * Instantiates a new Health manager.
     */
    public HealthManagerImpl() {
        this.allOrganism = new HashMap<>();
    }

    /**
     * Check the condition of the organism and print all it's clusters.
     *
     * @param organismName the organism name
     * @return spring representation of the organism
     * @throws MissingException if the organism doesn't exist
     * @see ExceptionMessages#MISSING_FAIL
     * @see Organism#toString()
     */
    @Override
    public String checkCondition(String organismName) {
        if (!allOrganism.containsKey(organismName)) {
            throw new MissingException(String.format(ExceptionMessages.MISSING_FAIL, "Organism", organismName));
        }

        return allOrganism.get(organismName).toString();
    }

    /**
     * Create organism
     *
     * @param organism the organism
     * @return message for successful creation
     * @throws AlreadyExistsException if the organism has already been created
     * @see ExceptionMessages#ALREADY_EXISTS_FAIL
     * @see OutputMessages#CREATE_ORGANISM_SUCCESS
     */
    @Override
    public String createOrganism(Organic organism) {
        if (allOrganism.containsKey(organism.getName())) {
            throw new AlreadyExistsException(String.format(ExceptionMessages.ALREADY_EXISTS_FAIL, "Organism", organism.getName()));
        }

        allOrganism.put(organism.getName(), organism);
        return String.format(OutputMessages.CREATE_ORGANISM_SUCCESS, organism.getName());
    }

    /**
     * Add cluster to the organism of the given name
     *
     * @param clustercentric the cluster
     * @param organismName   the organism name
     * @return message for successful creation
     * @throws MissingException if the organism doesn't exist
     * @see ExceptionMessages#MISSING_FAIL
     * @see Organic#addCluster(Clustercentric)
     */
    @Override
    public String addCluster(Clustercentric clustercentric, String organismName) {
        if (!allOrganism.containsKey(organismName)) {
            throw new MissingException(String.format(ExceptionMessages.MISSING_FAIL, "Organism", organismName));
        }

        return allOrganism.get(organismName).addCluster(clustercentric);
    }

    /**
     * Add cell to cluster of the organism with the given name
     *
     * @param cell         the cell
     * @param organismName the organism name
     * @param clusterId    the cluster id
     * @return message for successful creation
     * @throws MissingException if the organism doesn't exist
     * @see ExceptionMessages#MISSING_FAIL
     * @see Organic#addCellToCluster(String, Cellular)
     * @see Clustercentric#addCell(Cellular)
     * @see OutputMessages#ADD_CELL_TO_CLUSTER_IN_ORGANISM
     */
    @Override
    public String addCellToCluster(Cellular cell, String organismName, String clusterId) {
        if (!allOrganism.containsKey(organismName)) {
            throw new MissingException(String.format(ExceptionMessages.MISSING_FAIL, "Organism", organismName));
        }

        allOrganism.get(organismName).addCellToCluster(clusterId, cell);
        return String.format(OutputMessages.ADD_CELL_TO_CLUSTER_IN_ORGANISM, organismName, cell.getId(), clusterId);
    }

    /**
     * Activate cluster.
     *
     * @param organismName the organism name
     * @return message for successful creation
     * @throws MissingException if the organism doesn't exist
     * @see ExceptionMessages#MISSING_FAIL
     * @see Clustercentric#activate()
     */
    @Override
    public String activateCluster(String organismName) {
        if (!allOrganism.containsKey(organismName)) {
            throw new MissingException(String.format(ExceptionMessages.MISSING_FAIL, "Organism", organismName));
        }

        return allOrganism.get(organismName).activateCluster();
    }
}