package com.food.user;
import java.util.*;

public class IDandPassword {
    HashMap<String,String> logininfo = new HashMap<String,String>();
	
	IDandPassword(){
		
		logininfo.put("Emran","12345");
		logininfo.put("Ammar","12345");
		logininfo.put("Muhammed","12345");
	}
	
	protected HashMap<String, String> getLoginInfo(){
		return logininfo;
	}
}
