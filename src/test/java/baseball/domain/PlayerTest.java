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
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("3자리수를 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "223", "343"})
    @DisplayName("init player duplicate number test")
    void init_player_duplicate_number_test(String numbers) {
        assertThatThrownBy(() -> {
            Player player = new Player();
            player.setNumbers(numbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("중복되는 입력값이 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"kkk", "1kk", "11k"})
    @DisplayName("init player number format test")
    void init_player_number_format_test(String numbers) {
        assertThatThrownBy(() -> {
            Player player = new Player();
            player.setNumbers(numbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("숫자만 입력가능합니다.");
    }
}
