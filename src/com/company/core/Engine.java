package com.company.core;

import com.company.common.ExceptionWrapper;
import com.company.exceptions.InputFailureException;
import com.company.core.commands.interfaces.CommandInterpreter;
import com.company.core.commands.interfaces.Executable;
import com.company.messages.OutputMessages;

import java.util.Scanner;

/**
 * The type Engine.
 *
 * @author Dimtiar Ivanov
 * @version 1.4
 * @see Runnable
 */
public class Engine implements Runnable {

    /**
     * Command interpreter that handles all lines of input
     */
    private CommandInterpreter commandInterpreter;

    /**
     * Instantiates a new Engine.
     *
     * @param commandInterpreter the command interpreter
     */
    public Engine(CommandInterpreter commandInterpreter) {
        this.commandInterpreter = commandInterpreter;
    }

    /**
     * Scan the console and unless we get the end command use the command interpreter to get a command and
     * wrap that command in a wrapper for exceptions if it throws an exception catch it and print the exception message
     * If it doesn't throw execute the command
     */
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                String input = scanner.nextLine();

                if (input.equals(OutputMessages.END_INPUT)) {
                    break;
                }

                String[] data = input.split("\\s+");
                String commandName = data[0];

                Executable exe = commandInterpreter.interpretCommand(data, commandName);
                ExceptionWrapper wrapper = new ExceptionWrapper(exe);
                String result = wrapper.runExecutable();
                System.out.println(result);
            } catch (InputFailureException failure) {
                System.out.println(failure.getMessage());
            }
        }
    }
}
