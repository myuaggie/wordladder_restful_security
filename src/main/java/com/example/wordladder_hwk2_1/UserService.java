package com.example.wordladder_hwk2_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserDAO userDAO;
    public UserInfo getDataByUserName(String userName) {
        return userDAO.getActiveUser(userName);
    }
}