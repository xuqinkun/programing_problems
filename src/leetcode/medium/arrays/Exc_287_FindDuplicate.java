package leetcode.medium.arrays;

public class Exc_287_FindDuplicate {

    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[slow];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int p = 0, q = slow;
        while (p != q) {
            p = nums[p];
            q = nums[q];
        }
        return p;
    }

    public static void main(String[] args) {
        Exc_287_FindDuplicate fd = new Exc_287_FindDuplicate();
        int[] a = {1,3,4,2,2};
        System.out.println(fd.findDuplicate(a));
    }
}
