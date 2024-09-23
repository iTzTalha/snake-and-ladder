package services;

import models.Dice;

public class DiceService {
    private final int diceCount;
    private final Dice dice;

    public DiceService(int diceCount) {
        this.diceCount = diceCount;
        this.dice = new Dice();
    }

    public int role() {
        int ans = 0;
        for(int i = 0; i < diceCount; i++) {
            ans += dice.role();
        }
        return ans;
    }
}
