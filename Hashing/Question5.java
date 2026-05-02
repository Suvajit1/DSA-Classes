package Hashing;

import java.util.HashMap;

public class Question5 {
    public static void main(String[] args) {

        String tickets[][] = {  // from to 
            {"Chennai", "Bangaluru"},
            {"Mumbai", "Delhi"},
            {"Goa", "Chennai"},
            {"Delhi", "Goa"}
        };

        HashMap<String, String> fromtoMap = new HashMap<>();
        HashMap<String, String> tofromMap = new HashMap<>();

        for(int i=0; i<tickets.length; i++){
            fromtoMap.put(tickets[i][0], tickets[i][1]);
            tofromMap.put(tickets[i][1], tickets[i][0]);
        }

        String src = null;
        for(String stop : fromtoMap.keySet()){
            if(!tofromMap.containsKey(stop)){
                src = stop;
                break;
            }
        }

        System.out.print(src);

        while (!fromtoMap.isEmpty()) {
            String dest = fromtoMap.remove(src);
            System.out.print("-->"+dest);
            src = dest;
        }
        System.out.println();
    }
}
