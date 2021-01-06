package array;

public class MajorityElement {
    /**
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int length = nums.length;
        // 将数组中第一个数作为第一个候选数
        int mode = nums[0];
        // 候选数给自己投一票
        int votes = 1;
        for (int i = 1; i < length; i++) {
            // 若当前票数为0
            if (votes == 0) {
                // 更新候选的数, 并给自己投一票
                mode = nums[i];
                votes += 1;
                continue;
            }
            // 若当前数不同于当前候选数, 就投一个反对票, 即使票数减1
            if (nums[i] != mode) {
                votes -= 1;
            }else {  //若当前数等于当前候选数, 就投一个支持票, 即使票数加1
                votes += 1;
            }

        }
        return mode;
    }
}
