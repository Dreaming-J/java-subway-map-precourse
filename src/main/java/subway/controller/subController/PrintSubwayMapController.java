package subway.controller.subController;

import subway.controller.Controller;
import subway.module.RepeatModule;
import subway.view.InputView;
import subway.view.OutputView;

public class PrintSubwayMapController extends RepeatModule implements Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public PrintSubwayMapController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        outputView.printSubwayMap();
    }
}