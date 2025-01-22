/**
 * Anmoldeep Singh
 * 3149800
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class PartA_Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner filePartA = new Scanner(new File("PartA.txt"));
        ProbeHashMap<String, Integer> wordMap = new ProbeHashMap<>();
        ProbeHashMap<String, Integer> characterMap = new ProbeHashMap<>();
        while (filePartA.hasNext()) {
            String word = filePartA.next().replaceAll("[^a-zA-Z]+", "").toLowerCase();
            for (int i = 0; i < word.length(); i++) {
                String character = word.substring(i, i + 1);
                if (characterMap.get(character) == null) {
                    characterMap.put(character, 1);
                } else {
                    characterMap.put(character, characterMap.get(character) + 1);
                }
            }
            if (wordMap.get(word) == null) {
                wordMap.put(word, 1);
            } else {
                wordMap.put(word, wordMap.get(word) + 1);
            }
        }

        // total number of distinct words
        int distinctWords = wordMap.size();
        // total number of distinct letters
        int distinctLetters = characterMap.size();
        // most occurring character
        Comparator<Entry<String, Integer>> characterComparator = new OrderLettersByFrequency();
        Entry<String, Integer> mostOccurringCharacter = findMaxLeast(characterMap, characterComparator);
        // least occurring character
        Entry<String, Integer> leastOccurringCharacter = findMaxLeast(characterMap, characterComparator.reversed());
        // most occurring word
        Comparator<Entry<String, Integer>> wordComparator = new OrderWordsByFrequency();
        Entry<String, Integer> mostOccurringWord = findMaxLeast(wordMap, wordComparator);
        // least occurring word
        Entry<String, Integer> leastOccurringWord = findMaxLeast(wordMap, wordComparator.reversed());
        // most occurring pronoun
        List<String> pronouns = List.of("i", "we", "you", "he", "she", "it", "they");
        Comparator<Entry<String, Integer>> pronounComparator = new OrderWordsByFrequency();
        Entry<String, Integer> mostOccurringPronoun = findCategoryMaxLeast(wordMap, pronounComparator, pronouns);
        // least occurring pronoun
        Entry<String, Integer> leastOccurringPronoun = findCategoryMaxLeast(wordMap, pronounComparator.reversed(),
                pronouns);

        // Print the results
        System.out.println("Text Analyzer");
        System.out.println("Total number of distinct words: " + distinctWords);
        System.out.println("Total number of distinct letters: " + distinctLetters);
        System.out.println("Most occurring character: " + mostOccurringCharacter.getKey() + ", "
                + mostOccurringCharacter.getValue());
        System.out.println("Least occurring character: " + leastOccurringCharacter.getKey() + ", "
                + leastOccurringCharacter.getValue());
        System.out.println("Most occurring word: " + mostOccurringWord.getKey() + ", " + mostOccurringWord.getValue());
        System.out
                .println("Least occurring word: " + leastOccurringWord.getKey() + ", " + leastOccurringWord.getValue());
        System.out.println("Most occurring pronoun: " +
                mostOccurringPronoun.getKey() + ", " + mostOccurringPronoun.getValue());
        System.out.println("Least occurring pronoun: " +
                leastOccurringPronoun.getKey() + ", " + leastOccurringPronoun.getValue());

    }

    public static <K, V> Entry<K, V> findMaxLeast(ProbeHashMap<K, V> map, Comparator<Entry<K, V>> comparator) {
        Iterator<Entry<K, V>> iterator = map.entrySet().iterator();
        Entry<K, V> maxLeast = iterator.next();
        while (iterator.hasNext()) {
            Entry<K, V> current = iterator.next();
            if (comparator.compare(current, maxLeast) < 0) {
                maxLeast = current;
            }
        }
        return maxLeast;
    }

    public static <K, V> Entry<K, V> findCategoryMaxLeast(ProbeHashMap<K, V> map, Comparator<Entry<K, V>> comparator,
            List<K> keys) {
        Iterator<Entry<K, V>> iterator = map.entrySet().iterator();
        Entry<K, V> maxLeast = null;
        while (iterator.hasNext()) {
            Entry<K, V> current = iterator.next();
            if (keys.contains(current.getKey())) {
                if (maxLeast == null || comparator.compare(current, maxLeast) < 0) {
                    maxLeast = current;
                }
            }
        }

        return maxLeast;
    }
}