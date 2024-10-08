package oop.command;

import oop.exception.PrincessException;

import java.util.ArrayList;

public interface Command {
    void execute(ArrayList<String> commandArguments) throws PrincessException;
}
