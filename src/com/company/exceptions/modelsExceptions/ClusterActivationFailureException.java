package com.company.exceptions.modelsExceptions;

import com.company.messages.ExceptionMessages;


/**
 * The type Cluster activation failure exception.
 *
 * @author Dimitar ivanov
 * @since 1.4
 */
public class ClusterActivationFailureException extends RuntimeException {

    /**
     * @return the message of the exception
     * @see ExceptionMessages#CLUSTER_ACTIVATION_FAILURE
     */
    @Override
    public String getMessage() {
        return ExceptionMessages.CLUSTER_ACTIVATION_FAILURE;
    }
}
