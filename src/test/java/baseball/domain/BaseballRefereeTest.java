package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.ui.GameResult;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballRefereeTest {
    private List<Integer> computerNumbers;

    @BeforeEach
    void setUp() {
        computerNumbers = new ArrayList<>();
        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);
    }

    @Test
    @DisplayName("3 strike test")
    void three_strike_out_test() {
        List<Integer> playerNumbers = new ArrayList<>();
        playerNumbers.add(1);
        playerNumbers.add(2);
        playerNumbers.add(3);

        BaseballReferee baseballReferee = new BaseballReferee(computerNumbers, playerNumbers);
        GameResult result = baseballReferee.judge();

        assertThat(result.getStrikeCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("1 strike 1 ball test")
    void one_strike_one_ball_test() {
        List<Integer> playerNumbers = new ArrayList<>();
        playerNumbers.add(1);
        playerNumbers.add(3);
        playerNumbers.add(5);

        BaseballReferee baseballReferee = new BaseballReferee(computerNumbers, playerNumbers);
        GameResult result = baseballReferee.judge();

        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("1 strike 2 ball test")
    void one_strike_two_ball_test() {
        List<Integer> playerNumbers = new ArrayList<>();
        playerNumbers.add(1);
        playerNumbers.add(3);
        playerNumbers.add(2);

        BaseballReferee baseballReferee = new BaseballReferee(computerNumbers, playerNumbers);
        GameResult result = baseballReferee.judge();

        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("3 ball test")
    void three_ball_test() {
        List<Integer> playerNumbers = new ArrayList<>();
        playerNumbers.add(3);
        playerNumbers.add(1);
        playerNumbers.add(2);

        BaseballReferee baseballReferee = new BaseballReferee(computerNumbers, playerNumbers);
        GameResult result = baseballReferee.judge();

        assertThat(result.getBallCount()).isEqualTo(3);
    }
}