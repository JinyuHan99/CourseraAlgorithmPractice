
import java.util.ArrayList;
import java.util.Scanner;

public class FuelRefil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int d = scanner.nextInt();
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        ArrayList<Integer> stops = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            stops.add(scanner.nextInt());
        }
        int location = 0;

        int x = refills(location, stops, m, d);
        if (x >= 0) {
            System.out.println(x);
        } else {
            System.out.println(-1);
        }
    }

    static int refills(int location, ArrayList stops, int m, int d) {

        if (location + m >= d) {
            return 0;
        }
        if (stops.size() == 0) {
            return -10000000;
        }
        if (location + m < (int) stops.get(0)) {
            return -10000000;
        }
        int lastStop = location;
        while (stops.size() != 0 && (int) stops.get(0) - location <= m) {
            lastStop = (int) stops.get(0);
            stops.remove(0);
            //System.out.println(stops);
        }

        return 1 + refills(lastStop, stops, m, d);
    }
}


