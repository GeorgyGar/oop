package oop.command;

import oop.Princess;
import oop.PrincessParser;
import oop.PrincessRepository;
import oop.Validator;

import java.util.ArrayList;

public class UpdateCommand extends UpsertCommand {
    private PrincessRepository repository;
    private PrincessParser parser;

    public UpdateCommand(PrincessRepository repository, PrincessParser parser, Validator validator) {
        super(validator);
        this.repository = repository;
        this.parser = parser;
    }

    @Override
    public void executeUpsert(ArrayList<String> commandArguments) {
        Princess princess = parser.parsePrincess(commandArguments);
        String name = repository.update(princess);
        if (name != null) {
            System.out.println("Princess \"" + name + "\" has been updated.");
        }
    }
}
