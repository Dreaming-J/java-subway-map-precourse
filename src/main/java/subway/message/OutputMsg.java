package subway.message;

public enum OutputMsg {
    OUTPUT_MSG_MAIN_SCREEN("\n" +
            "## 메인 화면\n" +
            "1. 역 관리\n" +
            "2. 노선 관리\n" +
            "3. 구간 관리\n" +
            "4. 지하철 노선도 출력\n" +
            "Q. 종료"),
    OUTPUT_MSG_STATION_SCREEN("\n" +
            "## 역 관리 화면\n" +
            "1. 역 등록\n" +
            "2. 역 삭제\n" +
            "3. 역 조회\n" +
            "B. 돌아가기"),
    OUTPUT_MSG_SUCCESS_REGISTER_STATION("지하철 역이 등록되었습니다."),
    OUTPUT_MSG_SUCCESS_REMOVE_STATION("지하철 역이 삭제되었습니다."),
    OUTPUT_MSG_STATION_LIST("\n## 역 목록"),
    OUTPUT_MSG_LINE_SCREEN("\n" +
            "## 노선 관리 화면\n" +
            "1. 노선 등록\n" +
            "2. 노선 삭제\n" +
            "3. 노선 조회\n" +
            "B. 돌아가기"),
    OUTPUT_MSG_SUCCESS_REGISTER_LINE("지하철 노선이 등록되었습니다."),
    OUTPUT_MSG_SUCCESS_REMOVE_LINE("지하철 노선이 삭제되었습니다."),
    OUTPUT_MSG_LINE_LIST("\n## 노선 목록"),
    OUTPUT_MSG_SECTION_SCREEN("\n" +
            "## 구간 관리 화면\n" +
            "1. 구간 등록\n" +
            "2. 구간 삭제\n" +
            "B. 돌아가기"),
    OUTPUT_MSG_SUCCESS_REGISTER_SECTION("구간이 등록되었습니다."),
    OUTPUT_MSG_SUCCESS_REMOVE_SECTION("구간이 삭제되었습니다."),
    OUTPUT_MSG_SUBWAY_MAP("\n## 지하철 노선도");

    private final String message;

    OutputMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
