package oop;

public enum HairColors {
    BLACK("Black"),
    BLONDE("Blonde"),
    PLATINUM_BLONDE("Platinum-blonde"),
    STRAWBERRY_BLONDE("Strawberry-blonde"),
    RED("Red"),
    BROWN("Brown");

    private String value;

    HairColors(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static HairColors parse(String text) {
        for (HairColors hairColor : HairColors.values()) {
            if (hairColor.value.equalsIgnoreCase(text)) {
                return hairColor;
            }
        }
        return null;
    }
}