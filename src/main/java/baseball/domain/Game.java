package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Game {
    private final Set<Integer> numbers;
    private final static int MAX_SIZE = 3;
    private int gameStatus;

    public Game() {
        numbers = new HashSet<>();
        generateRandomNumbers();
        setGameStatus(1);
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    private void generateRandomNumbers() {
        while (numbers.size() < MAX_SIZE) {
            numbers.add(Randoms.pickNumberInRange(1, 9));
        }
    }

    public int getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(int gameStatus) {
        this.gameStatus = gameStatus;
    }
}
