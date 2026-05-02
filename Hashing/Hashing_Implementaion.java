package Hashing;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Hashing_Implementaion {

    static class HashMap<K, V> { // Generic Class

        private class Node {
            
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int N; // Bucket Size 
        private int n; // total no. of element is the map

        private LinkedList<Node> bucket[]; // N

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.n = 0;
            this.N = 4;
            this.bucket = new LinkedList[N];

            for(int i=0; i<bucket.length; i++){
                bucket[i] = new LinkedList<>();
            }
        }

        public void put(K key, V value){
            int bi = hashFuncton(key); // 0 to N-1
            int di = serachINLL(key, bi);

            if(di != -1){
                // update
                Node node = bucket[bi].get(di);
                node.value = value;

            }else{ // -1
                // add new node
                bucket[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double)n/N;
            if(lambda > 2.0){
                rehash();
            }
        }

        private int hashFuncton(K key){
            return Math.abs(key.hashCode()) % N;
        }

        private int serachINLL(K key, int bi){
            LinkedList<Node> ll = bucket[bi];

            for(int i=0; i<ll.size(); i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return i;
                }
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node>[] oldBucket = bucket;

            N = 2*N; 
            bucket = new LinkedList[N]; // new bucket

            for(int i=0; i<bucket.length; i++){
                bucket[i] = new LinkedList<>();
            }

            for(int i=0; i<oldBucket.length; i++){
                LinkedList<Node> ll = oldBucket[i];

                // for(int j=0; j<ll.size(); j++){
                //     Node node = ll.get(j);
                //     put(node.key, node.value);
                // }
                while (!ll.isEmpty()) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public boolean containsKey(K key){
            int bi = hashFuncton(key);
            int di = serachINLL(key, bi);

            if(di != -1){
                return true;
            }else{
                return false;
            }
        }  
        
        public V get(K key){
            int bi = hashFuncton(key);
            int di = serachINLL(key, bi);

            if(di != -1){
                Node node = bucket[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }

        public V remove(K key){
            int bi = hashFuncton(key);
            int di = serachINLL(key, bi);

            if(di != -1){
                Node node = bucket[bi].remove(di);
                n--;
                return node.value;
            }else{
                return null;
            }
        }

        public boolean isEmpty(){
            return n==0;
        }

        public List<K> keySet(){
            List<K> keys = new ArrayList<>();

            for(int i=0; i<bucket.length; i++){
                LinkedList<Node> ll = bucket[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }

            return keys;
        }
    }

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Priyam", 80);
        map.put("Dhrubo", 90);
        map.put("Arpan", 70);
        map.put("Suvajit", 65);
        map.put("Suvajit", 70);
        map.put("Suvajit1", 60);
        map.put("Suvajit2", 60);
        map.put("Suvajit3", 70);
        map.put("Suvajit4", 80);
        map.put("Suvajit5", 70);


        for(String key : map.keySet()){
            System.out.println(key+" : "+map.get(key));
        }

        System.out.println("---------------------------");
        map.remove("Suvajit1");

        for(String key : map.keySet()){
            System.out.println(key+" : "+map.get(key));
        }

    }
}
