import java.util.Arrays;
import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(getMajorityElement(a, n));
    }

    static int getMajorityElement(int[] a, int n) {
        Arrays.sort(a);
        int l = 0;
        int r = n - 1;
        for (int i = 0; i < n; i++) {
            if (a[i] != a[n / 2]) {
                continue;
            } else {
                l = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] != a[n / 2]) {
                continue;
            } else {
                r = i;
                break;
            }
        }
        if (r - l + 1 > n / 2) {
            return 1;
        } else {
            return 0;
        }
    }

}
