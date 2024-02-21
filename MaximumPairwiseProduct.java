import java.util.Scanner;

public class MaximumPairwiseProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextLong();
        }
        System.out.println(maxPairwisePro(arr));

    }

    public static long maxPairwisePro(long[] m){
        //System.out.prlongln(m.length);


        if(m.length == 2) {
            return m[0]*m[1];
        }
        long[] a = new long[2];
        if(m[0] <= m[1]){
            a[0] = m[0];
            a[1] = m[1];
        }else{
            a[0] = m[1];
            a[1] = m[0];
        }
        //System.out.prlongln(a[0]+"   "+a[1]);
        for(int i = 2; i < m.length; i++){
            //System.out.prlongln(m[i]);
            if((a[0] <= m[i]) & (m[i] < a[1])){
                a[0] = m[i];
                //System.out.prlongln(a[0]+"   "+a[1]);
            }else if(m[i] >= a[1]){
                a[0] = a[1];
                a[1] = m[i];
            }

        }

        return a[0] * a[1];

    }
}
