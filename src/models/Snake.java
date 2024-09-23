package models;

import java.util.Objects;

public class Snake extends Item {
    public Snake(int start, int end) {
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
        Snake other = (Snake) obj;
        return Objects.equals(start, other.start) && Objects.equals(end, other.end);
    }

    @Override
    public String toString() {
        return "Snake{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
