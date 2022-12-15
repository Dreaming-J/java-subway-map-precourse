package subway.controller;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.Line;

import java.util.List;
import java.util.stream.Stream;

public class InitializingController implements Controller {

    @Override
    public void process() {
        initStation();
        initLine();
    }

    private void initStation() {
        Stream.of(BuiltInStation.values())
                .map(station -> station.name)
                .forEach(Station::new);
    }

    private void initLine() {
        for (BuiltInLine line : BuiltInLine.values()) {
            new Line(line.name, line.section);
        }
    }

    private enum BuiltInStation {
        GYO_DAE("교대역"),
        GANG_NAM("강남역"),
        YEOG_SAM("역삼역"),
        NAM_BU_TERMINAL("남부터미널역"),
        YANG_JAE("양재역"),
        YANG_JAE_FOREST("양재시민의숲역"),
        MAE_BONG("매봉역");

        private final String name;

        BuiltInStation(String name) {
            this.name = name;
        }
    }

    private enum BuiltInLine {
        LINE_TWO("2호선", List.of("교대역", "강남역", "역삼역")),
        LINE_THREE("3호선", List.of("교대역", "남부터미널역", "양재역", "매봉역")),
        LINE_SINBUNDANG("신분당선", List.of("강남역", "양재역", "양재시민의숲역"));

        private final String name;
        private final List<String> section;

        BuiltInLine(String name, List<String> section) {
            this.name = name;
            this.section = section;
        }
    }
}