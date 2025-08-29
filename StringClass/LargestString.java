package StringClass;

public class LargestString {
    public static void main(String[] args) {
        String[] arrs = {"apple", "mango", "banana"};

        String largest = new String("");

        for(int i=0; i<arrs.length; i++){
            if(largest.compareToIgnoreCase(arrs[i])<0){
                largest = arrs[i];
            }
        }

        System.out.println(largest);
    }
}
