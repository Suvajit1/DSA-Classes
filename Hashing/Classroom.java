package Hashing;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import java.util.Set;


public class Classroom {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Priyam", 80);
        map.put("Dhrubo", 90);
        map.put("Arpan", 70);
        map.put("Suvajit", 65);
        map.put("Suvajit", 70);


        System.out.println(map);

        System.out.println(map.remove("Suvajit"));

        System.out.println(map.containsKey("Bhumika"));
        System.out.println(map.containsKey("Arpan"));

        System.out.println(map.get("Priyam"));

        System.out.println(map.keySet());

        Set<String> keys = map.keySet();
        // System.out.println(keys);

        for (String key : keys) {
            System.out.println(key);
        }


        LinkedHashMap<String, Integer> lmap = new LinkedHashMap<>();
        lmap.put("Priyam", 80);
        lmap.put("Dhrubo", 90);
        lmap.put("Arpan", 70);
        lmap.put("Suvajit", 65);

        System.out.println(lmap);


        TreeMap<String, Integer> tmap = new TreeMap<>();
        tmap.put("Priyam", 80);
        tmap.put("Dhrubo", 90);
        tmap.put("Arpan", 70);
        tmap.put("Suvajit", 65);

        System.out.println(tmap);

        int n = 3;
        int N = 2;

        double l = (double)n/N;
        System.out.println(l);

    }
}
