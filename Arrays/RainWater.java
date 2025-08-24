package Arrays;

public class RainWater {
    public static int trappedWater(int[] height){
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];

        // LMB
        leftMax[0] = height[0];
        for(int i=1; i<height.length; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        // BMB
        rightMax[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--){
            rightMax[i]= Math.max(rightMax[i+1], height[i]);
        }

        // trapped Water 
        int tw = 0;
        for(int i=0; i<height.length; i++){
            tw += Math.min(leftMax[i], rightMax[i])-height[i]; 
        }

        return tw;
    }

    public static void main(String[] args) {
        int height[] = {1, 1, 1, 1}; // 11

        System.out.println(trappedWater(height));
    }
}
