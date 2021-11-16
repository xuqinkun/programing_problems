package leetcode.medium.arrays;

public class Exc_1014_MaxScoreSightseeingPair {

    public static void main(String[] args) {
        Exc_1014_MaxScoreSightseeingPair msp = new Exc_1014_MaxScoreSightseeingPair();
        System.out.println(msp.maxScoreSightseeingPair(new int[]{8,1,5,2,6,8,1,5,2,6}));
        System.out.println(msp.maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
        System.out.println(msp.maxScoreSightseeingPair(new int[]{1,2}));
    }

    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length;
        int maxScore = 0;
        int[] maxVals = new int[len];
        maxVals[0] = values[0];
        for (int i = 1; i < len; i++) {
            maxScore = Math.max(maxScore, maxVals[i - 1] + values[i] - i);
            maxVals[i] = Math.max(maxVals[i - 1], values[i] + i);
        }
        return maxScore;
    }
}
