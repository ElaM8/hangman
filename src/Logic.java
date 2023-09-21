import java.util.ArrayList;

public class Logic {
    private String word;
    private String wordGuess;

    protected String lastLetterGuess;

    boolean lastGuessFound;

    int guessesRemaining = 6;

    protected ArrayList<String> letterGuesses = new ArrayList<>();

    boolean playerWin = false;

    public Logic(String word) {
        this.word = word;
    }

    public void setWordGuess(String wordGuess) {
        this.wordGuess = wordGuess;
    }

    public String getWordGuess() {
//        System.out.println("current counter from getWordGuess " + guessesRemaining);
        return this.wordGuess;
    }

    public void addLetterGuess(String letterGuess) {
        if (word.contains(lastLetterGuess)) {
            lastGuessFound = true;
        } else {
            lastGuessFound = false;
        }
        if (letterGuesses.contains(letterGuess) && guessesRemaining > 0) {
            guessesRemaining--;
            System.out.println("You already guessed the letter " + letterGuess);
        }
            else if (letterGuesses.contains(letterGuess) && guessesRemaining == 1) {
                guessesRemaining--;
            System.out.println("You've already guessed " + letterGuess + ". Get ready to meet your maker. RIP");
            // quit programme or try again
        } else {
            letterGuesses.add(letterGuess);
        }
    }

    public ArrayList<String> getLetterGuesses() {
        return letterGuesses;
    }

    public boolean allLettersGuessed() {
        for (char letter : this.word.toCharArray()) {
            String letterStr = Character.toString(letter).toLowerCase();
            if (Character.isLetter(letter) && !letterGuesses.contains(letterStr)) {
                return false;
            }
        }
        // if all letters are in lettersGuessed:
        return true;
    }

    public boolean checkWin() {
        if (this.wordGuess != null && (this.wordGuess.equals(this.word)) || this.wordGuess == null && allLettersGuessed()) {
            playerWin = true;
            return true;
        } else {
            return false;
        }
    }
}