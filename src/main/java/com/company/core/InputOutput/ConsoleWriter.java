package com.company.core.InputOutput;

import com.company.core.InputOutput.interfaces.Writer;

import java.util.Scanner;

public class ConsoleWriter implements Writer {

    public ConsoleWriter() { }

    @Override
    public void write(Object obj) {
        System.out.println(obj);
    }
}
