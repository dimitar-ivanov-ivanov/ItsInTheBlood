package com.company.core.commands.interfaces;

public interface CommandInterpreter {

    Executable interpretCommand(String[] data, String commandName);
}
