/**
 * Anmoldeep Singh
 * 3149800
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PartB_Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("PartB.txt"));
        LinkedChainHashMap<String, PostalCode> maps = new LinkedChainHashMap<>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] tokens = line.split(",");
            String code = tokens[0];
            String area = tokens[1];
            String province = tokens[2];
            double latitude = Double.parseDouble(tokens[3]);
            double longitude = Double.parseDouble(tokens[4]);
            PostalCode postalCode = new PostalCode(code, area, province, latitude, longitude);
            maps.put(code, postalCode);

        }
        System.out.println("Total Number of entries: " + maps.size());
        System.out.println("Number of collisions: " + maps.getCollisions());
        System.out.println("Display by code (C) or Longitude (L) (any other key to quit) ");
        Scanner inp = new Scanner(System.in);
        String input = inp.nextLine();
        if (input.equalsIgnoreCase("C")) {
            System.out.println("Display by code");
            for (String key : maps.keySet()) {
                System.out.println(maps.get(key).toString());
            }
        } else if (input.equalsIgnoreCase("L")) {
            System.out.println("Display by longitude");
            for (PostalCode postalCode : maps.values()) {
                System.out.println(postalCode);
            }
        } else {
            System.out.println("You chose to quit the program!");
        }

    }
}
