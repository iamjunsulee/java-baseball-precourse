package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
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
    private Player player;

    public Game() {
        numbers = new ArrayList<>();
        generateRandomNumbers();
        setGameStatus(1);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(int gameStatus) {
        this.gameStatus = gameStatus;
    }

    private void generateRandomNumbers() {
        Set<Integer> noDuplicateNumbers = new HashSet<>();
        while (noDuplicateNumbers.size() < MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            noDuplicateNumbers.add(randomNumber);
        }
        this.numbers.addAll(noDuplicateNumbers);
    }

    public void playBall() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumbers = Console.readLine();
        this.player = new Player();
        this.player.setNumbers(inputNumbers);
    }

    public int end() {
        int choice = 1;
        if (this.gameStatus == 2) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            choice = Integer.parseInt(Console.readLine());
        }
        return choice;
    }
    public String getGameResultMessage() {
        ballCount = 0;
        strikeCount = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            checkBaseballRule(numbers, this.player.getNumbers(), i);
        }
        if (strikeCount == 3) {
            gameStatus = 2;
        }
        return getHintMessage();
    }

    private String getHintMessage() {
        String message = "";
        if (ballCount > 0) {
            message += (ballCount + "볼 ");
        }
        if (strikeCount > 0) {
            message += (strikeCount + "스트라이크");
        }
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        }
        return message;
    }

    private void checkBaseballRule(List<Integer> ComputerNumbers, List<Integer> playerNumbers, int index) {
        int number = ComputerNumbers.get(index);
        if (playerNumbers.contains(number)) {
            checkStrikeCount(playerNumbers, index, number);
            checkBallCount(playerNumbers, index, number);
        }
    }

    private void checkBallCount(List<Integer> playerNumbers, int index, int number) {
        if (playerNumbers.indexOf(number) != index) {
            ballCount++;
        }
    }

    private void checkStrikeCount(List<Integer> playerNumbers, int index, int number) {
        if (playerNumbers.indexOf(number) == index) {
            strikeCount++;
        }
    }
}
