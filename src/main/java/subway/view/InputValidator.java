package subway.view;

import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.enums.MainOption;
import subway.enums.SubOption;

import java.util.Objects;

import static subway.message.ErrorMsg.*;

public class InputValidator {

    private static final int LOWER_STATION_NAME_INCLUSIVE = 2;
    private static final int LOWER_SECTION_SIZE_INCLUSIVE = 2;
    private static final int ZERO = 0;

    public void validateMainFunction(String input) {
        if (not(MainOption.contains(input))) {
            throw new IllegalArgumentException(ERROR_MSG_WRONG_FUNCTION.get());
        }
    }

    public void validateStationAndLineFunction(String input) {
        if (not(SubOption.contains(input))) {
            throw new IllegalArgumentException(ERROR_MSG_WRONG_FUNCTION.get());
        }
    }

    // 지하철 역 관리
    public void validateStationNameToRegister(String input) {
        if (input.length() < LOWER_STATION_NAME_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_MSG_NAME_LENGTH_IS_LESS_THAN_TWO.get());
        }
        if (StationRepository.isDuplicated(input)) {
            throw new IllegalArgumentException(ERROR_MSG_DUPLICATED_STATION_NAME.get());
        }
    }

    public void validateStationNameToRemove(String input) {
        if (not(StationRepository.isDuplicated(input))) {
            throw new IllegalArgumentException(ERROR_MSG_STATION_IS_NOT_EXISTED.get());
        }
        if (not(StationRepository.findStation(input).canDelete())) {
            throw new IllegalArgumentException(ERROR_MSG_STATION_CAN_NOT_REMOVE.get());
        }
    }

    // 지하철 노선 관리
    public void validateLineNameToRegister(String input) {
        if (input.length() < LOWER_STATION_NAME_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_MSG_NAME_LENGTH_IS_LESS_THAN_TWO.get());
        }
        if (LineRepository.isDuplicated(input)) {
            throw new IllegalArgumentException(ERROR_MSG_DUPLICATED_LINE_NAME.get());
        }
    }

    public void validateUpTerminal(String input) {
        if (not(StationRepository.isDuplicated(input))) {
            throw new IllegalArgumentException(ERROR_MSG_STATION_IS_NOT_EXISTED.get());
        }
    }

    public void validateDownTerminal(String input, String upTerminal) {
        validateUpTerminal(input);
        if (Objects.equals(input, upTerminal)) {
            throw new IllegalArgumentException(ERROR_MSG_UP_AND_DOWN_TERMINAL_IS_NOT_ALLOWED_SAME.get());
        }
    }

    public void validateLineNameToRemove(String input) {
        if (not(LineRepository.isDuplicated(input))) {
            throw new IllegalArgumentException(ERROR_MSG_LINE_IS_NOT_EXISTED.get());
        }
    }

    // 지하철 구간 관리
    public void validateSectionFunction(String input) {
        if (not(SubOption.containsWhenSection(input))) {
            throw new IllegalArgumentException(ERROR_MSG_WRONG_FUNCTION.get());
        }
    }

    public void validateStationNameToRegisterSection(String input, String lineName) {
        validateUpTerminal(input);
        if (LineRepository.findLine(lineName).containStation(input)) {
            throw new IllegalArgumentException(ERROR_MSG_STATION_ALREADY_REGISTER_IN_LINE.get());
        }
    }

    public void validateOrderToRegisterSection(int input, String lineName) {
        int lineSize = LineRepository.findLine(lineName).getSections().size();
        if (input < ZERO || input > lineSize) {
            throw new IllegalArgumentException(ERROR_MSG_ORDER_IS_OUT_OF_RANGE_IN_LINE.get());
        }
    }

    public void validateLineNameToRemoveSection(String input) {
        validateLineNameToRemove(input);
        if (LineRepository.findLine(input).getSections().size() == LOWER_SECTION_SIZE_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_MSG_LINE_SIZE_IS_2_OR_LESS.get());
        }
    }

    public void validateStationNameToRemoveSection(String input, String lineName) {
        validateUpTerminal(input);
        if (not(LineRepository.findLine(lineName).containStation(input))) {
            throw new IllegalArgumentException(ERROR_MSG_STATION_NOT_REGISTER_IN_LINE.get());
        }
    }

    // 기타
    public int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MSG_ORDER_IS_NOT_NUMBER.get());
        }
    }

    private boolean not(boolean bool) {
        return !bool;
    }
}
