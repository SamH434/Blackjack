class Card {
    private String suit;
    private String name;
    private int value;
    public Card(String suit, String name, int value) {
        this.suit = suit;
        this.name = name;
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public String toString() {
        return name + suit.charAt(0);
    }
    //TODO:check if the parameters match up what we have in the other class
}
