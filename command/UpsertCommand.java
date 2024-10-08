package oop.command;

import oop.Validator;

import java.util.ArrayList;

public abstract class UpsertCommand implements Command{
    private Validator validator;

    @Override
    public void execute(ArrayList<String> commandArguments) {
        if (commandArguments.size() != 5 || !validator.isNumber(commandArguments.get(0)) ||
                !validator.isNumber(commandArguments.get(2))) {
            System.err.println("The string was entered in the wrong format");
            return;
        }
        if (!validator.check(commandArguments)) {
            return;
        }
        executeUpsert(commandArguments);
    }

    public UpsertCommand(Validator validator) {
        this.validator = validator;
    }

    protected abstract void executeUpsert(ArrayList<String> commandArguments);
}
