package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();
    private final int height;

    public Ladder(final int width, final String height) {
        LadderValidator.checkNumeric(height);
        LadderValidator.checkLadderHeightLadder(height);

        this.height = Integer.parseInt(height);

        makeLadder(width, this.height);
    }

    private void makeLadder(int width, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(LineGenerator.makeLine(width));
        }
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return height == ladder.height &&
                Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines, height);
    }

    // TODO toString 없애기
    /*@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lines.size(); i++) {
            sb.append(lines.get(i));
        }

        return sb.toString();
    }*/
}
