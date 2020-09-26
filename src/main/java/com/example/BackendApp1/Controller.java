package com.example.BackendApp1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    DB db = new DB();

    @GetMapping("/hi")
    public String sayHello() {
        return "Hello Coder!! My First API";
    }

    @GetMapping("/convert")
    public int convertToInr(@RequestParam int q) {
        int usd = q;
        return 74*usd;
    }

    @GetMapping("/search")
    public String serchAWord(@RequestParam String q) {

        return db.search(q);
    }

    @GetMapping("/searchUser")
    public User searchAUser(@RequestParam String name) {
        System.out.println("Inside the Search User Query Param method " + name);
        return db.searchAUser(name);
    }

    @GetMapping("/searchUserPathVariable/{name}")
    public User searchUser(@PathVariable String name) {
        System.out.println("Inside the Search User Path Variable method " + name);
        return db.searchAUser(name);
    }
}
