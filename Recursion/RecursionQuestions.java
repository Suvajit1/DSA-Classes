package Recursion;

public class RecursionQuestions {

    public static int lastOccerence(int arr[], int i, int key){
        if(i==arr.length){
            return -1;
        }
        int foundAt = lastOccerence(arr, i+1, key);

        if(foundAt == -1 && arr[i]==key){
            return i;
        }

        return foundAt;
    }

    public static int tillingProblem(int n) {
        if(n==1 || n==2){
            return n;
        }

        return tillingProblem(n-1) + tillingProblem(n-2);
    }

    public static int friendsPairing(int n){
        if(n == 1 || n==2){
            return n;
        }
        return friendsPairing(n-1) + (n-1)*friendsPairing(n-2);
    }

    public static void duplicates(String str, boolean map[], StringBuilder newStr, int i ){
        if(i == str.length()){
            System.out.println(newStr);
            return;
        }
        if(!map[str.charAt(i)-'a']){
            map[str.charAt(i)-'a']=true;
            duplicates(str, map, newStr.append(str.charAt(i)), i+1);
        }else{
            duplicates(str, map, newStr, i+1);
        }
    }

    public static void binaryStringSequence(int n, char lastChar, String bStr){
        if(n==0){
            System.out.println(bStr);
            return;
        }

        if(lastChar == '0'){
            binaryStringSequence(n-1, '0', bStr+0);
            binaryStringSequence(n-1, '1', bStr+1);
        }else{
            binaryStringSequence(n-1, '0', bStr+0);
        }
    }

    public static void towerOfHanoi(int n, char src, char dest, char auxilary ){
        if(n==1){
            System.out.println("Disk "+n+" moves from "+src+" to "+dest);
            return;
        }
        towerOfHanoi(n-1, src, auxilary, dest);
        System.out.println("Disk "+n+" moves from "+src+" to "+dest);
        towerOfHanoi(n-1, auxilary, dest, src);
    }

    public static void main(String[] args) {
        int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 6, 1, 7};

        System.out.println(lastOccerence(arr, 0, 5));

        System.out.println(tillingProblem(4));

        System.out.println(friendsPairing(3));

        String str = "suvajitsadhukhan";
        duplicates(str, new boolean[26], new StringBuilder(""), 0);

        binaryStringSequence(3, '0', "");

        towerOfHanoi(3, 'A', 'C', 'B');
    }
}
