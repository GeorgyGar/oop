package oop.command;

import oop.Princess;
import oop.PrincessParser;
import oop.PrincessRepository;
import oop.Validator;

import java.util.ArrayList;

public class AddCommand extends UpsertCommand {
    private PrincessRepository repository;
    private PrincessParser parser;

    public AddCommand(PrincessRepository repository, PrincessParser parser, Validator validator) {
        super(validator);
        this.repository = repository;
        this.parser = parser;
    }

    @Override
    public void executeUpsert(ArrayList<String> commandArguments) {
        Princess princess = parser.parsePrincess(commandArguments);
        if (!repository.add(princess)) {
            System.err.println("A princess with this number already exists");
        }
        else {
            System.out.println("Princess \"" + princess.getName() + "\" has been added.");
        }
    }
}
