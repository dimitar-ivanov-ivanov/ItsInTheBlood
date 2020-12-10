package com.company.core.InputOutput;

import com.company.core.InputOutput.interfaces.Reader;

import java.io.Console;
import java.util.Scanner;

public class ConsoleReader implements Reader {
    Scanner scanner;

    public ConsoleReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
