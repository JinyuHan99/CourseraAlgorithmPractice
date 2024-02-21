import java.sql.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
//两数之和
public class StressTest {
    //暴力求解
    static long maxPairProNaive(long[] numbers) {
        long product = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                product = Math.max(product,
                        numbers[i] * numbers[j]);
            }
        }
        return product;
    }
//找到最大和次大的数
    public static long maxPairProFast(long[] m){
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

    public static void main(String[] args) {
        Random r = new Random();
        while(true) {
            int n = r.nextInt(2,5);
            long[] arr = new long[n];
            for(int i =0; i< n; i++){
                arr[i] = r.nextLong(0,200000);
            }
            long result1 = maxPairProNaive(arr);
            long result2 = maxPairProFast(arr);
            long result3 = maxPairProSort(arr);

            if(result1 == result3){
                System.out.println("OK");
            }else{
                System.out.println("Wrong answer: \n"+result1+","+result2);
                for(int i =0; i< n; i++){
                    System.out.println(arr[i]);;
                }
                return;
            }

        }

    }
//先排序再取乘积。算法复杂度取决于排序算法
    static long maxPairProSort(long[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length-1] * numbers[numbers.length-2];

    }
}
