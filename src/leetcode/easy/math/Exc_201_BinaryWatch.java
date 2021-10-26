package leetcode.easy.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exc_201_BinaryWatch {

    private static int[] hours = new int[]{1, 2, 4, 8};
    private static int[] minutes = new int[]{1, 2, 4, 8, 16, 32};

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> times = new ArrayList<>();
        for (int i = 0; i < turnedOn; i++) {
            List<Integer> hourList = combine(hours, i + 1);
            List<Integer> minuteList = combine(minutes, turnedOn - i - 1);
            construct(times, hourList, minuteList);
            hourList = combine(hours, turnedOn - i - 1);
            minuteList = combine(minutes, i + 1);
            construct(times, hourList, minuteList);
        }
        return times;
    }

    private void construct(List<String> times, List<Integer> hourList, List<Integer> minuteList) {
        if (hourList == null || minuteList == null) return;
        for (int j = 0; j < hourList.size(); j++) {
            Integer hour = hourList.get(j);
            if (hour > 11) continue;
            if (minuteList.size() == 0) {
                times.add(hour + ":00");
                continue;
            }
            for (int k = 0; k < minuteList.size(); k++) {
                Integer minute = minuteList.get(k);
                if (minute > 59) continue;
                String time = hour + ":";
                if (minute < 10)
                    time += "0" + minute;
                else
                    time += minute;
                if (!times.contains(time))
                    times.add(time);
            }
        }
        if (hourList.size() == 0) {
            for (int k = 0; k < minuteList.size(); k++) {
                Integer minute = minuteList.get(k);
                if (minute > 59) continue;
                String time = "0:";
                if (minute < 10)
                    time += "0" + minute;
                else
                    time += minute;
                if (!times.contains(time))
                    times.add(time);
            }
        }
    }

    private List<Integer> combine(int[] nums, int n) {
        if (n > nums.length) return null;
        List<Integer> ans = new ArrayList<>();
        combine(nums, ans, n, n, 0, 0);
        return ans;
    }

    private void combine(int[] nums, List<Integer> ans, int n, int tmp, int start, int currVal) {
        if (n == 0) return;
        if (tmp == 0) {
            if (!ans.contains(currVal))
                ans.add(currVal);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            currVal += nums[i];
            combine(nums, ans, n, tmp - 1, i + 1, currVal);
            currVal -= nums[i];
        }
    }

    public static void main(String[] args) {
        Exc_201_BinaryWatch bw = new Exc_201_BinaryWatch();
        List<String> ret = bw.readBinaryWatch(2);
        Collections.sort(ret);
        System.out.println(ret);
        System.out.println(ret.size());
    }
}
