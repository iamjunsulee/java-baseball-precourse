package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private final List<Integer> numbers;
    private final static int MAX_SIZE = 3;

    public Player() {
        numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(String inputNumbers) {
        if (inputNumbers.length() != MAX_SIZE) {
            throw new IllegalArgumentException("3자리수를 입력해야 합니다.");
        }
        Set<Integer> noDuplicateNumbers = new HashSet<>();
        for (char input : inputNumbers.toCharArray()) {
            int number = Integer.parseInt(String.valueOf(input));
            noDuplicateNumbers.add(number);
        }
        if (noDuplicateNumbers.size() != 3) {
            throw new IllegalArgumentException("중복되는 입력값이 있습니다.");
        }
        for (char input : inputNumbers.toCharArray()) {
            int number = Integer.parseInt(String.valueOf(input));
            this.numbers.add(number);
        }
    }
}
