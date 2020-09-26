package com.example.BackendApp1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DB {

    HashMap<String,String> storage = new HashMap<>();
    ArrayList<User> list = new ArrayList<>();
    User user = new User();

    public DB() {
        storage.put("sachin", "Great Cricketer");
        storage.put("dravid", "Great Player");
        user.setId(1);
        user.setName("Manish");
        list.add(user);
    }

    public String search(String word) {
        if(storage.containsKey(word)) {
            return storage.get(word);
        }
        return word + " not Found";
    }

    public User searchAUser(String name) {
        System.out.println("List : " + name);
        for(User l : list) {
            if(l.getName().equalsIgnoreCase(name)) {
                return l;
            }
        }
        return new User();

    }
}
