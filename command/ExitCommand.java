package oop.command;

import oop.exception.AbortException;

import java.util.ArrayList;

public class ExitCommand implements Command {

    @Override
    public void execute(ArrayList<String> commandArguments) throws AbortException {
        throw new AbortException();
    }
}
