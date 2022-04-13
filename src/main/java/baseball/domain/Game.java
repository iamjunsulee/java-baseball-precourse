package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private final List<Integer> numbers;
    private final static int MAX_SIZE = 3;
    private int gameStatus;
    private int strikeCount;
    private int ballCount;

    public Game() {
        numbers = new ArrayList<>();
        generateRandomNumbers();
        setGameStatus(1);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void generateRandomNumbers() {
        Set<Integer> noDuplicateNumbers = new HashSet<>();
        while (noDuplicateNumbers.size() < MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            noDuplicateNumbers.add(randomNumber);
        }
        this.numbers.addAll(noDuplicateNumbers);
    }

    public int getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(int gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void getHintMessage(Player player) {
        String message = "";
        ballCount = 0;
        strikeCount = 0;

        List<Integer> playerNumbers = player.getNumbers();
        for (int i = 0; i < MAX_SIZE; i++) {
            int number = this.numbers.get(i);
            if (playerNumbers.contains(number)) {
                if (playerNumbers.indexOf(number) != i) {
                    ballCount++;
                }
            }
        }
        if (ballCount > 0) {
            message += (ballCount + "볼 ");
        }

        for (int j = 0; j < MAX_SIZE; j++) {
            if (this.numbers.get(j).equals(playerNumbers.get(j))) {
                strikeCount++;
            }
        }
        if (strikeCount == 3) {
            this.gameStatus = 2;
        }
        if (strikeCount > 0) {
            message += (strikeCount + "스트라이크");
        }

        if (ballCount == 0 && strikeCount == 0) {
            message += "낫싱";
        }
        System.out.println(message);
    }
}
