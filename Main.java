import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Your name:");
        String playerName = scanner.nextLine();
        System.out.println("Enter the initial amount of money:");
        int initialMoney = scanner.nextInt();//had to look this one up

        Person player = new Person(playerName, initialMoney);
        Deck deck = new Deck();
        int bet = 10; //default number placeholder

        while (player.getMoney() > 0) {
            System.out.println("Games won: " + player.getGamesWon());
            System.out.println("Current money: $" + player.getMoney());

            System.out.println("Enter your bet:");
            int playerBet = scanner.nextInt();

            //bet is not more than what the player has
            if (playerBet > player.getMoney()) {
                System.out.println("Not enough money. Setting bet to your remaining money: $" + player.getMoney());
                playerBet = player.getMoney();
            }
            //new game start
            Game game = new Game(player, deck, playerBet);
            game.play();

            //ANOTHER ROUND??????
            System.out.println("Do you want to play another round? (yes/no)");
            String playAgain = scanner.next().toLowerCase();
            if (!"yes".equals(playAgain)) {
                break; //out of the loop
            }
        }
        System.out.println("Game over. Thanks for playing!");//byebye
        scanner.close();
    }
}
