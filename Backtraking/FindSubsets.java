package Backtraking;

public class FindSubsets {
    public static void findSubsets(String set, String ans, int i){
        // base case
        if(i==set.length()){
            System.out.println(ans);
            return;
        }
        // recursion
        // yes include
        findSubsets(set, ans+set.charAt(i), i+1);
        // no -- doesn't include
        findSubsets(set, ans, i+1);

    }

    public static void main(String[] args) {
        String set = "abc";
        findSubsets(set, "", 0);
    }
}
