package leetcode.medium.sort;

import java.util.*;

public class Exc_056_MergeInterval {

    class Interval {
        int left, right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.left - o2.left;
        }
    }

    public int[][] merge(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        return merge(list);
    }

    private int[][] merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        for (int i = 0; i < intervals.size() - 1; ) {
            Interval left = intervals.get(i);
            Interval right = intervals.get(i + 1);
            if (left.right >= right.left) {
                left.right = Math.max(left.right, right.right);
                intervals.remove(i + 1);
            } else {
                i++;
            }
        }
        int n = intervals.size();
        int[][] ret = new int[n][2];
        for (int i = 0; i < n; i++) {
            Interval interval = intervals.get(i);
            ret[i][0] = interval.left;
            ret[i][1] = interval.right;
        }
        return ret;
    }

    public static void main(String[] args) {
        Exc_056_MergeInterval em = new Exc_056_MergeInterval();
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = em.merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }
        intervals = new int[][]{{1, 4}, {4, 5}, {5, 10}, {10, 18}};
        merge = em.merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }
    }
}
