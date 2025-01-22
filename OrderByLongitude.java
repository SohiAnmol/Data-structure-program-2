/**
 * Anmoldeep Singh
 * 3149800
 */
import java.util.Comparator;

public class OrderByLongitude implements Comparator<PostalCode> {
    public int compare(PostalCode postalCode1, PostalCode postalCode2) {
        if (postalCode1.getLongitude() < postalCode2.getLongitude()) {
            return -1;
        } else if (postalCode1.getLongitude() > postalCode2.getLongitude()) {
            return 1;
        } else {
            return 0;
        }

    }
}
