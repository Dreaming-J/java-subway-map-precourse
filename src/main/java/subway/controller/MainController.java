package subway.controller;

import subway.controller.subController.*;
import subway.controller.subController.StationController;
import subway.enums.MainOption;
import subway.module.RepeatModule;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.EnumMap;
import java.util.Map;

public class MainController extends RepeatModule {

    private final Map<MainOption, Controller> controllers;
    private final InputView inputView;
    private final OutputView outputView;

    public MainController() {
        this.controllers = new EnumMap<>(MainOption.class);
        this.inputView = new InputView();
        this.outputView = new OutputView();
        initControllers();
    }

    private void initControllers() {
        controllers.put(MainOption.STATION_MANAGEMENT, new StationController(inputView, outputView));
        controllers.put(MainOption.LINE_MANAGEMENT, new LineController(inputView, outputView));
        controllers.put(MainOption.SECTION_MANAGEMENT, new SectionController(inputView, outputView));
        controllers.put(MainOption.PRINT_SUBWAY_MAP, new PrintSubwayMapController(inputView, outputView));
        controllers.put(MainOption.APPLICATION_QUIT, new ApplicationQuitController());
    }

    public void service() {
        new InitializingController().process();
        MainOption mainOption;
        do {
            outputView.printMainScreen();
            mainOption = repeat(inputView::readMainFucntion);
            controllers.get(mainOption).process();
        } while (mainOption.isPlayable());
    }
}
