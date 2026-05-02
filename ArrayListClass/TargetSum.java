package ArrayListClass;

import java.util.ArrayList;

public class TargetSum {
    public static boolean targetSum1(ArrayList<Integer> list, int target){
        int lp = 0, rp = list.size()-1;
        
        while (lp != rp) {
            int sum = list.get(lp) + list.get(rp);
            
            if(sum==target){
                return true;
            }else if(sum < target){
                lp++;
            }else{
                rp--;
            }
        }

        return false;
    }

    public static boolean targetSum2(ArrayList<Integer> list, int target){
        // finf lp and rp
        int i;
        for(i=0; i<list.size()-1; i++){
            if(list.get(i+1)<list.get(i)){
                break;
            }
        }

        // find pairsum
        int rp =i, lp=i+1;

        while (lp != rp) {
            int sum = list.get(lp) + list.get(rp);
            if(sum==target){
                return true;
            }else if(sum < target){
                lp = (lp+1) % list.size();
            }else{
                rp = (rp-1+list.size()) % list.size();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(targetSum1(list, 10));
        System.out.println(targetSum1(list, 100));

        list.clear();

        list.add(11);
        list.add(12);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.println(targetSum2(list, 15));
        System.out.println(targetSum1(list, 22));
        System.out.println(targetSum1(list, 10));


    }
}
