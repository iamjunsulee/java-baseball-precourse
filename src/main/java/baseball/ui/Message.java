package baseball.ui;

public class Message {
    private final GameResult gameResult;

    public Message(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public void printHintMessage() {
        System.out.println(getHintMessage());
    }

    private String getHintMessage() {
        String message = "";
        message = getBallMessage(message);
        message = getStrikeMessage(message);
        if (gameResult.isNothing()) {
            return "낫싱";
        }
        return message;
    }

    private String getBallMessage(String message) {
        if (gameResult.isBall()) {
            message += (gameResult.getBallCount() + "볼 ");
        }
        return message;
    }

    private String getStrikeMessage(String message) {
        if (gameResult.isStrike()) {
            message += (gameResult.getStrikeCount() + "스트라이크");
        }
        return message;
    }

    public static void printStartMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
