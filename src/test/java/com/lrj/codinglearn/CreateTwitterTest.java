package com.lrj.codinglearn;

import java.util.*;

/**
 * @ClassName: CreateTwitterTest
 * @Description:
 * @Date: 2023/11/3 10:48
 * @Author luorenjie
 * @Version V1.0
 * @Since JDK 1.8
 */
public class CreateTwitterTest {
    public static void main(String[] args) {
        CreateTwitterTest test = new CreateTwitterTest();
        Twitter twitter = test.new Twitter();
        twitter.postTweet(1, 5); // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 5)
        twitter.getNewsFeed(1); // 用户 1 的获取推文应当返回一个列表，其中包含一个 id 为 5 的推文
        twitter.follow(1, 2); // 用户 1 关注了用户 2
        twitter.postTweet(2, 6); // 用户 2 发送了一个新推文 (推文 id = 6)
        twitter.getNewsFeed(1); // 用户 1 的获取推文应当返回一个列表，其中包含两个推文，id 分别为 -> [6, 5] 。推文 id 6 应当在推文 id 5 之前，因为它是在 5 之后发送的
        twitter.unfollow(1, 2); // 用户 1 取消关注了用户 2
        twitter.getNewsFeed(1); // 用户 1 获取推文应当返回一个列表，其中包含一个 id 为 5 的推文。因为用户 1 已经不再关注用户 2
    }
    private int timestamp = 0;
    //用户类
    class User{
        private int id;
        private Set<Integer> followed;
        //用户发表推文的链表头节点
        private Tweet head;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            this.head = null;
            follow(id);
        }

        //关注
        private void follow(int id) {
            followed.add(id);
        }

        //取关
        private void unfollow(int id){
            if (id != this.id){
                followed.remove(id);
            }
        }

        //推文
        private void post(int tweetId){
            Tweet tweet = new Tweet(tweetId, timestamp);
            timestamp++;
            //新建的推文放入链表头
            tweet.next = head;
            head = tweet;
        }

    }

    //推文类
    class Tweet{
        private int id;
        private int time;
        private Tweet next;

        // 需要传入推文内容（id）和发文时间
        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }

        public int getTime() {
            return time;
        }
    }

    class Twitter {
        Map<Integer, User> userMap = new HashMap<>();

        public Twitter() {

        }

        //user发布一条tweet动态
        public void postTweet(int userId, int tweetId) {
            //若user不存在，则新建
            if (!userMap.containsKey(userId)){
                userMap.put(userId, new User(userId));
            }
            User user = userMap.get(userId);
            user.post(tweetId);
        }

        /**
         * 返回该 user 关注的人（包括他自己）最近的动态 id，
         * 最多 10 条，而且这些动态必须按从新到旧的时间线顺序排列。
         */
        public List<Integer> getNewsFeed(int userId) {
            //推文id集
            List<Integer> res = new ArrayList<>();
            if (!userMap.containsKey(userId)){
                return res;
            }
            //拿到用户
            User user = userMap.get(userId);
            //拿到用户的关注列表
            Set<Integer> followedUsers = user.followed;
            //使用优先级队列
            PriorityQueue<Tweet> pq = new PriorityQueue(followedUsers.size(), (x, y) ->(((Tweet) y).time - ((Tweet) x).time));
            for (Integer followedUser : followedUsers) {
                //检查当前用户是否有发推文
                Tweet tweet = userMap.get(followedUser).head;
                if (tweet == null){
                    continue;
                }
                pq.add(tweet);
            }

            while (!pq.isEmpty()){
                if (res.size() == 10){
                    break;
                }
                Tweet tweet = pq.poll();
                res.add(tweet.id);

                //将下一篇插入排序
                if (tweet.next != null){
                    pq.add(tweet.next);
                }
            }
            return res;
        }


        public void follow(int followerId, int followeeId) {
            //关注者不存在则新建
            if (!userMap.containsKey(followerId)){
                userMap.put(followerId, new User(followerId));
            }

            //被关注者不存在则新建
            if (!userMap.containsKey(followeeId)){
                userMap.put(followeeId, new User(followeeId));
            }

            userMap.get(followerId).follow(followeeId);

        }

        public void unfollow(int followerId, int followeeId) {
            if (userMap.containsKey(followerId)){
                userMap.get(followerId).unfollow(followeeId);
            }
        }
    }
}
