package ArrayListClass;

import java.util.ArrayList;

public class MaxWaterContainer {
    public static int maxWater(ArrayList<Integer> height){
        int maxWater = Integer.MIN_VALUE;

        int lp = 0, rp = height.size()-1;

        while (lp!=rp) {
            int w = rp-lp;
            int h = Math.min(height.get(lp), height.get(rp));
            int water = h*w;
            maxWater = Math.max(maxWater, water);

            if(height.get(lp) <= height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();

        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(height);
        System.out.println(maxWater(height));

    }
}
