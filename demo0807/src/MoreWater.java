public class MoreWater {
    public int maxArea(int[] height) {


        int result = 0;
        int temp = 0;
        int n = height.length;
        if  (n < 2){
            return height[0] * n;
        }

        int i = 0;
        int j = n - 1;
        while (i < j){
            int minEdge = Math.min(height[i], height[j]);
            result = Math.max(result, minEdge * (j - i));
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return result;
    }
}
