package subway.message;

public enum ErrorMsg {
    ERROR_MSG_WRONG_FUNCTION("선택할 수 없는 기능입니다."),
    ERROR_MSG_NAME_LENGTH_IS_LESS_THAN_TWO("이름은 2글자 이상이어야 합니다."),
    ERROR_MSG_STATION_IS_NOT_EXISTED("해당 역은 존재하지 않습니다."),
    ERROR_MSG_STATION_CAN_NOT_REMOVE("해당 역은 노선에 등록되어 있어 삭제할 수 없습니다."),
    ERROR_MSG_DUPLICATED_STATION_NAME("이미 등록된 역 이름입니다."),
    ERROR_MSG_DUPLICATED_LINE_NAME("이미 등록된 노선 이름입니다."),
    ERROR_MSG_UP_AND_DOWN_TERMINAL_IS_NOT_ALLOWED_SAME("상행 종점역과 하행 종점역은 서로 달라야 합니다."),
    ERROR_MSG_LINE_IS_NOT_EXISTED("해당 노선은 존재하지 않습니다."),
    ERROR_MSG_STATION_ALREADY_REGISTER_IN_LINE("해당 역은 이미 노선에 등록되어 있습니다."),
    ERROR_MSG_ORDER_IS_NOT_NUMBER("숫자만 입력해주세요."),
    ERROR_MSG_ORDER_IS_OUT_OF_RANGE_IN_LINE("해당 노선에서 선택할 수 있는 범위를 벗어났습니다."),
    ERROR_MSG_LINE_SIZE_IS_2_OR_LESS("해당 노선에서 더 이상 구간을 삭제할 수 없습니다."),
    ERROR_MSG_STATION_NOT_REGISTER_IN_LINE("해당 역은 노선에 등록되어 있지 않습니다.");


    private final String message;

    ErrorMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
