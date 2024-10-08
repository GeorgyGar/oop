package oop;

import oop.exception.PrincessException;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        PrincessRepository repository = new PrincessRepository();
        Validator validator = new Validator();
        PrincessParser parser = new PrincessParser();
        CommandReceiver receiver = new CommandReceiver(repository, parser, validator);
        PrincessLoader princessLoader = new PrincessLoader();

        try {
            princessLoader.load(repository, "oop/disney-princesses.txt");
            receiver.receiveCommands(in);
        }
        catch (PrincessException e) {
            System.err.println(e.getMessage());
        }
        finally {
            in.close();
        }
    }
}


