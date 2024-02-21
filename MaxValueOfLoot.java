import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Math.min;

public class MaxValueOfLoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double tw = sc.nextDouble();

        ArrayList<Double> varr = new ArrayList<Double>();
        ArrayList<Double> warr = new ArrayList<Double>();
        ArrayList<Double> vwarr = new ArrayList<Double>();
        for(int i = 0;i<n;i++){
            double value = sc.nextDouble();
            double weight = sc.nextDouble();
            varr.add(value);
            warr.add(weight);
            vwarr.add(value/weight );

        }
        System.out.printf("%.4f",(greedyLoop(varr,warr,vwarr,tw)));
    }

    public static double greedyLoop(ArrayList<Double> varr, ArrayList<Double> warr, ArrayList<Double> vwarr, double tw){
        if(tw == 0){
            return 0.0000;
        }else{
        double total_v = 0.0000;
        double w_remain = tw;

        while(w_remain > 0 & vwarr.size() >= 1){
            int max_index = getMaxIndex(vwarr);
            total_v += vwarr.get(max_index)*min(w_remain,warr.get(max_index));
            w_remain = w_remain - min(w_remain,warr.get(max_index));
            varr.remove(max_index);
            warr.remove(max_index);
            vwarr.remove(max_index);
        }
        return total_v;
    }}
    public static int getMaxIndex(ArrayList<Double> vwarr){
        Double max = vwarr.get(0);

        int index = 0;
        for(int i = 0; i<vwarr.size();i++){
            if(vwarr.get(i)>=max){
                max = vwarr.get(i);
                index = i;
            }
        }
        return index;
    }

}
