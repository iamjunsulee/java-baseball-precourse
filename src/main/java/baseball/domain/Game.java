package baseball.domain;

import baseball.ui.GameResult;
import baseball.ui.GameStatus;
import baseball.ui.Message;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;
    private static final int MAX_SIZE = 3;
    private GameStatus gameStatus;
    private Player player;
    private final List<Integer> numbers;

    public Game() {
        numbers = new ArrayList<>();
        generateRandomNumbers();
        setGameStatus(GameStatus.GAME_START);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    private void generateRandomNumbers() {
        while (this.numbers.size() < MAX_SIZE) {
            addNumbers();
        }
    }

    private void addNumbers() {
        int randomNumber = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
        if (!this.numbers.contains(randomNumber)) {
            this.numbers.add(randomNumber);
        }
    }

    public void playBall() {
        while (getGameStatus() == GameStatus.GAME_START) {
            Message.printStartMessage();
            String inputNumbers = Console.readLine();
            this.player = new Player();
            this.player.setNumbers(inputNumbers);

            playOn();
        }
    }

    public void playOn() {
        BaseballReferee baseballReferee = new BaseballReferee(this.numbers, this.player.getNumbers());
        GameResult gameResult = baseballReferee.judge();
        Message message = new Message(gameResult);
        message.printHintMessage();
        if (gameResult.isStrikeOut()) {
            setGameStatus(GameStatus.GAME_END);
        }
    }

    public boolean endGame() {
        Message.printEndMessage();
        return Integer.parseInt(Console.readLine()) == GameStatus.GAME_START.getValue();
    }
}
