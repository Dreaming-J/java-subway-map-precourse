package subway.view;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import static subway.message.OutputMsg.*;

public class OutputView {

    private static final String ERROR_PREFIX = "\n[ERROR] ";
    private static final String SUCCESS_PREFIX = "\n[INFO] ";
    private static final String BLANK = "";
    private static final String HYPON = "---";

    public void printErrorMsg(String message) {
        try {
            throw new IllegalArgumentException(ERROR_PREFIX + message);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printMainScreen() {
        System.out.println(OUTPUT_MSG_MAIN_SCREEN.get());
    }

    // 지하철 역 관리
    public void printStationScreen() {
        System.out.println(OUTPUT_MSG_STATION_SCREEN.get());
    }

    public void printRegisterStation() {
        System.out.println(SUCCESS_PREFIX + OUTPUT_MSG_SUCCESS_REGISTER_STATION.get());
    }

    public void printRemoveStation() {
        System.out.println(SUCCESS_PREFIX + OUTPUT_MSG_SUCCESS_REMOVE_STATION.get());
    }

    public void printStationList() {
        System.out.print(OUTPUT_MSG_STATION_LIST.get());
        for (Station station : StationRepository.stations()) {
            System.out.print(SUCCESS_PREFIX + station.getName());
        }
        System.out.println(BLANK);
    }

    // 지하철 노선 관리
    public void printLineScreen() {
        System.out.println(OUTPUT_MSG_LINE_SCREEN.get());
    }

    public void printRegisterLine() {
        System.out.println(SUCCESS_PREFIX + OUTPUT_MSG_SUCCESS_REGISTER_LINE.get());
    }

    public void printRemoveLine() {
        System.out.println(SUCCESS_PREFIX + OUTPUT_MSG_SUCCESS_REMOVE_LINE.get());
    }

    public void printLineList() {
        System.out.print(OUTPUT_MSG_LINE_LIST.get());
        for (Line line : LineRepository.lines()) {
            System.out.print(SUCCESS_PREFIX + line.getName());
        }
        System.out.println(BLANK);
    }

    // 지하철 구간 관리
    public void printSectionScreen() {
        System.out.println(OUTPUT_MSG_SECTION_SCREEN.get());
    }

    public void printRegisterSection() {
        System.out.println(SUCCESS_PREFIX + OUTPUT_MSG_SUCCESS_REGISTER_SECTION.get());
    }

    public void printRemoveSection() {
        System.out.println(SUCCESS_PREFIX + OUTPUT_MSG_SUCCESS_REMOVE_SECTION.get());
    }

    // 지하철 노선도 출력
    public void printSubwayMap() {
        System.out.print(OUTPUT_MSG_SUBWAY_MAP.get());
        for (Line line : LineRepository.lines()) {
            System.out.print(SUCCESS_PREFIX + line.getName());
            System.out.print(SUCCESS_PREFIX + HYPON);
            for (Station station : line.getSections()) {
                System.out.print(SUCCESS_PREFIX + station.getName());
            }
            System.out.println(BLANK);
        }
    }
}
