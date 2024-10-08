package oop;

public enum EyeColors {
    BROWN ("Brown"),
    BLUE ("Blue"),
    VIOLET ("Violet"),
    HAZEL ("Hazel");

    private String value;

    EyeColors(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EyeColors parse(String text) {
        for (EyeColors eyeColor : EyeColors.values()) {
            if (eyeColor.value.equalsIgnoreCase(text)) {
                return eyeColor;
            }
        }
        return null;
    }
}
