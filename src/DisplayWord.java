import java.util.ArrayList;

public class DisplayWord {
    private final String word;

    public DisplayWord(String word) {
        this.word = word;
    }

    public String displayDashedWord(ArrayList<String> letterGuesses) {
//        System.out.println("This is the word from DisplayWord: " + this.word); - delete
        // check out string builder to make strings from many smaller strings or appending new characters to an existing string. mutates the string. as opposed to the characters I would use for authentication tings.
        StringBuilder dashedWord = new StringBuilder();

//        wrapper for chars - do I need to validate if everything coming in is a letter? isLetter - I'm only accepting letter guesses
        for (char letter : this.word.toCharArray()) {
            String letterStr = Character.toString(letter).toLowerCase();

            if (letterGuesses.contains(letterStr)) {
// need to also append a space to display
                dashedWord.append(letter).append(' ');
            } else if (Character.isLetter(letter)) {
                dashedWord.append("_").append(' ');
            }
        }

        return dashedWord.toString().trim();
    }
}
