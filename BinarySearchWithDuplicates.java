import java.util.Scanner;

public class BinarySearchWithDuplicates {
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
            System.out.print(binarySearch(a,b[i])+ " ");
        }

    }
    static int binarySearch(int[] a, int x) {
        int l = 0, r = a.length-1;

        while(l<=r){
            int m=l+(r-l)/2;
            if(a[m]>x){
                r=m-1;
            }else if(a[m]<x){
                l=m+1;
            }else{
                while(m>=0 && a[m]==x){
                    m--;
                }
                m++;
                return m;
            }
        }
        return -1;
    }
}
