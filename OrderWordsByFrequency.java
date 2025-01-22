/**
 * Anmoldeep Singh
 * 3149800
 */
import java.util.Comparator;

public class OrderWordsByFrequency implements Comparator<Entry<String, Integer>> {
    public int compare(Entry<String, Integer> a, Entry<String, Integer> b) {
        if (a.getValue() > b.getValue()) {
            return -1;
        } else if (a.getValue() < b.getValue()) {
            return 1;
        } else {
            return a.getKey().compareTo(b.getKey());
        }
    }
}