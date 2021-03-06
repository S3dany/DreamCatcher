package com.tosp.dreamcatcher;

import java.util.ArrayList;

public class User {

    private String name;
    private String email;
    private String id;
    private ArrayList<User> friends;
    private ArrayList<FriendRequest> sentRequests;
    private ArrayList<FriendRequest> receivedRequests;

    public User(String name, String email, String id, ArrayList<User> friends, ArrayList<FriendRequest> sentRequests, ArrayList<FriendRequest> receivedRequests) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.friends = friends;
        this.sentRequests = sentRequests;
        this.receivedRequests = receivedRequests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<User> getFriends() {
        return this.friends;
    }


    public ArrayList<FriendRequest> getSentRequests() {
        return sentRequests;
    }

    public void setSentRequests(ArrayList<FriendRequest> sentRequests) {
        this.sentRequests = sentRequests;
    }

    public ArrayList<FriendRequest> getReceivedRequests() {
        return receivedRequests;
    }

    public void setReceivedRequests(ArrayList<FriendRequest> receivedRequests) {
        this.receivedRequests = receivedRequests;
    }


    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }


    public void addFriend(User other){
        this.friends.add(other);

    }


    public FriendRequest send_friend_request(User other){
        FriendRequest request=new FriendRequest(this, other);
        this.sentRequests.add(request);
        other.receivedRequests.add(request);
        return request;
    }

    public void accept_friend_request(FriendRequest request){
        request.setStatus("accepted");
        this.sentRequests.remove(request);
        request.getTo().receivedRequests.remove(request);
        this.addFriend(request.getTo());
        request.getTo().addFriend(this);
    }

    public void decline_friend_request(FriendRequest request){
        request.setStatus("declined");
        this.sentRequests.remove(request);
        request.getTo().receivedRequests.remove(request);
    }
}
