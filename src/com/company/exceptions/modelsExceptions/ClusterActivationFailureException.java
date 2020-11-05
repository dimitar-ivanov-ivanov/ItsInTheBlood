package com.company.exceptions.modelsExceptions;

import com.company.messages.ExceptionMessages;

public class ClusterActivationFailureException extends RuntimeException {
    @Override
    public String getMessage() {
        return ExceptionMessages.CLUSTER_ACTIVATION_FAILURE;
    }
}
