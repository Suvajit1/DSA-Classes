package Binary_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeB {
    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    } 

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int diameter(Node root){
        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        int selfDiam = lh+rh+1;

        return Math.max(selfDiam, Math.max(diameter(root.left), diameter(root.right)));
    }


    static class Info {
        int height;
        int diameter;

        Info(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static Info diameter2(Node root){
        if(root == null){
            return new Info(0,0);
        }

        Info leftTree = diameter2(root.left);
        Info rightTree = diameter2(root.right);

        int h = Math.max(leftTree.height, rightTree.height)+1;
        int sd = leftTree.height + rightTree.height + 1;
        int d = Math.max(Math.max(leftTree.diameter, rightTree.diameter), sd);

        return new Info(h, d);
    }

    static class NodeInfo {
        Node node;
        int hd;

        public NodeInfo(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root){
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;

        // BFS
        Queue<NodeInfo> q = new LinkedList<>();
        q.add(new NodeInfo(root, 0));
        while (!q.isEmpty()) {
            NodeInfo curr = q.remove();
            if(!map.containsKey(curr.hd)){
                map.put(curr.hd, curr.node);
                min = Math.min(min, curr.hd);
                max = Math.max(max, curr.hd);
            }
            //left
            if(curr.node.left!=null){
                q.add(new NodeInfo(curr.node.left, curr.hd-1));
            }
            //right
            if(curr.node.right!=null){
                q.add(new NodeInfo(curr.node.right, curr.hd+1));
            }
        }

        for(int i=min; i<=max; i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }

    public static boolean isSubTree(Node root, Node subRoot){
        // finding subroot in actual tree
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){ // identcal
                return true;
            }
        }
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);   
    }

    public static boolean isIdentical(Node node, Node subRoot){
        if(node == null && subRoot == null){
            return true;
        }
        else if(node == null || subRoot == null || node.data != subRoot.data){
            return false;
        }

        // left
        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        // right
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;
    }

    // k-th level of a tree
    public static void kthLevel(Node root, int level, int k){
        if(root == null){
            return;
        }
        if(k == level){
            System.out.print(root.data+" ");
        }
        kthLevel(root.left, level+1, k);
        kthLevel(root.right, level+1, k);
    }

    public static int lca(Node root, int n1, int n2){
        ArrayList<Node> pathN1 = new ArrayList<>();
        ArrayList<Node> pathN2 = new ArrayList<>();

        getPath(root, n1, pathN1);
        getPath(root, n2, pathN2);

        if(pathN1.size()==0 || pathN2.size()==0){
            return -1;
        }

        int i;
        for(i=0; i<pathN1.size() && i<pathN2.size(); i++){
            if(pathN1.get(i) != pathN2.get(i)){
                break;
            }
        }
   
        return pathN1.get(i-1).data;
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root == null){
            return false;
        }

        path.add(root);

        if(root.data == n){
            return true;
        }

        if(getPath(root.left, n, path) || getPath(root.right, n, path)){
            return true;
        }

        path.remove(path.size()-1);

        return false;
    }

    public static Node lca2(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if(leftLca == null){
            return rightLca;
        }
        if(rightLca == null){
            return leftLca;
        }
        return root;
    }

    public static int minDistance(Node root, int n1, int n2){
        Node lca = lca2(root, n1, n2);

        return distance(lca, n1) + distance(lca, n2);
    }

    public static int distance(Node root, int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int left = distance(root.left, n);
        int right = distance(root.right, n);

        if(left == -1 && right == -1){
            return -1;
        }
        // valid distance >= 0 [> -1]
        if(left == -1){
            return right+1;
        }else{ // right == -1
            return left+1;
        }

        // return left>right ? left+1 : right+1;
    }

    public static int transform(Node root){
        if(root == null){
            return 0;
        }
        int data = root.data;

        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        if(root.left != null && root.right !=null){
            root.data = leftChild + root.left.data + rightChild + root.right.data;
        }else{
            root.data = leftChild+rightChild;
        }

        return data;
    }

    // k-th Ancestor
    public static int kthAncestor(Node root, int n, int k){
        if (root == null) {
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int left = kthAncestor(root.left, n, k);
        int right = kthAncestor(root.right, n, k);

        if(left == -1 && right == -1){
            return -1;
        }
        int dist = Math.max(left, right) + 1; // valid distance

        if (dist == k) {
            System.out.println(root.data);
        }

        return dist;
    }


    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // root.left.left.left = new Node(8);

        // System.out.println(diameter(root));

        // System.out.println(diameter2(root).diameter);

        // topView(root);

        /*    2 
             / \ 
            4   5 
        */

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        // subRoot.left.left = new Node(7);

        // System.out.println(isSubTree(root, subRoot));

        // kthLevel(root, 1, 3);
        // System.out.println();


        // System.out.println(lca(root, 4, 8));

        // Node lca = lca2(root, 4, 9);
        // if(lca != null){
        //     System.out.println(lca.data);
        // }else{
        //     System.out.println(-1);
        // }

        // // System.out.println(minDistance(root, 8, 0));

        // transform(root);
        // preOrder(root);

        kthAncestor(root, 5, 2);
    
    }
}
