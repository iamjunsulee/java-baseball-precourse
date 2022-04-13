package baseball.domain;

import java.util.List;

/*
야구 심판 - 스트라이크, 볼을 판정한다.
 */
public class BaseballReferee {
    private final List<Integer> computerNumbers;
    private final List<Integer> playerNumbers;
    private final static int MAX_SIZE = 3;

    public BaseballReferee(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        this.computerNumbers = computerNumbers;
        this.playerNumbers = playerNumbers;
    }

    public GameResult judge() {
        return new GameResult(getStrikeCount(), getBallCount());
    }

    private int getStrikeCount() {
        int strikeCount = 0;
        for (int index = 0; index < MAX_SIZE; index++) {
            strikeCount = addStrikeCount(strikeCount, index);
        }
        return strikeCount;
    }

    private int addStrikeCount(int strikeCount, int index) {
        if (computerNumbers.get(index).equals(playerNumbers.get(index))) {
            strikeCount++;
        }
        return strikeCount;
    }

    private int getBallCount() {
        int ballCount = 0;
        for (int index = 0; index < MAX_SIZE; index++) {
            ballCount = addBallCountIfContains(ballCount, index);
        }
        return ballCount;
    }

    private int addBallCountIfContains(int ballCount, int index) {
        int number = computerNumbers.get(index);
        if (playerNumbers.contains(number)) {
            ballCount = addBallCount(ballCount, index, number);
        }
        return ballCount;
    }

    private int addBallCount(int ballCount, int index, int number) {
        if (playerNumbers.indexOf(number) != index) {
            ballCount++;
        }
        return ballCount;
    }
}
