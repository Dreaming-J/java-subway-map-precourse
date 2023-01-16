package subway.message;

public enum InputMsg {
    INPUT_MSG_SELECT_FUNCTION("\n## 원하는 기능을 선택하세요."),
    INPUT_MSG_STATION_REGISTER("\n## 등록할 역 이름을 입력하세요."),
    INPUT_MSG_STATION_REMOVE("\n## 삭제할 역 이름을 입력하세요."),
    INPUT_MSG_LINE_REGISTER("\n## 등록할 노선 이름을 입력하세요."),
    INPUT_MSG_LINE_REMOVE("\n## 삭제할 노선 이름을 입력하세요."),
    INPUT_MSG_LINE_UP_TERMINAL("\n## 등록할 노선의 상행 종점역 이름을 입력하세요."),
    INPUT_MSG_LINE_DOWN_TERMINAL("\n## 등록할 노선의 하행 종점역 이름을 입력하세요."),
    INPUT_MSG_SECTION_ADDED_LINE("\n## 노선을 입력하세요."),
    INPUT_MSG_SECTION_ADDED_STATION("\n## 역이름을 입력하세요."),
    INPUT_MSG_SECTION_ADDED_ORDER("\n## 순서를 입력하세요."),
    INPUT_MSG_SECTION_DELETED_LINE("\n## 삭제할 구간의 노선을 입력하세요."),
    INPUT_MSG_SECTION_DELETED_STATION("\n## 삭제할 구간의 역을 입력하세요.");

    private final String message;

    InputMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
