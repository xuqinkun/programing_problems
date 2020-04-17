package leetcode.medium.arrays;

public class Exc_055_JumpGame {

    private boolean canJump(int[] nums, int pos, Boolean jumpRecords[]) {
        if (jumpRecords[pos] != null) return jumpRecords[pos];
        for (int i = 1; i <= pos; i++) {
            if (jumpRecords[i] == null) {
                for (int j = 1; j <= i && (jumpRecords[i] == null || !jumpRecords[i]); j++) {
                    jumpRecords[i] = canJump(nums, i - j, jumpRecords) && nums[i - j] >= j;
                }
            }

        }
        return jumpRecords[pos] != null && jumpRecords[pos];
    }

    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 0) return false;
        Boolean[] jumpRecords = new Boolean[len];
        jumpRecords[0] = true;
        return canJump(nums, len - 1, jumpRecords);
    }

    public boolean canJump2(int[] nums) {
        int n = nums.length;
        if (n == 0) return false;
        int maxStep = nums[0];
        for (int i = 1; i < n; i++) {
            if (maxStep == 0) {
                return false;
            }
            maxStep--;
            if (nums[i] > maxStep) {
                maxStep = nums[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Exc_055_JumpGame jg = new Exc_055_JumpGame();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jg.canJump2(nums));
    }
}
