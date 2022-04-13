package baseball.domain;

import baseball.ui.GameResult;
import baseball.ui.GameStatus;
import baseball.ui.Message;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Integer> numbers;
    private final static int MAX_SIZE = 3;
    private GameStatus gameStatus;
    private Player player;

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
        int randomNumber = Randoms.pickNumberInRange(1, 9);
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
        return Integer.parseInt(Console.readLine()) == 1;
    }
}
