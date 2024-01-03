class Person {
    private String name;
    private int money;
    private int gamesWon;

    public Person(String name, int money) {
        this.name = name;
        this.money = money;
        this.gamesWon = 0;
    }
//TODO:clean up this section for organization
    public String getName() {
        return name;
    }
    public int getMoney() {
        return money;
    }

    public void updateMoney(int amount) {
        money += amount;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void incrementGamesWon() {
        gamesWon++;
    }
}
