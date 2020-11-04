package com.company.core;

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

                if (commandName.equals("addCell")) {
                    //System.out.println();
                }

                Executable exe = commandInterpreter.interpretCommand(data, commandName);
                String result = exe.execute();
                System.out.println(result);
            } catch (AlreadyExistsException | MissingException e) {
                System.out.println(e.getMessage());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ExecutionControl.NotImplementedException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
