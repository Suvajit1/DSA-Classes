package Heap;
// Q1 : Nearby Cars
import java.util.PriorityQueue;

public class Question1 {
    static class Car implements Comparable<Car>{
        int x;
        int y;
        int dist;

        Car(int x, int y){
            this.x = x;
            this.y = y;
            this.dist = x*x + y*y;
        }

        @Override
        public int compareTo(Car c2){
            return this.dist - c2.dist;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        PriorityQueue<Car> cars = new PriorityQueue<>(); // min heap
        for(int i=0; i<arr.length; i++){
            cars.add(new Car(arr[i][0], arr[i][1]));
        }

        for(int i=0; i<k; i++){
            System.out.println(cars.peek().x+", "+cars.peek().y);
            cars.remove();
        }
    }
}
