package subway.module;

import java.util.function.Supplier;

public class RepeatModule {

    private static final String ERROR_PREFIX = "\n[ERROR] ";

    protected <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return repeat(inputReader);
        }
    }
}
