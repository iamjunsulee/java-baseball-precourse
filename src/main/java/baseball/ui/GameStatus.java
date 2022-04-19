package baseball.ui;

public enum GameStatus {
    GAME_START(1), GAME_END(2);

    private final int value;

    GameStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
