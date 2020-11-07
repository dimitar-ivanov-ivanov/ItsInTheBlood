package com.company.models.interfaces;


/**
 * Objects of class Cluster must implement this interface
 * Extend the Identifiable interface because the cluster should contain id
 *
 * @author Dimitar Ivanov
 * @version 1.4
 * @since 06.11.2020
 * @see Identifiable
 */
public interface Clustercentric extends Identifiable {

    /**
     * Add a cell to the cluster
     *
     * @param cell the cell which will be added to the cluster
     * @see Cellular
     */
    void addCell(Cellular cell);

    /**
     * Get the total count of cells in the cluster
     *
     * @return the number of total cells in the cluster
     */
    int getCellsCount();

    /**
     * Activate the cluster in which we find the first available cell
     * which goes around the cluster destroying other cells until it reaches the end of the cluster or is
     * destroyed in battle by another cell in which case the cell that destroyed its role and
     * destroy the remaining cells
     *
     * @return the remaining number of cells in the cluster which will always be 1
     * @see Cellular#fight(Cellular)
     */
    int activate();
}
