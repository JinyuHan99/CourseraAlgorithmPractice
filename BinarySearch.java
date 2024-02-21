import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            System.out.print(getResult(a, n, b[i]) + " ");
        }
    }

    public static int getResult(int[] a, int n, int target) {
        int left = 0;
        int right = n - 1;
        return binarySearch(left, right, a, target);
    }

    public static int binarySearch(int left, int right, int[] a, int target) {
        int mid = (left + right) / 2;

        //System.out.println("mid: " + mid);
        if (target < a[mid] & a[mid] != a[left]) {
            return binarySearch(left, mid-1, a, target);
        } else if (target > a[mid] & a[mid] != a[right]) {
            return binarySearch(mid+1, right, a, target);
        } else if (target == a[mid]) {
            return mid;
        } else {
            return -1;
        }
    }
}
