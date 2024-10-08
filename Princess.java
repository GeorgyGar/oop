package oop;

public class Princess {
    private int number;
    private String name;
    private int age;
    private HairColors hairColor;
    private EyeColors eyeColor;

    public Princess(int number, String name, int age, HairColors hairColor, EyeColors eyeColor) {
        this.number = number;
        this.name = name;
        this.age = age;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public HairColors getHairColor() {
        return hairColor;
    }

    public EyeColors getEyeColor() {
        return eyeColor;
    }

    @Override
    public String toString() {
        return String.format("\n%d. %s\n   Age: %d\n   Hair: %s\n   Eyes: %s", number, name, age,
                hairColor.getValue(), eyeColor.getValue());
    }
}


