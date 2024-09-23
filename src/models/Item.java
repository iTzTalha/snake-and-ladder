package models;

public class Item extends BaseModel {
    protected final int start;
    protected final int end;

    public Item(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
