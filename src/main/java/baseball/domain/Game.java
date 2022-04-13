package baseball.domain;

import baseball.ui.Message;
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
        System.out.println("Computer : " + numbers);
    }

    public void playBall() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumbers = Console.readLine();
        this.player = new Player();
        this.player.setNumbers(inputNumbers);
    }

    public void playOn() {
        BaseballReferee baseballReferee = new BaseballReferee(this.numbers, this.player.getNumbers());
        GameResult gameResult = baseballReferee.judge();
        Message message = new Message(gameResult);
        message.printHintMessage();
        if (gameResult.isStrikeOut()) {
            this.gameStatus = 2;
        }
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
}
