package pl.pawel.linkshell.model.enums.card;

/**
 * Created by pawellinkshell on 10.02.2018.
 */
public enum Rank {
    TWO(2),
    TREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(11);

    private int power;

    Rank(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
