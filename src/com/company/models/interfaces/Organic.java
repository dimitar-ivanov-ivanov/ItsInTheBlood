package com.company.models.interfaces;

/**
 * Any object of class Organism must implement this interface
 *
 * @author Dimitar Ivanov
 * @version 1.4
 */
public interface Organic {

    /**
     * Get the name of the organism which will fit a certain pattern
     *
     * @return the name of the organism
     */
    String getName();

    /**
     * Add a cluster to the organism if that cluster doesn't already exist
     *
     * @param cluster the cluster which will be added
     * @return  message to signify the adding of the cluster was successful
     * @see Clustercentric
     */
    String addCluster(Clustercentric cluster);

    /**
     * Add a cell to a certain cluster if the cluster exists
     *
     * @param clusterId the id of the cluster which the cell will be added to
     * @param cell the cell which we will be adding to the cluster
     * @return  message to signify the adding of the cell to the cluster successful
     * @see Clustercentric#addCell(Cellular) 
     */
    String addCellToCluster(String clusterId, Cellular cell);

    /**
     * Activate the first found non-activated cluster
     * If all clusters are activated, disable them and then activate the first one found
     *
     * @return message to signify that the activation was successful
     * @see Clustercentric#activate() 
     */
    String activateCluster();
}
