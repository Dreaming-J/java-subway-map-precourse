package subway.domain;

public class Station {

    private static final int ZERO = 0;

    private String name;
    private int numberAddedInLine;

    public Station(String name) {
        this.name = name;
        this.numberAddedInLine = 0;
        StationRepository.addStation(this);
    }

    public String getName() {
        return name;
    }

    public void addedInLine() {
        numberAddedInLine++;
    }

    public void deletedInLine() {
        numberAddedInLine--;
    }

    public boolean canDelete() {
        return numberAddedInLine == ZERO;
    }
}
