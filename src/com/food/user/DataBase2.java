package com.food.user;

import java.util.ArrayList;

public class DataBase2 {
    private static ArrayList<User> usersData = new ArrayList<>();

    public static ArrayList<User> getDB() {
        return usersData;
    }
    public static void clearDB() {
        usersData.clear();
    }
    public static User getUser(int userId) {
        return usersData.get(userId);
    }
    public static void addUser(User newUser) {
        usersData.add(newUser);
    }
    public static int getLength(){
        return usersData.size();
    }
}
