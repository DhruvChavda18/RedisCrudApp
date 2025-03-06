package com.example.Redis.conroller;

import com.example.Redis.dao.UserDao;
import com.example.Redis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class userController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/post")
    public User createUser(@RequestBody User user){
      user.setUserId(UUID.randomUUID().toString());
      return userDao.save(user);
    }

    //get single user
    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId){
        return userDao.get(userId);
    }

    //find all
    @GetMapping("/all")
    public Map<Object, Object> getAll(){
        return userDao.findAll();
    }

    //delete
    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable("userId") String userId){
          userDao.delete(userId);
    }

}
