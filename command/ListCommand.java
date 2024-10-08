package oop.command;

import oop.Princess;
import oop.PrincessRepository;

import java.util.ArrayList;

public class ListCommand implements Command {
    private PrincessRepository repository;

    public ListCommand(PrincessRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(ArrayList<String> commandArguments) {
        for (Princess princess : repository.read()) {
            System.out.println(princess.toString());
        }
    }
}
