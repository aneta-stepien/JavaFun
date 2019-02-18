package vi;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.util.*;

public class TopWords {

    /**
     *  Returns the most frequent words in the given sentence (space separated).
     *  @param numberOfTopFrequencies defines how many top frequencies should be listed (for each top frequency there can be one or more words).
     *  */
    public static Set<String> getMostFrequent(String sentence, int numberOfTopFrequencies) {
        List<String> words = prepareSortedWordList(sentence);
        ListMultimap<Integer, List<String>> topWords = ArrayListMultimap.create();
        State state = new State(numberOfTopFrequencies);

        for (String nextWord : words) {
            if (nextWord.equalsIgnoreCase(state.word)) {
                state.count++;
            } else {
                if (shouldBeToplisted(state, topWords.keySet().size())) {
                    addNewTopWord(state, topWords);
                }
                state.count = 1;
            }
            state.word = nextWord;
        }

        return multiListToSet(topWords);
    }

    private static List<String> prepareSortedWordList(String sentence) {
        List<String> words = new ArrayList<>(Arrays.asList(sentence.split(" ")));
        Collections.sort(words);
        words.add("_");
        return words;
    }

    private static boolean shouldBeToplisted(State state, int topListSize) {
        return state.word != null && (state.word.trim().length() > 0) && (topListSize < state.numberOfTopFrequencies || state.count >= state.minCount);
    }

    private static void addNewTopWord(State state, ListMultimap<Integer, List<String>> topWords) {
        if (!topWords.containsKey(state.count)) {
            if (topWords.keySet().size() >= state.numberOfTopFrequencies) {
                topWords.removeAll(state.minCount);;
            }
        }
        topWords.put(state.count, Arrays.asList(state.word));
        state.minCount = Collections.min(topWords.keySet());
    }

    private static Set<String> multiListToSet(ListMultimap<Integer, List<String>> multilist) {
        Set<String> result = new HashSet<>();
        for (List<String> topWordsList : multilist.values()) {
            result.addAll(topWordsList);
        }
        return result;
    }

    public static class State {
        int minCount = 0;               // Minimal number of occurences that currently qualifies word for the toplist
        int count = 1;                  // Current count of occurences of the word
        String word = null;             // Current word
        int numberOfTopFrequencies;     // How many top frequencies are requested

        public State(Integer numberOfTopFrequencies) {
            this.numberOfTopFrequencies = numberOfTopFrequencies;
        }
    }

}
