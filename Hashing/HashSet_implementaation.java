package Hashing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class HashSet_implementaation {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        
        int arr[] = {1, 12, 5, 2, 8,  9};

        for(int i : arr){
            hs.add(i);
        }

        System.out.println(hs);

        // order preserved
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        
        for(int i : arr){
            lhs.add(i);
        }

        System.out.println(lhs);


        TreeSet<Integer> ts = new TreeSet<>();

        for(int i : arr){
            ts.add(i);
        }

        System.out.println(ts);

        System.out.println(hs.contains(3));


        Iterator<Integer> it = hs.iterator();

        System.out.println(it.hasNext());

        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println(it.hasNext());


        for(Integer i : hs){
            System.out.println(i);
        }
    }
}
