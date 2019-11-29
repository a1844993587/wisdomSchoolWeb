package com.wxiaoy.service;

import com.wxiaoy.pojo.User;

import java.util.List;

/**
 * @author Alex Yu
 * @date 2019/11/29 15:42
 */
public interface UserService {

    Boolean checkAccount(String account);

    Boolean reg(User user);

    User login(User user);

    User updateUserInfo(String id, User user);

    boolean updateUserPassword(String userId, String oldPssword, String newPassword);

    List<User> findAllUser();
}
