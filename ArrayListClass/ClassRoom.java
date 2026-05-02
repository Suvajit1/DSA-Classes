package ArrayListClass;

import java.util.ArrayList;
import java.util.Collections;

public class ClassRoom {

    public static void swap(ArrayList<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // add -- O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        
        for(int i=0; i<list.size(); i++){ // size() -- O(1)
            System.out.println(list.get(i)); // get() -- O(1)
        }

        System.out.println(list);

        // remove - O(1)
        list.remove(2);
        System.out.println(list); // [1, 2, 4, 5]

        // set - O(1)
        list.set(2, 10);
        System.out.println((list)); // [1, 2, 10, 5]

        // add - O(n)
        list.add(2, 5); // [1, 2, 5, 10, 5]
        System.out.println(list);

        // contains - O(n)
        System.out.println(list.contains(5));

        list.addFirst(4); // O(n)
        list.addLast(9); // O(1)

        System.out.println(list); // [4, 1, 2, 5, 10, 5, 9]

        swap(list, 2, 4);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);


        // Multi-Diamention ArraayList
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        for(int i=0; i<5; i++){
            list1.add(i+1);
            list2.add(i+5);
            list3.add(i+10);
        }

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);

        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        System.out.println(mainList);

        list2.add(20);
        System.out.println(mainList);


    }
}
