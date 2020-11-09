package com.company.data.interfaces;

import com.company.models.interfaces.Cellular;
import com.company.models.interfaces.Clustercentric;
import com.company.models.interfaces.Organic;


/**
 * The interface Health manager.
 * All Health manager classes must implement this interface
 */
public interface HealthManager {

    /**
     * Check the condition of the organism and print all it's clusters.
     *
     * @param organismName the organism name
     * @return spring representation of the organism
     */
    String checkCondition(String organismName);

    /**
     * Create organism
     *
     * @param organism the organism
     * @return message for successful creation
     */
    String createOrganism(Organic organism);

    /**
     * Add cluster to the organism of the given name
     *
     * @param clusterable  the cluster
     * @param organismName the organism name
     * @return message for successful creation
     * @see Organic#addCluster(Clustercentric)
     */
    String addCluster(Clustercentric clusterable, String organismName);

    /**
     * Add cell to cluster of the organism with the given name
     *
     * @param cell         the cell
     * @param organismName the organism name
     * @param clusterId    the cluster id
     * @return message for successful creation
     * @see Organic#addCellToCluster(String, Cellular)
     * @see Clustercentric#addCell(Cellular)
     */
    String addCellToCluster(Cellular cell, String organismName, String clusterId);

    /**
     * Activate cluster.
     *
     * @param organismName the organism name
     * @return message for successful creation
     * @see Clustercentric#activate()
     */
    String activateCluster(String organismName);
}
