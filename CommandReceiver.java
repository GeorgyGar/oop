package oop;

import oop.exception.AbortException;
import oop.exception.PrincessException;

import java.util.Scanner;

public class CommandReceiver {
    private CommandExecutor executor;

    public CommandReceiver(PrincessRepository repository, PrincessParser parser, Validator validator) {
        this.executor = new CommandExecutor(repository, parser, validator);
    }

    public void receiveCommands(Scanner in) throws PrincessException {
        while (true) {
            System.out.println("Enter the command:");
            String commandName = in.next();
            try {
                executor.executeCommand(in, commandName);
            }
            catch (AbortException e) {
                break;
            }
        }
    }
}
