package oop;

import java.util.ArrayList;

public class Validator {

    public boolean check(ArrayList<String> values) {
        if (Integer.parseInt(values.get(2)) <= 0 || Integer.parseInt(values.get(2)) > 99) {
            System.err.println("The age is entered incorrectly");
            return false;
        }
        if (HairColors.parse(values.get(3)) == null) {
            System.err.println("The hair color was entered incorrectly");
            return false;
        }
        if (EyeColors.parse(values.get(4)) == null) {
            System.err.println("The eye color was entered incorrectly");
            return false;
        }
        return true;
    }

    public boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean checkCorrectnessNumber(String verificationNumber) {
        if (!isNumber(verificationNumber)) {
            System.err.println("The number was entered in the wrong format");
            return false;
        }
        return true;
    }
}
