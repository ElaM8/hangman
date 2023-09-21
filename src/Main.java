import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        PlayerInteractions interactions = new PlayerInteractions();
        Scanner scanner = new Scanner(System.in);
        HangmanGame game = new HangmanGame();

        interactions.printWelcome();

        while (true) {
            interactions.setName(scanner.nextLine());
            if (interactions.getName() != null && !interactions.getName().trim().isEmpty()) {
                break;
            } else {
                interactions.nameNotEntered();
            }
        }

        interactions.printGreeting();

        game.startGame(interactions.getName());
    }
}
