package job10.demo0001;

public class ThirdMaxSolution {

    public static int thirdMax(int[] nums){
        int length = nums.length;
        long first, second, third;
        first = second = third = Long.MIN_VALUE;
        for (int i = 0; i < length; i++){
            if (nums[i] > first){
                third = second;
                second = first;
                first = nums[i];
            }else if (nums[i] < first && nums[i] > second){
                third = second;
                second = nums[i];
            }else if (nums[i] < second && nums[i] > third){
                third = nums[i];
            }
        }
        if (third == Long.MIN_VALUE){
            return (int)first;
        }
        return (int)third;
    }

    public static void main(String[] args){
        int[] array = {1,2};
        int result = ThirdMaxSolution.thirdMax(array);
    }
}
