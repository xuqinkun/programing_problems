package leetcode.medium.dfs;

import java.util.*;

public class Exc_207_Prerequisites {
    class Node {
        int classNo;
        List<Node> successorList;
        int preNum;

        public Node(int classNo) {
            this.classNo = classNo;
            successorList = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + classNo +
                    ", preNum=" + preNum +
                    ", successorList=" + successorList +
                    '}';
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> cache = new HashMap<>();
        PriorityQueue<Node> preClassQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.preNum - o2.preNum;
            }
        });
        for (int[] pair : prerequisites) {
            int currClassNo = pair[0], preClassNo = pair[1];
            if (currClassNo == preClassNo) return false;
            Node currClass = cache.getOrDefault(currClassNo, new Node(currClassNo));
            Node preClass = cache.getOrDefault(preClassNo, new Node(preClassNo));
            // 完成当前课程需要完成前置课程，在图当中，将入度+1
            currClass.preNum++;
            if (!cache.containsKey(currClassNo)) {
                cache.put(currClassNo, currClass);
            }
            if (!cache.containsKey(preClassNo)) {
                cache.put(preClassNo, preClass);
            }
            preClass.successorList.add(currClass);
        }

        Node preMost = getPreMost(cache);

        while (preMost != null && preMost.preNum == 0 && cache.size() > 1) {
            for (Node successor : preMost.successorList) {
                successor.preNum--;
            }
            cache.remove(preMost.classNo);
            preMost = getPreMost(cache);
        }
        return cache.size() <= 1;
    }

    private Node getPreMost(Map<Integer, Node> cache) {
        int min = Integer.MAX_VALUE;
        int classNo = -1;
        for (Node cls : cache.values()) {
            if (cls.preNum < min) {
                min = cls.preNum;
                classNo = cls.classNo;
            }
        }
        return cache.getOrDefault(classNo, null);
    }

    public static void main(String[] args) {
        Exc_207_Prerequisites preq = new Exc_207_Prerequisites();
        System.out.println(preq.canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
        System.out.println(preq.canFinish(3, new int[][]{{1, 2}, {1, 0}, {0, 1}}));
        System.out.println(preq.canFinish(1, new int[][]{}));
        System.out.println(preq.canFinish(3, new int[][]{{1,0},{2,1}}));
        System.out.println(preq.canFinish(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
    }
}
