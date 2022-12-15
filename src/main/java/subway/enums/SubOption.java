package subway.enums;

import java.util.stream.Stream;

public enum SubOption {
    REGISTER("1"),
    REMOVE("2"),
    SERCH("3"),
    GOBACK("B");

    private final String command;

    SubOption(String command) {
        this.command = command;
    }

    public static boolean contains(String command) {
        return Stream.of(values())
                .anyMatch(option -> option.command.equals(command));
    }

    public static boolean containsWhenSection(String command) {
        return Stream.of(values())
                .filter(option -> option != SERCH)
                .anyMatch(option -> option.command.equals(command));
    }

    public static SubOption from(String command) {
        return Stream.of(values())
                .filter(option -> option.command.equals(command))
                .findFirst()
                .get();
    }
}
