package baseball.domain;

import baseball.util.ValidationUtils;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Integer> numbers;

    public Player() {
        numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(String inputNumbers) {
        ValidationUtils.validateNumbers(inputNumbers);
        addNumbers(inputNumbers);
    }

    private void addNumbers(String inputNumbers) {
        for (char input : inputNumbers.toCharArray()) {
            int number = Integer.parseInt(String.valueOf(input));
            this.numbers.add(number);
        }
    }
}
