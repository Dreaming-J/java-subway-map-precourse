package subway.controller.subController;

import subway.controller.Controller;
import subway.domain.LineRepository;
import subway.enums.SubOption;
import subway.module.RepeatModule;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.EnumMap;
import java.util.Map;

public class SectionController extends RepeatModule implements Controller {

    private final Map<SubOption, Runnable> methods;
    private final InputView inputView;
    private final OutputView outputView;

    public SectionController(InputView inputView, OutputView outputView) {
        this.methods = new EnumMap<>(SubOption.class);
        this.inputView = inputView;
        this.outputView = outputView;
        initMethods();
    }

    private void initMethods() {
        this.methods.put(SubOption.REGISTER, this::register);
        this.methods.put(SubOption.REMOVE, this::remove);
        this.methods.put(SubOption.GOBACK, this::goBack);
    }

    @Override
    public void process() {
        outputView.printSectionScreen();
        SubOption subOption = repeat(inputView::readSectionFunction);
        methods.get(subOption).run();
    }

    private void register() {
        try {
            String lineName = inputView.readLineNameToRegisterSection();
            String stationName = inputView.readStationNameToRegisterSection(lineName);
            int order = inputView.readOrderToRegisterSection(lineName);
            LineRepository.findLine(lineName).addSection(stationName, order);
            outputView.printRegisterSection();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMsg(e.getMessage());
        }
    }

    private void remove() {
        try {
            String lineName = inputView.readLineNameToRemoveSection();
            String stationName = inputView.readStationNameToRemoveSection(lineName);
            LineRepository.findLine(lineName).deleteSection(stationName);
            outputView.printRemoveSection();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMsg(e.getMessage());
        }
    }

    private void goBack() {
        return;
    }
}