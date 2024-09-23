package models;

import java.util.Random;

public class Dice extends BaseModel {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 6;

    private final Random random = new Random();

    public int role() {
        return random.nextInt(MIN_VALUE, MAX_VALUE + 1);
    }
}