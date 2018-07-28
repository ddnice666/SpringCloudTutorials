

package com.yq.controller;

import com.yq.domain.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    private Map<String, User> userMap = new HashMap<>();
    {
        for(int i=0;i < 5; i++) {
            User user = new User();
            user.setId(i + "");
            user.setMail("qq" + i + "@163.com");
            user.setName("Tom" + i );
            user.setRegDate(new Date());
            userMap.put(i+ "",user );
        }

    }

    @GetMapping(value = "/users/{userId}", produces = "application/json;charset=UTF-8")
    public User getUser(@PathVariable String userId) {
        User user = (User)userMap.get(userId);
        return user;
    }

    @GetMapping(value = "/users", produces = "application/json;charset=UTF-8")
    public Iterable<User> findAllUsers() {
        Collection<User> users = userMap.values();
        return users;
    }
}