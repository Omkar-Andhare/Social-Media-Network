package com.smfn.app;

import com.smfn.service.ISocialMediaService;
import com.smfn.serviceImpl.SocialMediaServiceImpl;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ISocialMediaService socialMediaService = new SocialMediaServiceImpl();

        socialMediaService.addUser("omkar");
        socialMediaService.addUser("shubham");
        socialMediaService.addUser("nikhil");
        socialMediaService.addUser("dhanashree");
        socialMediaService.addUser("akshay");
        socialMediaService.addUser("kuldeep");
        socialMediaService.addUser("vaibhav");
        socialMediaService.addUser("vicky");
        socialMediaService.addUser("tushar");
        socialMediaService.addUser("tushar");

        socialMediaService.viewUser();


        socialMediaService.addFriend("omkar", "shubham");
        socialMediaService.addFriend("omkar", "dhanashree");
        socialMediaService.addFriend("nikhil", "dhanashree");
        socialMediaService.addFriend("nikhil", "kuldeep");

        socialMediaService.addFriend("tushar", "akshay");

        System.out.println("---------------------------------------");

        Set<String> fr = socialMediaService.getFriends("nikhil");
        System.out.println(fr);

        System.out.println("---------------------------------------------");
        socialMediaService.removeFriend("nikhil", "dhanashree");
        fr = socialMediaService.getFriends("vicky");
        System.out.println(fr);
        System.out.println("------------------------------------------");
        boolean isFriends = socialMediaService.areFriends("tushar", "akshay");
        System.out.println(isFriends);


    }
}
