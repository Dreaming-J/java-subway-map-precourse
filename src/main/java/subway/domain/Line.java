package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private String name;
    private List<Station> sections;

    public Line(String name, List<String> terminal) {
        this.name = name;
        this.sections = new ArrayList<>();
        setTerminal(terminal);
        LineRepository.addLine(this);
    }

    private void setTerminal(List<String> terminal) {
        for (String stationName : terminal) {
            addSection(stationName, -1);
        }
    }

    public String getName() {
        return name;
    }

    public List<Station> getSections() {
        return Collections.unmodifiableList(sections);
    }

    public boolean containStation(String stationName) {
        return sections.stream()
                .map(Station::getName)
                .anyMatch(name -> Objects.equals(name, stationName));
    }

    public void addSection(String stationName, int order) {
        // order == -1, 마지막에 추가
        Station station = StationRepository.findStation(stationName);
        station.addedInLine();

        if (order == -1) {
            sections.add(station);
            return;
        }
        sections.add(order, station);
    }

    public void deleteSection(String stationName) {
        Station station = StationRepository.findStation(stationName);
        station.deletedInLine();

        sections.remove(station);
    }

    public void dettachStationInLine() {
        sections.forEach(Station::deletedInLine);
    }
}
