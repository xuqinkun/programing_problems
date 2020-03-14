package leetcode.medium.arrays;

public class Exc_495_FindPoisonedDuration {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        if (n == 0) return 0;

        int total = 0;
        for(int i = 0; i < n - 1; ++i)
            total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        return total + duration;
    }

    public static void main(String[] args) {
        Exc_495_FindPoisonedDuration fpd = new Exc_495_FindPoisonedDuration();
        int[] a = {1,2,3,4};
        int d = 3;
        System.out.println(fpd.findPoisonedDuration(a, d));
    }
}
