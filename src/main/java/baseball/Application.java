package baseball;

import baseball.domain.Game;

public class Application {
    public static void main(String[] args) {
        boolean isContinue = true;
        while (isContinue) {
            Game game = new Game();
            game.playBall();
            isContinue = game.endGame();
        }
    }
}
