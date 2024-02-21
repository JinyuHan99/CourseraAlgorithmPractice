import java.util.Scanner;

public class MaximumValueOfArithmeticExpression {
    private static long getMaximValue(String exp) {
        int[] digits = new int[exp.length() / 2 + 1];
        char[] ops = new char[exp.length() / 2];

        for(int i=0;i<exp.length();i++){
            if(i%2==0){
                digits[i/2] = exp.charAt(i) - '0';
            }else{
                ops[i/2] = exp.charAt(i);
            }
        }
        long[][] max = new long[digits.length][digits.length];
        long[][] min = new long[digits.length][digits.length];
        for(int i=0;i<digits.length;i++){
            max[i][i] = digits[i];
            min[i][i] = digits[i];
        }
        for(int s=1;s<digits.length;s++){
            for(int i=0;i<digits.length-s;i++){
                int j = i+s;
                max[i][j] = Long.MIN_VALUE;
                min[i][j] = Long.MAX_VALUE;
                for(int k=i;k<j;k++){
//                    System.out.println("i="+i+",j="+j+",k="+k);
                    long a = eval(max[i][k], max[k+1][j], ops[k]);
                    long b = eval(max[i][k], min[k+1][j], ops[k]);
                    long c = eval(min[i][k], max[k+1][j], ops[k]);
                    long d = eval(min[i][k], min[k+1][j], ops[k]);
                    max[i][j] = Math.max(max[i][j], Math.max(a, Math.max(b, Math.max(c, d))));
                    min[i][j] = Math.min(min[i][j], Math.min(a, Math.min(b, Math.min(c, d))));

                }
        }}
        return max[0][digits.length-1];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}
