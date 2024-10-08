package oop;

import oop.exception.PrincessFileNotFoundException;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrincessLoader {

    public void load(PrincessRepository repository, String fileName)
            throws PrincessFileNotFoundException {
        try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(fileName)))) {
            while (scanner.hasNext()) {
                Princess princess = parseWithSeparators(scanner);
                if (!repository.add(princess)) {
                    System.err.println("A princess with this number already exists");
                }
            }
        }
        catch (FileNotFoundException e) {
            throw new PrincessFileNotFoundException("File " + fileName + " not found");
        }
    }

    public Princess parseWithSeparators(Scanner in) {
        Princess princess;

        String[] values = in.nextLine().split(" \\| ");
        princess = new Princess(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]),
                HairColors.parse(values[3]), EyeColors.parse(values[4]));

        return princess;
    }
}
