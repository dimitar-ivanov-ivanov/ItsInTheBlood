package com.company.core;

import com.company.common.ExceptionWrapper;
import com.company.exceptions.InputFailure;
import com.company.exceptions.modelsExceptions.AlreadyExistsException;
import com.company.exceptions.modelsExceptions.MissingException;
import com.company.interfaces.CommandInterpreter;
import com.company.interfaces.Executable;
import com.company.messages.OutputMessages;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;
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

                if(data.length == 9 && data[8].equals("60")){
                    //System.out.println();
                }

                Executable exe = commandInterpreter.interpretCommand(data, commandName);
                ExceptionWrapper wrapper = new ExceptionWrapper(exe);
                String result = wrapper.runExecutable();
                System.out.println(result);
            } catch (InputFailure failure) {
                System.out.println(failure.getMessage());
            }
        }
    }
}
