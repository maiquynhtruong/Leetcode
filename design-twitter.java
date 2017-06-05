public class Twitter {

    /** Initialize your data structure here. */
    public Twitter() {
        HashMap<Integer, List<Integer>> followees = new HashMap<Integer, LinkedList<Integer>>();
        HashMap<Integer, List<Integer>> followers = new HashMap<Integer, LinkedList<Integer>>();
        HashMap<Integer, List<Integer>> newsfeeds = new HashMap<Integer, List<Integer>>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        for (List<Integer> followerList : followers.get(userId)) {
            for (Integer followerId : followerList) {
                newsfeeds.get(followerId).add(tweetId);
            }
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsfeedUserId = new ArrayList<Integer>();
        for (int i = 0; i < 10 && i < newsfeed.get(userId).length; i++) {
            newsfeedUserId.add(newsfeed.get(userId).getFirst());
        }
        return newsfeedUserId;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        followees.get(followerId).add(followeeId);
        followers.get(followeeId).add(followerId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        followees.get(followerId).remove(followeeId);
        followers.get(followeeId).remove(followerId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
