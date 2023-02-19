package domain;

import java.util.List;

public class Line {

    private static final int MIN_HEIGHT = 0;

    private final List<Bridge> bridges;

    public Line(List<Bridge> bridges) {
        validateHeightOf(bridges);
        this.bridges = List.copyOf(bridges);
    }

    private void validateHeightOf(final List<Bridge> bridges) {
        if (bridges.size() <= MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 양수만 가능합니다");
        }
    }

    public List<Bridge> getBridges() {
        return bridges;
    }
}
