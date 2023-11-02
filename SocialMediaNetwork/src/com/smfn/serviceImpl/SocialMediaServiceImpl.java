package com.smfn.serviceImpl;

import com.smfn.model.User;
import com.smfn.service.ISocialMediaService;
import java.util.*;

public class SocialMediaServiceImpl implements ISocialMediaService {

    private Map<String, User> users;
    private Map<User, Set<User>> friendships;

    public SocialMediaServiceImpl() {
        users = new HashMap<>();
        friendships = new HashMap<>();
    }

    /**
     * adding users
     * @param username
     */
    @Override
    public void addUser(String username) {
        User user = new User(username);
        users.put(username, user);
        friendships.put(user, new HashSet<>());
    }

    /**
     * view existing users
     */
    @Override
    public void viewUser() {
        for (Map.Entry<String, User> entry : users.entrySet()) {
            String name = entry.getKey();
//          User users = entry.getValue();
            System.out.println(name);
        }
    }

    /**
     * add friend to specific user
     * @param username
     * @param friend
     * @return
     */
    @Override
    public boolean addFriend(String username, String friend) {
        if (users.containsKey(username) && users.containsKey(friend)) {
            User user = users.get(username);
            User friendUser = users.get(friend);

            if (!friendships.get(user).contains(friendUser)) {
                friendships.get(user).add(friendUser);
                friendships.get(friendUser).add(user);
                return true;
            }
        }
        return false;
    }

    /**
     * getting friends of user
     * @param username
     * @return
     */
    @Override
    public Set<String> getFriends(String username) {
        if (users.containsKey(username)) {
            Set<String> friends = new HashSet<>();
            User user = users.get(username);

            for (User friend : friendships.get(user)) {
                friends.add(friend.getUsername());
            }
            return friends;
        }
        System.out.println("Does not have any friend");
        return Collections.emptySet();
    }


    /**
     * removing friend of user
     * @param username
     * @param friend
     * @return
     */@Override
    public boolean removeFriend(String username, String friend) {
        if (users.containsKey(username) && users.containsKey(friend)) {
            User user = users.get(username);
            User friendUser = users.get(friend);

            if (friendships.get(user).contains(friendUser)) {
                friendships.get(user).remove(friendUser);
                friendships.get(friendUser).remove(user);
                return true;
            }
        }
        return false;
    }

    /**
     * checking two users are friends or not
      * @param username
     * @param friend
     * @return
     */
    @Override
    public boolean areFriends(String username, String friend) {
        if (users.containsKey(username) && users.containsKey(friend)) {
            User user = users.get(username);
            User friendUser = users.get(friend);
            return friendships.get(user).contains(friendUser);
        }
        return false;
    }

    /**
     * getting mutual friends of two users
     * @param username
     * @param friend
     * @return
     */
    /**
     * Getting mutual friends
     * @param username
     * @param friend
     * @return
     */
    @Override
    public Set<String> getMutualFriends(String username, String friend) {
        if (users.containsKey(username) && users.containsKey(friend)) {
            User user = users.get(username);
            User friendUser = users.get(friend);

            Set<User> mutualFriendSet = new HashSet<>(friendships.get(user));
            mutualFriendSet.retainAll(friendships.get(friendUser));

            Set<String> mutualFriends = new HashSet<>();
            for (User mutualFriend : mutualFriendSet) {
                mutualFriends.add(mutualFriend.getUsername());
            }
            return mutualFriends;
        }
        return Collections.emptySet();
    }
}
