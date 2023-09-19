import javax.sql.rowset.serial.SerialArray;
import java.util.ArrayList;

public class Logic {
    private String word;
    private String wordGuess;

    protected String lastLetterGuess;

    boolean lastGuessFound;

    boolean hasGuessesRemaining = true;

    private static ArrayList<String> letterGuesses = new ArrayList<>();

    boolean playerWin = false;

    // constructor
    public Logic (String word)
    {
        this.word = word;
    }
    // might be worth an array of guesses for later development. Letters will be an array from get go

    // letters should be an array list so I can get length et c,



// this constructor also needs the actual word as it will decide the win


    //instance vairables are guesses of the whole word and guesses of the letter

    public void setWordGuess(String wordGuess) {
        this.wordGuess = wordGuess;
    }

    public String getWordGuess() {
        return this.wordGuess;
    }

    public void addLetterGuess(String letterGuess) {
        lastGuessFound = word.contains(lastLetterGuess);
        letterGuesses.add(letterGuess);
//        System.out.println("You have guessed these letters so far: " + letterGuesses);
    }

    public ArrayList<String> getLetterGuesses() {
        return letterGuesses;
    }

    public boolean allLettersGuessed() {
        for (char letter : this.word.toCharArray()) {
            String letterStr = Character.toString(letter).toLowerCase();
//            System.out.println("all letters guessed says letter " + letter + " & letter string: " +letterStr ); - delete
            // If the character is a letter and it hasn't been guessed, return false
            if (Character.isLetter(letter) && !letterGuesses.contains(letterStr)) {
                return false;
            }
        }
        // if all letters are in lettersGuessed:
        return true;
    }

    public boolean checkWin() {
//        System.out.println("checking for Win " + this.wordGuess + " " + this.word);
        if(this.wordGuess != null && (this.wordGuess.equals(this.word)) || this.wordGuess == null && allLettersGuessed()) {
            playerWin = true;
            return true;
        } else {
            return false;
        }
    }

//    public void checkLetters() {
//        System.out.println("checking for letters " + letterGuesses + " " + this.word);
//
//    } - delete

    public void setLetterGuesses(String letter) {
        this.letterGuesses.add(letter);
    }

    public void listGuesses() {
        for (String string : letterGuesses) {
            System.out.println("Addesd to the list of guesses: " + string);
        }
    }
}
    // use an override to print letters vs word guesses?


//        The player is prompted to enter a letter as a guess. The program needs to capture their guess.
//        If the letter is in the word the program should recognize this.
//        If the letter is not in the word the player loses a life.
//        The program should store the guesses.