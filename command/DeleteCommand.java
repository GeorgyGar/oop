package oop.command;

import oop.PrincessRepository;
import oop.Validator;

public class DeleteCommand extends IdCommand {
    private PrincessRepository repository;

    public DeleteCommand(PrincessRepository repository, Validator validator) {
        this.repository = repository;
        setValidator(validator);
    }

    @Override
    protected void executeId(int id) {
        String name = repository.delete(id);
        if (name != null) {
            System.out.println("Princess \"" + name + "\" has been removed.");
        }
    }
}
