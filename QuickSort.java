/**
 * Anmoldeep Singh
 * 3149800
 */
import java.util.Comparator;

public class QuickSort {
    public static <K> void quickSort(LinkedQueue<K> S, Comparator<K> comp) {
        int n = S.size();
        if (n < 2)
            return; // queue is trivially sorted
        // divide
        K pivot = S.first(); // using first as arbitrary pivot
        LinkedQueue<K> L = new LinkedQueue<>();
        LinkedQueue<K> E = new LinkedQueue<>();
        LinkedQueue<K> G = new LinkedQueue<>();
        while (!S.isEmpty()) { // divide original into L, E, and G
            K element = S.dequeue();
            int c = comp.compare(element, pivot);
            if (c < 0) // element is less than pivot
                L.enqueue(element);
            else if (c == 0) // element is equal to pivot
                E.enqueue(element);
            else // element is greater than pivot
                G.enqueue(element);
        }
        // conquer
        quickSort(L, comp); // sort elements less than pivot
        quickSort(G, comp); // sort elements greater than pivot
        // concatenate results
        while (!L.isEmpty())
            S.enqueue(L.dequeue());
        while (!E.isEmpty())
            S.enqueue(E.dequeue());
        while (!G.isEmpty())
            S.enqueue(G.dequeue());
    }
}
