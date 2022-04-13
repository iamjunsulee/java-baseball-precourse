package baseball;

import baseball.domain.Game;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        int isContinue = game.getGameStatus();
        while (isContinue == 1) {
            game.playBall();
            System.out.println(game.getGameResultMessage());
            isContinue = game.end();
            if (game.getGameStatus() == 2 && isContinue == 1) {
                game = new Game();
            }
        }
    }
}
