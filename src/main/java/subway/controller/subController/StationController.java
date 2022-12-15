package subway.controller.subController;

import subway.controller.Controller;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.enums.SubOption;
import subway.module.RepeatModule;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.EnumMap;
import java.util.Map;

public class StationController extends RepeatModule implements Controller {

    private final Map<SubOption, Runnable> methods;
    private final InputView inputView;
    private final OutputView outputView;

    public StationController(InputView inputView, OutputView outputView) {
        this.methods = new EnumMap<>(SubOption.class);
        this.inputView = inputView;
        this.outputView = outputView;
        initMethods();
    }

    private void initMethods() {
        this.methods.put(SubOption.REGISTER, this::register);
        this.methods.put(SubOption.REMOVE, this::remove);
        this.methods.put(SubOption.SERCH, this::search);
        this.methods.put(SubOption.GOBACK, this::goBack);
    }

    @Override
    public void process() {
        outputView.printStationScreen();
        SubOption subOption = repeat(inputView::readStationAndLineFucntion);
        methods.get(subOption).run();
    }

    private void register() {
        try {
            String stationName = inputView.readStationNameToRegister();
            new Station(stationName);
            outputView.printRegisterStation();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMsg(e.getMessage());
        }
    }

    private void remove() {
        try {
            String stationName = inputView.readStationNameToRemove();
            StationRepository.deleteStation(stationName);
            outputView.printRemoveStation();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMsg(e.getMessage());
        }
    }

    private void search() {
        outputView.printStationList();
    }

    private void goBack() {
        return;
    }
}