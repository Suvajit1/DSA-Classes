package BST;
import java.util.*;

public class BST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // build a BST
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val<root.data){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    } 

    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    } 
    
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }


    public static boolean searchInBST(Node root, int target){
        if(root == null){
            return false;
        }
        if(target < root.data){
            return searchInBST(root.left, target);
        }else if(root.data < target){
            return searchInBST(root.right, target);
        }else{
            System.out.println(root.data);
            return true;
        }
    }

    // Print in Range k1 and k2
    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(k1 <= root.data && root.data <= k2){

            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);

        }else if(root.data > k2){
            printInRange(root.left, k1, k2);

        }else{ // root.data < k1
            printInRange(root.right, k1, k2);
        }
    }

    // Mirror a BST
    public static Node mirror(Node root){
        if(root == null){
            return null;
        }

        Node rightMirror = mirror(root.left);
        Node leftMirror = mirror(root.right);

        root.left = leftMirror;
        root.right = rightMirror;

        return root;
    }

    // delete a Node form a BST
    public static Node delete(Node root, int val){
        // find the value to be deleted
        if(root.data > val){
            root.left = delete(root.left, val);
        }else if(root.data < val){
            root.right = delete(root.right, val);
        }else{ // root.data = val
            // leaf Node 
            if(root.left == null && root.right == null){
                return null;
            }

            // One Child 
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            // Two Children
            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static Node inOrderSuccessor(Node root){
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // root to all path
    public static void allPath(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }

        path.add(root.data);

        // leaf node 
        if(root.left == null && root.right == null){
            System.out.println(path);
        }
        allPath(root.left, path);
        allPath(root.right, path);

        path.remove(path.size()-1);
    }

    // Form Balanced BST given a sorted Array
    public static Node createBalancedBST(int vals[], int low, int high){
        if(high<low){
            return null;
        }

        int mid = low + (high-low)/2;
        Node root = new Node(vals[mid]);
        root.left = createBalancedBST(vals, low, mid-1);
        root.right = createBalancedBST(vals, mid+1, high);
        return root;
    }

    // Validate a BST
    public static boolean isValidBST(Node root , Node min, Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.data <= min.data){ //right
            return false;
        }
        if(max != null && root.data >= max.data){ //left
            return false;
        } 

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    } 

    // Size of Largest BST in BT
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static int maxSize = 0;

    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = largestBST(root.left);
        Info right = largestBST(root.right);

        // self
        int size = left.size + right.size + 1;
        int min = Math.min(root.data, Math.min(left.min, right.min));
        int max = Math.max(root.data, Math.max(left.max, right.max));

        // isBST
        if(root.data <= left.max || root.data >= right.min){
            return new Info(false, size, min, max);
        }
        if(left.isBST && right.isBST){
            maxSize = Math.max(maxSize, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public static void main(String[] args) {

        // int[] values = {8, 5, 3, 1, 4, 6, 7, 10 , 11, 14};
        // int[] values = {8, 5, 3, 6, 10, 11};

        int[] values = {12, 10, 3, 20, 15, 14, 12, 13, 18 , 25, 21, 22, 28};


        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }

        // inOrder(root);
        // System.out.println();

        // preOrder(root);
        // System.out.println();

        // postOrder(root);
        // System.out.println();

        // System.out.println(searchInBST(root, 6));

        // printInRange(root, 5, 12);
        // System.out.println();

        // mirror(root);

        // preOrder(root);
        // System.out.println();

        // inOrder(root);
        // System.out.println();

        // inOrder(root);
        // System.out.println();

        // delete(root, 21);
        // inOrder(root);
        // System.out.println();

        // delete(root,10);
        // inOrder(root);
        // System.out.println();

        // allPath(root, new ArrayList<>());


        // Form Balanced BST given a sorted Array
        // int[] vals = {3, 5, 6, 8, 10, 11, 12};
        // root = createBalancedBST(vals, 0, vals.length-1);
        // preOrder(root);
        // System.out.println();
        // System.out.println(isValidBST(root, null, null));

        // root = new Node(3);
        // root.left = new Node(2);
        // root.left.left = new Node(1);
        // root.left.right = new Node(4);
        // root.right = new Node(8);

        // System.out.println(isValidBST(root, null, null));


        // Size of Largest BST in BT
        root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        largestBST(root);
        System.out.println(maxSize); // 5

    }
}
