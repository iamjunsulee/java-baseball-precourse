package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    @DisplayName("init player test")
    void init_player_success_test(String numbers) {
        Player player = new Player();
        player.setNumbers(numbers);

        assertThat(player.getNumbers().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "4256", "722289"})
    @DisplayName("init player oversize test")
    void init_player_oversize_test(String numbers) {
        assertThatThrownBy(() -> {
            Player player = new Player();
            player.setNumbers(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "223", "343"})
    @DisplayName("init player duplicate number test")
    void init_player_duplicate_number_test(String numbers) {
        assertThatThrownBy(() -> {
            Player player = new Player();
            player.setNumbers(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
