import java.util.ArrayList;

public class DisplayWord {
    private final String word;

    public DisplayWord(String word) {
        this.word = word;
    }

    public void displayDashedWord(ArrayList<String> letterGuesses) {

        StringBuilder dashedWord = new StringBuilder();

        for (char letter : this.word.toCharArray()) {
            String letterStr = Character.toString(letter).toLowerCase();

            if (letterGuesses.contains(letterStr)) {
                dashedWord.append(letter).append(' ');
            } else if (Character.isLetter(letter)) {
                dashedWord.append("_").append(' ');
            }
        }

        System.out.println(dashedWord.toString().trim());
    }
}
