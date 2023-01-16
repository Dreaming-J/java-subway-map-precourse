package subway.enums;

import java.util.stream.Stream;

public enum MainOption {
    STATION_MANAGEMENT("1"),
    LINE_MANAGEMENT("2"),
    SECTION_MANAGEMENT("3"),
    PRINT_SUBWAY_MAP("4"),
    APPLICATION_QUIT("Q");

    private final String command;

    MainOption(String command) {
        this.command = command;
    }

    public boolean isPlayable() {
        return this != APPLICATION_QUIT;
    }

    public static boolean contains(String command) {
        return Stream.of(values())
                .anyMatch(option -> option.command.equals(command));
    }

    public static MainOption from(String command) {
        return Stream.of(values())
                .filter(option -> option.command.equals(command))
                .findFirst()
                .get();
    }
}
