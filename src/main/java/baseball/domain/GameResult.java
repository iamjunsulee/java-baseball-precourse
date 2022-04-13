package baseball.domain;

/*
경기 결과
 */
public class GameResult {
    private final int strikeCount;
    private final int ballCount;

    public GameResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isStrikeOut() {
        return strikeCount == 3;
    }

    public boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }

    public boolean isStrike() {
        return strikeCount > 0;
    }

    public boolean isBall() {
        return ballCount > 0;
    }
}
