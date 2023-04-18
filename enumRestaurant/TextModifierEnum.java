package projectGroup.enumRestaurant;

public enum TextModifierEnum {
    ANSI_RESET("\u001B[0m"),
    ANSI_DESCRIPTION_COLOR_AND_BACKGROUND("\033[38;2;248;244;227;48;2;29;10;28m"),
    ANSI_RED("\u001B[31m"),
    ANSI_BRIGHT_RED("\u001B[91m"),
    ANSI_BRIGHT_YELLOW("\u001B[93m"),
    ANSI_YELLOW ("\u001B[33m"),
    ANSI_PURPLE("\u001B[35m"),
    ANSI_BRIGHT_PURPLE("\u001B[95m"),
    ANSI_ITALIC("\u001B[3m"),
    ANSI_UNDERLINE("\u001B[4m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_BOLD("\u001B[1m");

    private final String string;
    TextModifierEnum(String string){
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
