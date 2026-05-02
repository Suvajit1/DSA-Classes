package Stack;

import java.util.Stack;

public class Question6 {
    public static int maxAreaHistogram(int height[]){
        int nsl[] = new int[height.length]; //idx
        int nsr[] = new int[height.length]; // idx

        Stack<Integer> s = new Stack<>(); // idx

        // Next Smaller left
        for(int i=0; i<height.length; i++){
            while (!s.isEmpty() && height[s.peek()] >= height[i]){
                s.pop();
            }

            if(s.isEmpty()){
                nsl[i] = -1;
            } else{
                nsl[i] = s.peek();
            }

            s.push(i);
        }

        s.clear();

        // Next Smaller Right
        for(int i=height.length-1; i>=0; i--){
            while (!s.isEmpty() && height[s.peek()] >= height[i]){
                s.pop();
            }

            if(s.isEmpty()){
                nsr[i] = height.length;
            } else{
                nsr[i] = s.peek();
            }

            s.push(i);
        }

        int maxArea = Integer.MIN_VALUE;

        for(int i=0; i<height.length; i++){
            maxArea = Math.max(maxArea, height[i]*(nsr[i]-nsl[i]-1));
        }

        return maxArea;
    }
    public static void main(String[] args) {
        int height[] = {2, 1, 5, 6, 2, 3};

        System.out.println(maxAreaHistogram(height));
    }
}
