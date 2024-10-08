package oop.command;

import oop.Princess;
import oop.PrincessRepository;
import oop.Validator;

public class GetCommand extends IdCommand {
    private PrincessRepository repository;

    public GetCommand(PrincessRepository repository, Validator validator) {
        this.repository = repository;
        setValidator(validator);
    }

    @Override
    protected void executeId(int id) {
        Princess princess = repository.get(id);
        if (princess != null) {
            System.out.printf("%s\nAge: %d\nHair: %s\nEyes: %s%n%n", princess.getName(), princess.getAge(),
                    princess.getHairColor().getValue(), princess.getEyeColor().getValue());
        }
    }
}
