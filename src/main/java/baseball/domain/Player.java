package baseball.domain;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private final Set<Integer> numbers;
    private final static int MAX_SIZE = 3;

    public Player() {
        numbers = new HashSet<>();
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(String inputNumbers) {
        if (inputNumbers.length() != MAX_SIZE) {
            throw new IllegalArgumentException("3자리수를 입력해야 합니다.");
        }
        for (int index = 0; index < MAX_SIZE; index++) {
            int number = inputNumbers.charAt(index) - '0';
            this.numbers.add(number);
        }
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("중복되는 입력값이 있습니다.");
        }
    }
}
