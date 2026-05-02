public class FindIndices {
    public static void check(int ar[], int i, int target) {
        if (i == ar.length) {
            return;
        }
        if (ar[i] == target) {
            System.out.println(i + " ");
            check(ar, ++i, target);
        } else
            check(ar, ++i, target);
    }

    public static void main(String[] args) {
        int ar[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        check(ar, 0, 2);
    }
}
