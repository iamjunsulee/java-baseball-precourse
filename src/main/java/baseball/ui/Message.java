package baseball.ui;

import baseball.domain.GameResult;

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
        int ballCount = gameResult.getBallCount();
        int strikeCount = gameResult.getStrikeCount();
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
}
