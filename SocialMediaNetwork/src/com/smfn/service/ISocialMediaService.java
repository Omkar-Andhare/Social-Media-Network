package com.smfn.service;

import java.util.Set;

public interface ISocialMediaService {

    void addUser(String username);

    void viewUser();

    boolean addFriend(String username, String friend);

    Set<String> getFriends(String username);

    boolean removeFriend(String username, String friend);

    boolean areFriends(String user, String friend);

    Set<String> getMutualFriends(String user1, String user2);
}
