package seattle.algostar.ps.leetcode;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Problem355_JW {
	public static void main(String[] args) {
		new Problem355_JW().solve();
	}

	private void solve() {
		Twitter twitter = new Twitter();

		// User 1 posts a new tweet (id = 5).
		twitter.postTweet(1, 5);

		// User 1's news feed should return a list with 1 tweet id -> [5].
		System.out.println(twitter.getNewsFeed(1));;

		// User 1 follows user 2.
		twitter.follow(1, 2);

		// User 2 posts a new tweet (id = 6).
		twitter.postTweet(2, 6);

		// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
		// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
		System.out.println(twitter.getNewsFeed(1));;

		// User 1 unfollows user 2.
		twitter.unfollow(1, 2);

		// User 1's news feed should return a list with 1 tweet id -> [5],
		// since user 1 is no longer following user 2.
		twitter.getNewsFeed(1);
		
	}
	
	class Twitter {
		class Tweet implements Comparable<Tweet> {
			long timeStamp;
			int id;
			
			public Tweet(long ts, int id) {
				this.timeStamp = ts;
				this.id = id;
			}

			@Override
			public int compareTo(Tweet o) {
				return ((Long)this.timeStamp).compareTo(o.timeStamp);
			}

			@Override
			public String toString() {
				return "Tweet [timeStamp=" + timeStamp + ", id=" + id + "]";
			}
		}
		
		Map<Integer, Set<Integer>> follow = null;
		Map<Integer, List<Tweet>> tweets = null;
		Map<Integer, List<Tweet>> newsFeed = null;
		
	    /** Initialize your data structure here. */
	    public Twitter() {
	    	follow = new HashMap<>();
	    	newsFeed = new HashMap<>();
	    	tweets = new HashMap<>();
	    }
	    
	    /** Compose a new tweet. */
	    public void postTweet(int userId, int tweetId) {
	    	Tweet newTweet = new Tweet(System.currentTimeMillis(), tweetId);
	    	
	    	if (tweets.containsKey(userId)) {
	    		tweets.get(userId).add(newTweet);
	    	} else {
	    		List<Tweet> lst = new ArrayList<Tweet>();
	    		lst.add(newTweet);
	    		tweets.put(userId, lst);
	    	}
	    	
	        if (newsFeed.containsKey(userId)) {
	        	List<Tweet> que = newsFeed.get(userId);
	        	que.add(0, newTweet);
	        	if (que.size() > 10) {
	        		que.remove(que.size()-1);
	        	} 
	        } else {
	        	List<Tweet> que = new LinkedList<Tweet>();
	        	que.add(newTweet);
	        	newsFeed.put(userId, que);
	        }
	    }
	    
	    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	    public List<Integer> getNewsFeed(int userId) {
	        return (List)newsFeed.get(userId);
	    }
	    
	    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	    public void follow(int followerId, int followeeId) {
	        if (follow.containsKey(followerId)) {
	        	follow.get(followerId).add(followeeId);
	        } else {
	        	Set<Integer> followee = new HashSet<Integer>();
	        	followee.add(followeeId);
	        	follow.put(followerId, followee);
	        }
	    }
	    
	    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	    public void unfollow(int followerId, int followeeId) {
	        Set<Integer> followee = follow.get(followerId);
	        followee.remove(followeeId);
	        
	        List<Tweet> allTweet = new ArrayList<Tweet>();
	        for (int fId : followee) {
	        	allTweet.addAll(tweets.get(fId));
	        }

	        Collections.sort(allTweet);
	        
	        newsFeed.get(followerId).clear();
	        newsFeed.get(followerId).addAll(allTweet.subList(0, Math.min(allTweet.size(), 10)));
	    }
	}

}
