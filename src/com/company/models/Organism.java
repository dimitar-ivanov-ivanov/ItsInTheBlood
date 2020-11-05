package com.company.models;

import com.company.exceptions.fieldsExceptions.InvalidNameException;
import com.company.exceptions.modelsExceptions.AlreadyExistsException;
import com.company.exceptions.modelsExceptions.ClusterActivationFailureException;
import com.company.exceptions.modelsExceptions.MissingException;
import com.company.interfaces.Cellular;
import com.company.interfaces.Clustercentric;
import com.company.interfaces.Organic;
import com.company.messages.ExceptionMessages;
import com.company.messages.OutputMessages;
import com.company.common.StringValidator;

import java.util.HashMap;
import java.util.Map;

public class Organism implements Organic {
    private final String NAME_PATTERN = "^\\b[A-Z][a-z]+\\b$";

    private String name;
    private HashMap<String, Clustercentric> clusters;
    private HashMap<String, Boolean> activatedClusters;

    public Organism(String name) {
        setName(name);
        this.clusters = new HashMap<>();
        this.activatedClusters = new HashMap<>();
    }

    private void setName(String name) {
        if (!StringValidator.validateStringWithPattern(name, NAME_PATTERN)) {
            throw new InvalidNameException();
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String addCluster(Clustercentric cluster) {
        if (clusters.containsKey(cluster.getId())) {
            throw new AlreadyExistsException(String.format(ExceptionMessages.ALREADY_EXISTS_FAIL, "Cluster", cluster.getId()));
        }

        clusters.put(cluster.getId(), cluster);
        activatedClusters.put(cluster.getId(), false);

        return String.format(OutputMessages.ADD_CLUSTER_SUCCESS, name, cluster.getId());
    }

    @Override
    public String addCellToCluster(String clusterId, Cellular cell) {
        if (!clusters.containsKey(clusterId)) {
            throw new MissingException(String.format(ExceptionMessages.MISSING_FAIL, "Cluster", clusterId));
        }

        clusters.get(clusterId).addCell(cell);
        return String.format(OutputMessages.ADD_CELL_TO_CLUSTER_IN_ORGANISM, name, clusterId, cell.getId());
    }

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

    private void resetAllClustersToInactivated() {
        for (Map.Entry<String, Clustercentric> clusterSet : clusters.entrySet()) {
            String id = clusterSet.getKey();

            if (isClusterActivated(id)) {
                activatedClusters.put(clusterSet.getKey(), false);
            }
        }
    }

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

    private int getTotalCells() {
        int sum = 0;
        for (Map.Entry<String, Clustercentric> clusterSet : clusters.entrySet()) {
            Clustercentric cluster = clusterSet.getValue();
            sum += cluster.getCellsCount();
        }

        return sum;
    }
}
