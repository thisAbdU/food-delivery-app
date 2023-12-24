package com.food.user;

public class Main {
    public static void main(String[] args){
        IDandPassword idandpassword = new IDandPassword();
        LoginPage loginpage = new LoginPage(idandpassword.getLoginInfo());
        System.out.println(DataBase2.getLength());
    }
}