package leetcode.medium.design;

import java.util.*;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_355_TwitterDemo
 * Author:   Xu Qinkun
 * Date:     2020/4/13 9:53
 * Description:
 */

public class Exc_355_TwitterDemo {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(1, 505);
        twitter.postTweet(1, 333);
        twitter.postTweet(1, 22);
        twitter.postTweet(2, 1);
        twitter.postTweet(1, 11);

        twitter.follow(1, 2);
        twitter.unfollow(1, 2);

        System.out.println(twitter.getNewsFeed(1));
    }
}

class Twitter {
    public static final int FEEDS_NUM = 10;
    Map<Integer, Set<Integer>> subscribeMap;
    Map<Integer, Tweet> tweets;

    private static int counter = 0;

    static class Tweet {
        int id;
        final int timestamp;
        Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.timestamp = counter++;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        subscribeMap = new HashMap<>();
        tweets = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId);
        if (tweets.containsKey(userId)) {
            tweet.next = tweets.get(userId);
        }
        tweets.put(userId, tweet);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followeeSet = subscribeMap.get(userId);
        if (followeeSet == null) {
            followeeSet = new HashSet<>();
        }
        Set<Integer> userSet = new HashSet<>(followeeSet);
        userSet.add(userId);

        PriorityQueue<Tweet> queue = new PriorityQueue<>((o1, o2) -> (o2.timestamp - o1.timestamp));
        for (int id : userSet) {
            Tweet tweet = tweets.get(id);
            for (int i = 0; i < FEEDS_NUM && tweet != null; i++) {
                queue.add(tweet);
                tweet = tweet.next;
            }
        }
        return getTopK2(new PriorityQueue<>(queue), FEEDS_NUM);
    }

    private List<Integer> getTopK2(PriorityQueue<Tweet> queue, int k) {
        if (queue == null || queue.isEmpty()) {
            return new ArrayList<>();
        }
        int min = Math.min(queue.size(), k);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < min && !queue.isEmpty(); i++) {
            list.add(queue.poll().id);
        }
        return list;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (subscribeMap.containsKey(followerId)) {
            subscribeMap.get(followerId).add(followeeId);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            subscribeMap.put(followerId, set);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (subscribeMap.containsKey(followerId)) {
            Set<Integer> followeeSet = subscribeMap.get(followerId);
            if (followeeSet.contains(followeeId)) {
                followeeSet.remove(followeeId);
                if (followeeSet.isEmpty())
                    subscribeMap.remove(followerId);
            }
        }
    }
}