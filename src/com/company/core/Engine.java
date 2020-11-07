package com.company.core;

import com.company.common.ExceptionWrapper;
import com.company.exceptions.InputFailureException;
import com.company.core.commands.interfaces.CommandInterpreter;
import com.company.core.commands.interfaces.Executable;
import com.company.messages.OutputMessages;

import java.util.Scanner;

public class Engine implements Runnable {

    private CommandInterpreter commandInterpreter;

    public Engine(CommandInterpreter commandInterpreter) {
        this.commandInterpreter = commandInterpreter;
    }

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

                if (commandName.equals("addCluster") && data[2].equals("B05")) {
                    System.out.println();
                }


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
