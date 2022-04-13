package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.ui.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    @DisplayName("game start test")
    void game_start_test() {
        Game baseball = new Game();
        assertThat(baseball.getNumbers().size()).isEqualTo(3);
        assertThat(baseball.getGameStatus()).isEqualTo(GameStatus.GAME_START);
    }
}
