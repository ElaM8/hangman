import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class PlayerInteractions {
    public PlayerInteractions(String name) {
        this.name = name;
    }

    public PlayerInteractions() {
    }
    Scanner myObj = new Scanner(System.in);
    private Scanner scanner;

    String[] userGuessOptions = new String[]{
            "Guess the word and escape the hangman",
            "Guess a character in the word",
            "Rage quit"
    };
    // this doesnt need to be an array list. Its fixed.
    private String name;
    private String[] commands;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printWelcome() {
        System.out.println("Welcome Traveller. What name shall I give the executioner?");
    }

    public void nameNotEntered() {
        System.out.println("Please try again to enter your name. The executioner likes to know her customers.");
    }

    public void printGreeting() {
        System.out.println("Thanks, " + getName() + ". Ready or not...Here comes your word...");
    }

    public void printCommands() {
//
        // Get this to output: // print options and index ie 0: guess the word 1: guess a letter in the woprd
            System.out.println("What would you like to do next? Please enter a number from the following:");
            for (int i = 0; i < userGuessOptions.length; ++i) {
                System.out.println(i + " : " + userGuessOptions[i]);
            }
        }

    public void optionValidationMessage() {
        System.out.println("Please choose a valid option by entering a number between 0 - " + (userGuessOptions.length - 1));
    }

    public void letterValidationMessage() {
        System.out.println("Please only type a single letter.");
    }

    public void askForWordGuess() {
        System.out.println("What is the word? Please type your guess here:");
    }

    public void askForLetterGuess() {
        System.out.println("What is your letter guess? Please type a single character here:");
    }

    public void correctLetterGuess() {
        System.out.println("Well done " + getName() + "! You guessed a correct letter.");
    }

    public void winMessage() {
        System.out.println("Congrats " + getName() + "! You win, and live to see another day! Or put your neck in the line again with another round of hangman!");
    }

    public void loseMessage() {
        System.out.println("That was wrong, and you have no guesses remaining. Get ready to meet your maker. RIP");
    }

    public void incorrectGuessGuessesRemaining(int guessesRemaining) {
        System.out.println("Keep trying! You have this many guesses remaining: " + guessesRemaining);
    }

        public void displayUniqueLetterGuesses(ArrayList<String> letterGuesses) {
        //interface: ability to remove duplicates
            HashSet<String> uniqueGuessesSet = new HashSet<>(letterGuesses);
            ArrayList<String> uniqueGuessesList = new ArrayList<>(uniqueGuessesSet);
            System.out.println("So far you have guessed the following letters: " + uniqueGuessesList);
        }
    }