import java.util.ArrayList;
import java.util.Random;

public class WordUtilities {

    static Random random = new Random();
    private static final ArrayList<String> words = new ArrayList<>();

    // Static variables live on the class
    // is static and runs when the class is loaded
    // The object doesn't have to be instantiated to access static variables
    // This achieves encapsulation. The only way we can get a word is by accessing selectWord. Which is a good thing as we dont want any cheating!!
    // Initialization block
    // this needs to be static because we need to remember what words have been given and which are removed from the list of available words

    static {
        words.add("accoutrement");
        words.add("bedraggled");
        words.add("conscience");
        words.add("delirium");
        words.add("equilibrium");
        words.add("epicentre");
        words.add("fulcrum");
        words.add("flabbergasted");
        words.add("fictioneering");
        words.add("glitch");
        words.add("garrulous");
        words.add("gregarious");
        words.add("gesticulate");
        words.add("hierarchical");
        words.add("nomenclature");
        words.add("triumvariate");
        words.add("ovum");
    }

    public static String selectWord() {
        if (words.isEmpty()) {
            return "No more random words available. Even fictioneering has been played. Get a new list of words.";
        } else {
            int randomNumber = random.nextInt(words.size());
            String randomWord = words.get(randomNumber);
            words.remove(randomNumber);
            return randomWord;
        }
    }
}