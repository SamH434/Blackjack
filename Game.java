import java.util.Scanner;

class Game {
    private Person player;
    private Deck deck;
    private int bet;

    public Game(Person player, Deck deck, int bet) {
        this.player = player;
        this.deck = deck;
        this.bet = bet;
    }

    public void play() {
        System.out.println("Starting a new game...");

        // Deal initial cards
        Card playerCard1 = deck.drawCard();
        Card dealerCard1 = deck.drawCard();
        Card playerCard2 = deck.drawCard();
        Card dealerCard2 = deck.drawCard();

        // Display initial cards
        System.out.println("Your cards: " + playerCard1 + ", " + playerCard2);
        System.out.println("Dealer's upcard: " + dealerCard1);

        // Player's turn
        int playerSum = playerCard1.getValue() + playerCard2.getValue();
        playerSum = playerTurn(playerSum);

        // Dealer's turn
        int dealerSum = dealerCard1.getValue() + dealerCard2.getValue();
        dealerSum = dealerTurn(dealerSum);

        // Determine winner
        determineWinner(playerSum, dealerSum);
    }

    private int playerTurn(int playerSum) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Your current sum: " + playerSum);
            System.out.println("Do you want to hit (h) or stand (s)?");
            String choice = scanner.nextLine().toLowerCase();

            if ("h".equals(choice)) {
                Card card = deck.drawCard();
                System.out.println("You drew: " + card);
                playerSum += card.getValue();

                if (playerSum > 21) {
                    System.out.println("Bust! Your sum is over 21.");
                    return 0; // Player busts
                }
            } else if ("s".equals(choice)) {
                System.out.println("You chose to stand.");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 'h' or 's'.");
            }
        }
        return playerSum;
    } 

    private int dealerTurn(int dealerSum) {
        System.out.println("Dealer's turn...");

        while (dealerSum < 17) {
            Card card = deck.drawCard();
            System.out.println("Dealer drew: " + card);
            dealerSum += card.getValue();
        }

        System.out.println("Dealer's final sum: " + dealerSum);
        return dealerSum;
    }

    private void determineWinner(int playerSum, int dealerSum) {
        if (playerSum == 0) {
            player.updateMoney(-bet);
            System.out.println("You lose! You busted.");
        } else if (dealerSum > 21 || playerSum > dealerSum) {
            player.updateMoney(bet);
            player.incrementGamesWon();
            System.out.println("You win!");
        } else if (playerSum < dealerSum) {
            player.updateMoney(-bet);
            System.out.println("You lose!");
        } else {
            System.out.println("It's a push (tie).");
        }

        System.out.println("Your current money: $" + player.getMoney());
    }
}
