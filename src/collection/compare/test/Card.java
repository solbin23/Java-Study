package collection.compare.test;

public class Card implements Comparable<Card>{

    private final int rank; //카드의 숫자
    private final Suit suit; //카드의 마크

    public Card(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card o) {
        //숫자를 먼저 비교하고, 숫자가 같으면 마크를 비교
        if(this.rank != o.rank) {
           return Integer.compare(this.rank, o.rank);
        } else {
            return this.suit.compareTo(o.suit);
        }

    }

    @Override
    public String toString() {
        return rank +
                "(" + suit.getIcon() + ")";
    }
}
