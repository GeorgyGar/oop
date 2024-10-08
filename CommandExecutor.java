package oop;

import oop.command.*;
import oop.exception.PrincessException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandExecutor {
    private Map<String, Command> commands = new HashMap<>();

    public CommandExecutor(PrincessRepository repository, PrincessParser parser, Validator validator) {
        commands.put("list", new ListCommand(repository));
        commands.put("add", new AddCommand(repository, parser, validator));
        commands.put("get", new GetCommand(repository, validator));
        commands.put("delete", new DeleteCommand(repository, validator));
        commands.put("update", new UpdateCommand(repository, parser, validator));
        commands.put("exit", new ExitCommand());
    }

    public void executeCommand(Scanner in, String commandName) throws PrincessException {
        String commandText = in.nextLine();
        Command command = commands.get(commandName);
        if (command != null) {
            ArrayList<String> commandArguments = parseCommandText(commandText);
            command.execute(commandArguments);
        }
        else {
            System.err.println("The command " + commandName + " was not found");
        }
    }

    public ArrayList<String> parseCommandText(String commandLine) {
        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");
        Matcher matcher = pattern.matcher(commandLine.trim());
        ArrayList<String> values = new ArrayList<>();

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                values.add(matcher.group(1));
            } else if (matcher.group(2) != null) {
                values.add(matcher.group(2));
            }
        }

        return values;
    }
}
