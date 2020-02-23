package pat;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * A family hierarchy is usually presented by a pedigree tree. Your job is to count those family members who have no child.
 *
 * Input Specification:
 * Each input file contains one test case. Each case starts with a line containing 0<N<100, the number of nodes in a tree, and M (<N), the number of non-leaf nodes. Then M lines follow, each in the format:
 *
 * ID K ID[1] ID[2] ... ID[K]
 * where ID is a two-digit number representing a given non-leaf node, K is the number of its children, followed by a sequence of two-digit ID's of its children. For the sake of simplicity, let us fix the root ID to be  01.
 *
 * The input ends with N being 0. That case must NOT be processed.
 *
 * Output Specification:
 * For each test case, you are supposed to count those family members who have no child for every seniority level starting from the root. The numbers must be printed in a line, separated by a space, and there must be no extra space at the end of each line.
 *
 * The sample case represents a tree with only 2 nodes, where 01 is the root and 02 is its only child. Hence on the root 01 level, there is 0 leaf node; and on the next level, there is 1 leaf node. Then we should output 0 1 in a line.
 *
 * Sample Input:
 * 2 1
 * 01 1 02
 * Sample Output:
 * 0 1
 */
public class PAT_1004_CountingLeaves {

    public static final int MAX_NODES = 100;

    public static String count(int[][] lines) {
        if (lines == null || lines[0].length < 3) {
            return "";
        }
        int[] childNumOfNode = getChildren(lines);
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(lines[0][0]);
        int totalOfCurrLevel = 1;
        StringBuilder builder = new StringBuilder();
        builder.append("0 ");
        while (!queue.isEmpty()) {
            int childrenNumOfCurrLevel = 0;
            int leafNodeCount = 0;
            while (totalOfCurrLevel -- > 0 && !queue.isEmpty()) {
                int level = queue.poll() - 1;
                if (level < 0) {
                    return "";
                }
                int childrenNum = lines[level][1];
                // add the child nodes into queue
                int[] currLevel = lines[level];
                for (int i = 2; i < childrenNum + 2; i++) {
                    int nodeID = currLevel[i];
                    if (childNumOfNode[nodeID] == 0) {
                        leafNodeCount++;
                    } else {
                        queue.add(nodeID);
                        childrenNumOfCurrLevel++;
                    }
                }
            }
            totalOfCurrLevel = childrenNumOfCurrLevel;
            builder.append(leafNodeCount);
            if (!queue.isEmpty()) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    private static int[] getChildren(int[][] lines) {
        int [] nums = new int[MAX_NODES];
        for (int i = 0; i < lines.length; i++) {
           nums[lines[i][0]] = lines[i][1];
        }
        return nums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String[] strs = first.split(" ");
        int N = Integer.parseInt(strs[0]);
        int M = Integer.parseInt(strs[1]);
        if (N==0 || N > 100 || M >= N) {
            return;
        }
        int maxLine = 100;
        int[][] nodes = new int[maxLine][N + 2];
        int level = 0;
        while (level < M) {
            String line = sc.nextLine();
            String[] nums = line.split(" ");
            int nodeNo = Integer.parseInt(nums[0]);
            int n = Integer.parseInt(nums[1]) + 2;
            for (int i = 0; i < n; i++) {
                nodes[nodeNo - 1][i] = Integer.parseInt(nums[i]);
            }
            level++;
        }
        String ret = count(nodes);
        System.out.println(ret);
    }
}
