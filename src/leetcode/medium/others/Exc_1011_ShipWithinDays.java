package leetcode.medium.others;

public class Exc_1011_ShipWithinDays {

    public int shipWithinDays(int[] weights, int D) {
        int totalWeight = 0, maxWeight = 0;
        for (int w : weights) {
            totalWeight += w;
            maxWeight = Math.max(w, maxWeight);
        }
        int minLoad = Math.max(totalWeight / D, maxWeight);
        while (daysWithLoadWeight(weights, minLoad) > D) {
            minLoad++;
        }
        return minLoad;
    }

    private int daysWithLoadWeight(int[] weights, int loadWeight) {
        int days = 0, tmp = 0;
        for (int i = 0; i < weights.length; i++) {
            tmp += weights[i];
            if (tmp > loadWeight) {
                days += 1;
                tmp = weights[i];
            }

        }
        return days + 1;
    }

    public static void main(String[] args) {
        Exc_1011_ShipWithinDays swd = new Exc_1011_ShipWithinDays();
        System.out.println(swd.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(swd.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println(swd.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }
}
