package com.example.wordladder_hwk2_1;
import org.springframework.security.access.annotation.Secured;

public interface IUserService {
    @Secured ({"ROLE_ADMIN"})
    UserInfo getDataByUserName(String userName);
}