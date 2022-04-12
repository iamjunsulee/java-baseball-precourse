package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;
    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항 1. size() 메소드를 활용해 Set 의 크기를 확인한다.")
    void set_size_test() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("요구사항 2-1. contains() 메소드를 활용해 1,2,3의 값이 존재하는지 확인한다.")
    void set_contains_test() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항 2-2. contains() 메소드를 활용해 1,2,3의 값이 존재하는지 확인한다.[중복제거]")
    void set_contains_test(Integer number) {
        assertThat(numbers.contains(number)).isTrue();
    }
}
