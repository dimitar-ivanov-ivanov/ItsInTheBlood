package com.company.interfaces;

import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public interface OrganicFactory {

    Organic createOrganism(String organismName);

}
