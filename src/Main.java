import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(WordUtilities.selectWord()); // move this to later once game logic is more structured

        PlayerInteractions interactions = new PlayerInteractions();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome Traveller. What name shall I give the executioner?");

        while (true) {
            interactions.setName(scanner.nextLine());
            if (interactions.getName() != null && !interactions.getName().trim().isEmpty()) {
                break;
            } else {
                System.out.println("Please try again to enter your name. The executioner likes to know her customers.");
            }
        }

        interactions.printGreeting(); //Thanks, Dani. Ready or not...Here comes your word...
        // provide word display

        boolean quitProgramme = false;
        boolean wordNotSolved = true;

        while (!quitProgramme) {
            // Play game....
            System.out.println("DISPLAY WORD");
// if word not solved, then ask which command

            // print available commands, and get a choice ie 0: guess the word 1: guess a letter in the woprd
            interactions.printCommands();
            int integerFromUser = Integer.parseInt(scanner.nextLine());

            // validate command choice
            if (integerFromUser < 0 || integerFromUser > interactions.userGuessOptions.length) {
                System.out.println("Please choose an option by entering 0 - " + (interactions.userGuessOptions.length - 1));
                integerFromUser = Integer.parseInt(scanner.nextLine());
                System.out.println(integerFromUser);
                // do I need this? This is the assignment if ...?? What??
            }

            // provide next user input, dependent on command choice
            switch (integerFromUser) {
                case 0:
                    System.out.println("What is the word? Please type your guess here:");
//                    setGuess in game logic. Game logic should decide if isPlayerWin
                    while (true) {
//                        gameLogic.setGuess(scanner.nextLine()); // make a gameLogic class
//                        if (getGuess != null && ! isEmpty()) {
                        if (true) {
                            System.out.println("CASE 0");
                            break;
                        } else {
                            System.out.println("Please try again to type your guess of the word.");
                        }
                    }
                    break;
                case 1:
                    // guess the char
                    break;
                default:
                    // rage quit set to quit is true
            }


            char userInput = scanner.nextLine().toLowerCase().charAt(0);
            if (userInput == 'y') {
                System.out.println("Quitting...");
                quitProgramme = true;
            } else {
                // Play again
            }

        }
    }
}
