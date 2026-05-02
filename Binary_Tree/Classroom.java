package Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Classroom {
    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    static int i = -1;
    public static Node buildTree(int nodes[]){
        i++;
        if(nodes[i] == -1){
            return null;
        }
        Node root = new Node(nodes[i]);
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);

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

    public static void levelOrdeer(Node root){
        Queue<Node> q = new LinkedList<>();
        if(root==null){
            return;
        }

        q.add(root);
        q.add(new Node(-1));

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if(curr.data == -1){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(new Node(-1));
                }
            }else{
                System.out.print(curr.data+" ");
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int count(Node root){
        if(root==null){
            return 0;
        }
        return count(root.left) + count(root.right) + 1;
    }

    public static int sum(Node root){
        if(root==null){
            return 0;
        }
        return sum(root.left) + sum(root.right) + root.data;
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        Node root = buildTree(nodes);

        preOrder(root);
        System.out.println();

        inOrder(root);
        System.out.println();

        postOrder(root);
        System.out.println();

        levelOrdeer(root);
        System.out.println();

        System.out.println(height(root));
        System.out.println(count(root));
        System.out.println(sum(root));
    }
}
