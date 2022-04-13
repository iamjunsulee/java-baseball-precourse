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
        if (gameResult.isBall()) {
            message += (gameResult.getBallCount() + "볼 ");
        }
        if (gameResult.isStrike()) {
            message += (gameResult.getStrikeCount() + "스트라이크");
        }
        if (gameResult.isNothing()) {
            return "낫싱";
        }
        return message;
    }
}
