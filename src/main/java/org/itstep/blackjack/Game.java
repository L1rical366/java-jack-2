package org.itstep.blackjack;

public class Game {
    private final Player player;
    private final Player dealer;
    private final Deck deck;
    private int bet;
    public static final int TWENTY_ONE = 21;
    public static final int THRESHOLD = 15;



    public Game(Player player, Player dealer, Deck deck, int value) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
    }

    public void hit() {
        Card card = deck.getOne();
        player.takeCard(card);
        if (player.getPoints() > TWENTY_ONE) {
            dealer.getCards().get(0).setHide(false);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public Player getDealer() {
        return dealer;
    }

    public void stand() {
        dealer.getCards().get(0).setHide(false);
        while (dealer.getPoints() < THRESHOLD) {
            Card card = deck.getOne();
            dealer.takeCard(card);
        }
    }

    public void setBet(int amount) throws NoMoneyException { //ставка
        if (amount > bet) {
            throw new NoMoneyException("Не достаточно средств для ставки!");
        }
        bet -= amount;
    }

    public void play() {
        deck.shuffle();
        player.clear();
        dealer.clear();
        Card firstCard = deck.getOne();
        player.takeCard(firstCard);

        Card second = deck.getOne();
        player.takeCard(second);
        Card hiddenCard = deck.getOne();

        hiddenCard.setHide(true);
        dealer.takeCard(hiddenCard);

        Card lastCard = deck.getOne();
        dealer.takeCard(lastCard);

    }
}