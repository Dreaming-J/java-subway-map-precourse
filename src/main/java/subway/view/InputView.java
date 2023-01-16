package subway.view;

import static subway.message.InputMsg.*;

import camp.nextstep.edu.missionutils.Console;
import subway.enums.MainOption;
import subway.enums.SubOption;

public class InputView {

    private final InputValidator inputValidator = new InputValidator();

    public MainOption readMainFucntion() {
        System.out.println(INPUT_MSG_SELECT_FUNCTION.get());
        String select = Console.readLine();
        inputValidator.validateMainFunction(select);

        return MainOption.from(select);
    }

    public SubOption readStationAndLineFucntion() {
        System.out.println(INPUT_MSG_SELECT_FUNCTION.get());
        String select = Console.readLine();
        inputValidator.validateStationAndLineFunction(select);

        return SubOption.from(select);
    }

    // 지하철 역 관리
    public String readStationNameToRegister() {
        System.out.println(INPUT_MSG_STATION_REGISTER.get());
        String name = Console.readLine();
        inputValidator.validateStationNameToRegister(name);

        return name;
    }

    public String readStationNameToRemove() {
        System.out.println(INPUT_MSG_STATION_REMOVE.get());
        String name = Console.readLine();
        inputValidator.validateStationNameToRemove(name);

        return name;
    }

    // 지하철 노선 관리
    public String readLineNameToRegister() {
        System.out.println(INPUT_MSG_LINE_REGISTER.get());
        String name = Console.readLine();
        inputValidator.validateLineNameToRegister(name);

        return name;
    }

    public String readUpTerminal() {
        System.out.println(INPUT_MSG_LINE_UP_TERMINAL.get());
        String upTerminal = Console.readLine();
        inputValidator.validateUpTerminal(upTerminal);

        return upTerminal;
    }

    public String readDownTerminal(String upTerminal) {
        System.out.println(INPUT_MSG_LINE_DOWN_TERMINAL.get());
        String downTerminal = Console.readLine();
        inputValidator.validateDownTerminal(downTerminal, upTerminal);

        return downTerminal;
    }

    public String readLineNameToRemove() {
        System.out.println(INPUT_MSG_LINE_REMOVE.get());
        String lineName = Console.readLine();
        inputValidator.validateLineNameToRemove(lineName);

        return lineName;
    }

    // 지하철 구간 관리
    public SubOption readSectionFunction() {
        System.out.println(INPUT_MSG_SELECT_FUNCTION.get());
        String select = Console.readLine();
        inputValidator.validateSectionFunction(select);

        return SubOption.from(select);
    }

    public String readLineNameToRegisterSection() {
        System.out.println(INPUT_MSG_SECTION_ADDED_LINE.get());
        String lineName = Console.readLine();
        inputValidator.validateLineNameToRemove(lineName);

        return lineName;
    }

    public String readStationNameToRegisterSection(String lineName) {
        System.out.println(INPUT_MSG_SECTION_ADDED_STATION.get());
        String stationName = Console.readLine();
        inputValidator.validateStationNameToRegisterSection(stationName, lineName);

        return stationName;
    }

    public int readOrderToRegisterSection(String lineName) {
        System.out.println(INPUT_MSG_SECTION_ADDED_ORDER.get());
        int order = inputValidator.convertStringToInt(Console.readLine()) - 1;
        inputValidator.validateOrderToRegisterSection(order, lineName);

        return order;
    }

    public String readLineNameToRemoveSection() {
        System.out.println(INPUT_MSG_SECTION_DELETED_LINE.get());
        String lineName = Console.readLine();
        inputValidator.validateLineNameToRemoveSection(lineName);

        return lineName;
    }

    public String readStationNameToRemoveSection(String lineName) {
        System.out.println(INPUT_MSG_SECTION_DELETED_STATION.get());
        String stationName = Console.readLine();
        inputValidator.validateStationNameToRemoveSection(stationName, lineName);

        return stationName;
    }
}
