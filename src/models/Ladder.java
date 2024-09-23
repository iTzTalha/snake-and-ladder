package models;

import java.util.Objects;

public class Ladder extends Item {
    public Ladder(int start, int end) {
        super(start, end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ladder other = (Ladder) obj;
        return Objects.equals(start, other.start) && Objects.equals(end, other.end);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
