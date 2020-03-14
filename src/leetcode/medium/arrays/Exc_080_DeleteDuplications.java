package leetcode.medium.arrays;

public class Exc_080_DeleteDuplications {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, count, index = 0, last = ~nums[0];
        int i = 0;
        while (i < n) {
            count = 2;
            if (nums[i] != last) {
                last = nums[i++];
                nums[index++] = last;
                while (i < n && nums[i] == last) {
                    last = nums[i++];
                    if (--count > 0)
                        nums[index++] = last;
                }
            } else {
                last = nums[i++];
                nums[index++] = last;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Exc_080_DeleteDuplications dd = new Exc_080_DeleteDuplications();
        int[] a = {};
        int n = dd.removeDuplicates(a);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
