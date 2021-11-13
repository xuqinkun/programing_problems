package leetcode.easy.dp;

public class Exc_053_MaxSubArray {

    public int maxSubArray(int[] nums) {
        Status status = divide(nums, 0, nums.length - 1);
        return status.mSum;
    }

    private Status divide(int[] nums, int l, int r) {
        if (l == r) {
            return new Status(nums[l], nums[l], nums[l], nums[l]);
        }
        int m = (l + r) >> 1;
        Status leftStatus = divide(nums, l, m);
        Status rightStatus = divide(nums, m + 1, r);
        return merge(leftStatus, rightStatus);
    }

    private Status merge(Status leftStatus, Status rightStatus) {
        int iSum = leftStatus.iSum + rightStatus.iSum;
        int lSum = Math.max(leftStatus.lSum, leftStatus.iSum + rightStatus.lSum);
        int rSum = Math.max(rightStatus.rSum, rightStatus.iSum + leftStatus.rSum);
        int mSum = Math.max(Math.max(leftStatus.mSum, rightStatus.mSum), leftStatus.rSum + rightStatus.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    static class Status {
        int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public static void main(String[] args) {
        Exc_053_MaxSubArray msa = new Exc_053_MaxSubArray();
        System.out.println(msa.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(msa.maxSubArray(new int[]{1}));
    }
}
