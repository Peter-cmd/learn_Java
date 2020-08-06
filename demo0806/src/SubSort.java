class SubSort{
    public int[] subSort(int[] array) {
        if(array == null || array.length < 1){
            return new int[]{-1, -1};
        }
        int n = array.length;
        // 从左向右找有序的最大值
        int max = array[0];
        int right = -1;
        for (int i = 1; i < n; i++){
            if (array[i] >= max){
                max = array[i];
            }else{
                right = i;
            }
        }

        if (right == -1){
            return new int[]{-1, -1};
        }

        // 从右向左找有序的最小值
        int min = array[n - 1];
        int left = -1;
        for (int i = n - 2; i >= 0; i--){
            if (array[i] <= min){
                min = array[i];
            }else{
                left = i;
            }
        }
        return new int[]{left, right};
    }
}