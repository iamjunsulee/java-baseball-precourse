package baseball;

import baseball.domain.Game;
import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("컴퓨터 숫자 : " + game.getNumbers());
        int toBeContinue = game.getGameStatus();
        while (toBeContinue == 1) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumbers = Console.readLine();
            Player player = new Player();   //선수입장
            player.setNumbers(inputNumbers);
            game.getHintMessage(player);  //힌트 출력

            if (game.getGameStatus() == 2) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                toBeContinue = Integer.parseInt(Console.readLine());

                if (toBeContinue == 1) {
                    game = new Game();
                    System.out.println("컴퓨터 숫자 : " + game.getNumbers());
                }
            }
        }
    }
}
