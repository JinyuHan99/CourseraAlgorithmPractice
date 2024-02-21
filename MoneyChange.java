import java.util.Scanner;

public class MoneyChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        System.out.println(greedyLoop(m));
    }

    public static int greedyLoop(int m) {
        int remain = m;
        int num = 0;
        while (remain > 0) {
            if (remain >= 10) {
                num += remain / 10;
                remain = remain % 10;
            } else if (remain >= 5 & remain < 10) {
                num += remain / 5;
                remain = remain % 5;
            } else {
                num += remain;
                remain = remain % 1;
            }
        }
        return num;
    }
}
