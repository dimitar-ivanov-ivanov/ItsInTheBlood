package com.company.interfaces;

public interface CommandInterpreter {

    Executable interpretCommand(String[] data, String commandName);
}
