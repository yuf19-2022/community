package com.yuf19_2022.community.util;

import com.yuf19_2022.community.entity.User;
import org.springframework.stereotype.Component;

/**
 * 持有用户信息，代替Session对象
 */
@Component
public class HostHolder {

    private ThreadLocal<User> users=new ThreadLocal<>();

    public void setUser(User user){
        users.set(user);
    }

    public User getUser(){
        return users.get();
    }

    public void clear(){
        users.remove();
    }
}
