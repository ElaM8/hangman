import java.util.Arrays;
import java.util.Scanner;

public class PlayerInteractions {
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
    }