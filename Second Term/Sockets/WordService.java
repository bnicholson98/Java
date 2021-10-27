import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stores a collection of {@link String}s and provides options
 * to manipulate and query this collection, returning plain-English
 * responses.
 */
class WordService {

    private final List<String> words = new ArrayList<>();

    /**
     * Inserts the given word into the list of words held by
     * this service if and only if the word has not already been inserted.
     * Return "already existing word" if the word was previously inserted,
     * and therefore not inserted in this invocation, or "new word" if the
     * word was not previously inserted, and therefore inserted in this
     * invocation.
     *
     * @param word the word to insert
     * @return "new word" if the word was inserted, "already existing word" otherwise
     */
    String insert(String word) {
        if (words.contains(word)) {
            return "already existing word";
        }

        words.add(word);
        return "new word";
    }

    /**
     * Determines whether or not the given word is present in the list
     * of words held by this service.
     *
     * @param word the word to check
     * @return "word present" if the word is held by this service; "word absent" otherwise
     */
    String query(String word) {
        if (words.contains(word)) {
            return "word present";
        } else {
            return "word absent";
        }
    }

    /**
     * @return the words held by this service separated by commas.
     */
    String allWords() {
        return words.stream().collect(Collectors.joining(", "));
    }

}
