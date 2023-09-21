import java.util.Scanner;

public class HangmanGame {
    private String word;
    private final String name;

    private PlayerInteractions interactions;
    private Logic logic;
    private DisplayWord currentWord;
    private boolean quitProgramme;

    public HangmanGame() {
        this.word = WordUtilities.selectWord();
        this.interactions = new PlayerInteractions();
        this.name = interactions.getName();
        this.logic = new Logic(word);
        this.currentWord = new DisplayWord(word);
        this.quitProgramme = false;
    }

    public void startGame(String name) {
        Scanner scanner = new Scanner(System.in);

        interactions.setName(name);

        while (!quitProgramme) {
            currentWord.displayDashedWord(logic.getLetterGuesses());

            interactions.printCommands();

            int integerFromUser;
            while (true) {
                String userInput = scanner.nextLine();
                try {
                    integerFromUser = Integer.parseInt(userInput);

                    if (integerFromUser < 0 || integerFromUser >= interactions.userGuessOptions.length) {
                        interactions.optionValidationMessage();
                        continue;
                    }

                    break;
                } catch (NumberFormatException e) {
                    interactions.optionValidationMessage();
                }
            }

            switch (integerFromUser) {
                case 0:
                    interactions.askForWordGuess();
                    logic.setWordGuess(scanner.nextLine());
                    while (!logic.playerWin) {
                        logic.getWordGuess();
                        logic.checkWin();
                        if (logic.playerWin) {
                            interactions.winMessage();
                            resetGame();
                            break;
                        } else if (!logic.playerWin && logic.guessesRemaining == 0) {
                            interactions.loseMessage();
                            resetGame();
                            break;
                        } else {
                            interactions.incorrectGuessGuessesRemaining(logic.guessesRemaining);
                            logic.guessesRemaining--;
                            break;
                        }
                    }
                    break;
                case 1:
                    String letterGuess = "";
                    while (!logic.playerWin) {
                        interactions.askForLetterGuess();
                        letterGuess = scanner.nextLine().toLowerCase();

                        if (letterGuess.length() != 1 || !Character.isLetter(letterGuess.charAt(0))) {
                            interactions.letterValidationMessage();
                        } else {
                            break;
                        }
                    }
                    logic.lastLetterGuess = letterGuess;
                    logic.addLetterGuess(letterGuess);

                    if (logic.lastGuessFound) {
                        currentWord.displayDashedWord(logic.getLetterGuesses()); //dashed word
                        interactions.displayUniqueLetterGuesses(logic.getLetterGuesses()); // letter guesses
                        if (!logic.letterGuesses.contains(letterGuess)) {
                            interactions.correctLetterGuess();
                        }
                        if (logic.checkWin()) {
                            interactions.winMessage();
                            resetGame();
                        } else {
                            interactions.incorrectGuessGuessesRemaining(logic.guessesRemaining);
                        }

                    } else if (!logic.lastGuessFound && logic.guessesRemaining > 0) {
                        logic.guessesRemaining--;
                        interactions.incorrectGuessGuessesRemaining(logic.guessesRemaining);
                        interactions.displayUniqueLetterGuesses((logic.getLetterGuesses()));
                        currentWord.displayDashedWord(logic.getLetterGuesses());
                    } else {
                        interactions.loseMessage();
                        resetGame();
                        break;
                    }
//                    }
                    break;
                case 2:
                    while (!quitProgramme) {
                        System.out.println("Are you sure you want to quit? (yes/no)");
                        char userInput = scanner.nextLine().toLowerCase().charAt(0);
                        if (userInput == 'y') {
                            System.out.println("Quitting...");
                            quitProgramme = true;
                        } else if (userInput == 'n') {
                            interactions.printCommands();
                            break;
                        } else {
                            System.out.println("That's an invalid input. Please enter 'yes' or 'no'.");
                        }
                    }
                    break;
                default:
            }
        }
    }

    public void resetGame() {
        System.out.println("Game resetting...");
        this.logic = new Logic(this.word);
        this.currentWord = new DisplayWord(this.word);
        this.quitProgramme = false;
    }
}