package org.itstep.blackjack;

public class Card {
    private final Rank rank;
    private final Suite suite;
    private boolean  hide;

    public Card(Rank rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;
    }

    public Rank getRank() {
        return rank;
    }

    public Suite getSuite() {
        return suite;
    }

    public boolean isHide() { return hide;}

    public boolean setHide(boolean hide)
    {
        return hide;
    }

    public int getValue() {
        return rank.getValue();
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suite=" + suite +
                '}';
    }
}
