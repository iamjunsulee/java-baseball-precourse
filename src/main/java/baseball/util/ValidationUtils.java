package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtils {
    private final static int MAX_SIZE = 3;

    public static void validateNumbers(String inputNumbers) {
        checkNumberFormat(inputNumbers);
        checkSize(inputNumbers);
        checkDuplicateNumbers(inputNumbers);
    }

    private static void checkSize(String inputNumbers) {
        if (inputNumbers.length() != MAX_SIZE) {
            throw new IllegalArgumentException("3자리수를 입력해야 합니다.");
        }
    }

    private static void checkDuplicateNumbers(String inputNumbers) {
        Set<Integer> noDuplicateNumbers = new HashSet<>();
        for (char input : inputNumbers.toCharArray()) {
            int number = Integer.parseInt(String.valueOf(input));
            noDuplicateNumbers.add(number);
        }
        if (noDuplicateNumbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException("중복되는 입력값이 있습니다.");
        }
    }

    private static void checkNumberFormat(String inputNumbers) {
        if (!inputNumbers.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("숫자만 입력가능합니다.");
        }
    }
}
