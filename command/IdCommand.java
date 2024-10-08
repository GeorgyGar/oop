package oop.command;

import oop.Validator;

import java.util.ArrayList;

public abstract class IdCommand implements Command {
    private Validator validator;

    @Override
    public void execute(ArrayList<String> commandArguments) {
        if (commandArguments.size() == 0) {
            System.err.println("The string was entered in the wrong format");
            return;
        }
        String testNumber = commandArguments.get(0);
        if (!validator.checkCorrectnessNumber(testNumber)) {
            return;
        }
        int id = Integer.parseInt(testNumber);
        executeId(id);
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    protected abstract void executeId(int id);
}
