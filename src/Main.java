import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String word = WordUtilities.selectWord();

        PlayerInteractions interactions = new PlayerInteractions();
        Scanner scanner = new Scanner(System.in);
        DisplayWord currentWord = new DisplayWord(word);
        Logic logic = new Logic(word);

        boolean quitProgramme = false;

        interactions.printWelcome();

        // TODO: Separate out validation into a utility class
        // TODO: Separate out player interactions

        while (true) {
            interactions.setName(scanner.nextLine());
            if (interactions.getName() != null && !interactions.getName().trim().isEmpty()) {
                break;
            } else {
                System.out.println("Please try again to enter your name. The executioner likes to know her customers.");
            }
        }

        interactions.printGreeting(); //Thanks, Dani. Ready or not...Here comes your word...

//        currentWord.displayDashedWord(logic.getLetterGuesses()); - delete
        System.out.println(currentWord.displayDashedWord(logic.getLetterGuesses()));

        while (!quitProgramme) {

            // print available commands, and get a choice ie 0: guess the word 1: guess a letter in the woprd
            interactions.printCommands();
            // if word not solved, then ask which command again


            int integerFromUser = Integer.parseInt(scanner.nextLine());

            // validate command choice
            if (integerFromUser < 0 || integerFromUser > interactions.userGuessOptions.length) {
                System.out.println("Please choose an option by entering 0 - " + (interactions.userGuessOptions.length - 1));
                integerFromUser = Integer.parseInt(scanner.nextLine());
                System.out.println(integerFromUser); // ??
            }

            switch (integerFromUser) {
                case 0:
                    System.out.println("What is the word? Please type your guess here:");
//                    setGuess in game logic. Game logic should decide if isPlayerWin
                    //logic.setWordGuess(stringInput)
//                        gameLogic.setGuess(scanner.nextLine()); // make a gameLogic class
//                        if (getGuess != null && ! isEmpty()) {
                    while (!logic.playerWin) {
                        logic.setWordGuess(scanner.nextLine());
                        logic.getWordGuess();
                        logic.checkWin();
                        if (logic.playerWin) {
                            System.out.println("Congrats " + interactions.getName() + "! You win and escape the hangman!");
                            quitProgramme = true;
                            break;  /// this breaks the loop if the player wins
                        } else {
                            System.out.println("Sorry that's not correct!");
                            //if guesses remaining go back to line 33 interactions.printCommands();
                        }
                    }

                    break; // this is part of the switch
                case 1:
                    String letterGuess = "";
                    while (!logic.playerWin) {
                        System.out.println("What is your letter guess? Please type a single character here:");
                        letterGuess = scanner.nextLine().toLowerCase();

                        // Validate the letter guess
                        if (letterGuess.length() != 1 || !Character.isLetter(letterGuess.charAt(0))) {
                            System.out.println("Please only type a single letter.");
                            continue;
                        } else {
                            System.out.println("here");
                            break;
                        }
                    }
                        logic.lastLetterGuess = letterGuess;
                        logic.addLetterGuess(letterGuess);
                        logic.getLetterGuesses();
//                        logic.checkLetters();

                        if (logic.lastGuessFound) {
                            System.out.println("Well done " + interactions.getName() + "! You guessed a correct letter.");
                            System.out.println(currentWord.displayDashedWord(logic.getLetterGuesses())); //out: string with dashes
//                            System.out.println(logic.checkWin());
                            if(logic.checkWin()) {
                                System.out.println("You winnnnn, and live to see another day. Or put your neck in the line again with another round of hangman!");
                                quitProgramme = true;
                            } else {
                                System.out.println("Keep trying");
                            }

                            // *** Go back to the start of the while loop at line 33 while (!quitProgramme)

                        } else if (!logic.lastGuessFound && logic.hasGuessesRemaining) {
                            System.out.println("That was wrong, but you can guess another letter or word.");
                            System.out.println(currentWord.displayDashedWord(logic.getLetterGuesses())); //out: string with dashes
                            // *** Go back to the start of the while loop at line 33 while (!quitProgramme)
                        } else {
                            System.out.println("That was wrong, and you have no guesses remaining. Get ready to meet your maker. RIP");
                            quitProgramme = true;
                            break; // this is the switch case break
                        }
//                    }
                    break; // this is the switch case break
                case 2:
                    boolean shouldQuit = false;
                    while (!shouldQuit) {
                        System.out.println("Are you sure you want to quit? (yes/no)");
                        char userInput = scanner.nextLine().toLowerCase().charAt(0);
                        if (userInput == 'y') {
                            System.out.println("Quitting...");
                            shouldQuit = true; // Set the flag to true to exit the loop and quit
                        } else if (userInput == 'n') {
                            interactions.printCommands(); // Print commands again
                            break; // Break the loop and go back to the main loop
                        } else {
                            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                        }
                    }
                    break; // this is part of the switch
                default:
            }
        }
    }
}
