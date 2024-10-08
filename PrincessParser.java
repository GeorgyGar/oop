package oop;

import java.util.ArrayList;

public class PrincessParser {

    public Princess parsePrincess(ArrayList<String> value) {
        return new Princess(Integer.parseInt(value.get(0)), value.get(1), Integer.parseInt(value.get(2)),
                HairColors.parse(value.get(3)), EyeColors.parse(value.get(4)));
    }
}
