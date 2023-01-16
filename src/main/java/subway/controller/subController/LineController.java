package subway.controller.subController;

import subway.controller.Controller;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.enums.SubOption;
import subway.module.RepeatModule;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.*;

public class LineController extends RepeatModule implements Controller {

    private final Map<SubOption, Runnable> methods;
    private final InputView inputView;
    private final OutputView outputView;

    public LineController(InputView inputView, OutputView outputView) {
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
        outputView.printLineScreen();
        SubOption subOption = repeat(inputView::readStationAndLineFucntion);
        methods.get(subOption).run();
    }

    private void register() {
        try {
            String lineName = inputView.readLineNameToRegister();
            List<String> terminals = createTerminal();
            new Line(lineName, terminals);
            outputView.printRegisterLine();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMsg(e.getMessage());
        }
    }

    private List<String> createTerminal() {
        List<String> terminals = new ArrayList<>();
        String upTerminal = inputView.readUpTerminal();
        terminals.add(upTerminal);
        terminals.add(inputView.readDownTerminal(upTerminal));

        return terminals;
    }

    private void remove() {
        try {
            String lineName = inputView.readLineNameToRemove();
            Line line = LineRepository.findLine(lineName);
            line.dettachStationInLine();
            LineRepository.deleteLineByName(line.getName());
            outputView.printRemoveLine();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMsg(e.getMessage());
        }
    }

    private void search() {
        outputView.printLineList();
    }

    private void goBack() {
        return;
    }
}
