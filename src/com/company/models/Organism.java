package com.company.models;

import com.company.common.StringValidator;
import com.company.exceptions.fieldsExceptions.InvalidNameException;
import com.company.exceptions.modelsExceptions.AlreadyExistsException;
import com.company.exceptions.modelsExceptions.ClusterActivationFailureException;
import com.company.exceptions.modelsExceptions.MissingException;
import com.company.models.interfaces.Cellular;
import com.company.models.interfaces.Clustercentric;
import com.company.models.interfaces.Organic;
import com.company.messages.ExceptionMessages;
import com.company.messages.OutputMessages;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the Organism filled with clusters
 * Main activities are to add clusters and cells to those clusters
 *
 * @author Dimitar Ivanov
 * @version 1.4
 * @see IdentifiableImpl
 * @see Clustercentric
 */
public class Organism implements Organic {
    /**
     * Pattern for the name
     * Must start with capital letter
     */
    private final String NAME_PATTERN = "^\\b[A-Z][a-z]+\\b$";

    private String name;
    private HashMap<String, Clustercentric> clusters;
    private HashMap<String, Boolean> activatedClusters;

    /**
     * Instantiates a new Organism.
     *
     * @param name the name
     */
    public Organism(String name) {
        setName(name);
        this.clusters = new HashMap<>();
        this.activatedClusters = new HashMap<>();
    }

    /**
     * Set the name of the organism
     *
     * @param name the name of the organism
     * @throws InvalidNameException when the name doesn't fit the pattern
     * @see InvalidNameException#getMessage()
     */
    private void setName(String name) {
        if (!StringValidator.validateStringWithPattern(name, NAME_PATTERN)) {
            throw new InvalidNameException();
        }
        this.name = name;
    }

    /**
     * Get the name of the organism
     *
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Adds a cluster
     *
     * @param cluster the cluster which will be added
     * @return message to show the adding was
     * @throws AlreadyExistsException if the cluster exists already
     * @see AlreadyExistsException#getMessage()
     * @see OutputMessages#ADD_CLUSTER_SUCCESS
     */
    @Override
    public String addCluster(Clustercentric cluster) {
        if (clusters.containsKey(cluster.getId())) {
            throw new AlreadyExistsException(String.format(ExceptionMessages.ALREADY_EXISTS_FAIL, "Cluster", cluster.getId()));
        }

        clusters.put(cluster.getId(), cluster);
        activatedClusters.put(cluster.getId(), false);

        return String.format(OutputMessages.ADD_CLUSTER_SUCCESS, name, cluster.getId());
    }

    /**
     * Adds a cell to the cluster
     *
     * @param clusterId the id of the cluster which the cell will be added to
     * @param cell      the cell which we will be adding to the cluster
     * @return message to show the adding was successful
     * @throws MissingException when the cluster doesn't exist
     * @see MissingException#getMessage()
     */
    @Override
    public String addCellToCluster(String clusterId, Cellular cell) {
        if (!clusters.containsKey(clusterId)) {
            throw new MissingException(String.format(ExceptionMessages.MISSING_FAIL, "Cluster", clusterId));
        }

        clusters.get(clusterId).addCell(cell);
        return String.format(OutputMessages.ADD_CELL_TO_CLUSTER_IN_ORGANISM, name, clusterId, cell.getId());
    }

    /**
     * Active the first found non-activated cluster
     * If all clusters are activated make them non-activated
     *
     * @return message to show the activation was successful
     * @throws ClusterActivationFailureException if the activation was a failure
     * @see ClusterActivationFailureException#getMessage()
     */
    @Override
    public String activateCluster() {

        if (getNumberOfActivatedClusters() == activatedClusters.size()) {
            resetAllClustersToInactivated();
        }

        for (Map.Entry<String, Clustercentric> clusterSet : clusters.entrySet()) {
            String id = clusterSet.getKey();

            if (!isClusterActivated(id)) {
                int cellsLeft = clusters.get(id).activate();
                activatedClusters.put(id, true);
                return String.format(OutputMessages.ACTIVATED_CLUSTER, name, id, cellsLeft);
            }
        }

        throw new ClusterActivationFailureException();
    }

    /**
     * Get the number of activated clusters
     *
     * @return the number of activated clusters
     */
    private int getNumberOfActivatedClusters() {
        int countOfActivatedClusters = 0;
        for (Map.Entry<String, Clustercentric> clusterSet : clusters.entrySet()) {
            String id = clusterSet.getKey();

            if (isClusterActivated(id)) {
                countOfActivatedClusters++;
            }
        }

        return countOfActivatedClusters;
    }

    /**
     * Make all cluster non-activated
     */
    private void resetAllClustersToInactivated() {
        for (Map.Entry<String, Clustercentric> clusterSet : clusters.entrySet()) {
            String id = clusterSet.getKey();

            if (isClusterActivated(id)) {
                activatedClusters.put(clusterSet.getKey(), false);
            }
        }
    }

    /**
     * Check if cluster is activated
     *
     * @param id the id of the cluster
     * @return true if it is activated otherwise false
     */
    private boolean isClusterActivated(String id) {
        return activatedClusters.get(id);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Organism - " + name + "\n");
        builder.append("--Clusters: " + clusters.size() + "\n");
        builder.append("--Cells: " + getTotalCells() + "\n");

        for (Map.Entry<String, Clustercentric> set : clusters.entrySet()) {
            builder.append(set.getValue() + "\n");
            //builder.delete(builder.length() - 2, builder.length());
        }

        //builder.delete(builder.length() - 2, builder.length());
        return builder.toString();
    }

    /**
     * Get total number of cells
     *
     * @return the count of total cells in all clusters
     * @see Cluster#getCellsCount()
     */
    private int getTotalCells() {
        int sum = 0;
        for (Map.Entry<String, Clustercentric> clusterSet : clusters.entrySet()) {
            Clustercentric cluster = clusterSet.getValue();
            sum += cluster.getCellsCount();
        }

        return sum;
    }
}
