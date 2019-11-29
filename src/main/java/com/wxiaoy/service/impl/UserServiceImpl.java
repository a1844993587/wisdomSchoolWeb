package com.wxiaoy.service.impl;

import com.wxiaoy.dao.UserRepository;
import com.wxiaoy.pojo.User;
import com.wxiaoy.service.UserService;
import com.wxiaoy.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Alex Yu
 * @date 2019/11/29 15:43
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean checkAccount(String account) {
        return userRepository.findByAccount(account) != null;
    }

    @Override
    public Boolean reg(User user) {
        User flag = userRepository.findByAccount(user.getAccount());
        if (flag != null) {
            return true;
        }
        user.setLevel(0);
        user.setPassword(MD5Utils.MD5(user.getPassword()));
        userRepository.save(user);
        return false;
    }

    @Override
    public User login(User user) {
        User userLogin = userRepository.findByAccount(user.getAccount());
        if (userLogin == null) {
            return null;
        }
        if (!userLogin.getPassword().equals(MD5Utils.MD5(user.getPassword()))) {
            return null;
        }
        userLogin.setPassword(null);
        return userLogin;
    }

    @Override
    public User updateUserInfo(String id, User user) {
        Optional<User> byId = userRepository.findById(id);
        if (!byId.isPresent()) {
            return null;
        }
        User userOptional = byId.get();
        userOptional.setName(user.getName());
        userRepository.save(userOptional);
        userOptional.setPassword(null);
        return userOptional;
    }

    @Override
    public boolean updateUserPassword(String userId, String oldPssword, String newPassword) {
        Optional<User> byId = userRepository.findById(userId);
        if (!byId.isPresent()) {
            return false;
        }
        User user = byId.get();
        if (!user.getPassword().equals(MD5Utils.MD5(oldPssword))) {
            return false;
        }
        user.setPassword(MD5Utils.MD5(newPassword));
        userRepository.save(user);
        return true;
    }

    @Override
    public List<User> findAllUser() {
        List<User> all = userRepository.findAll();
        return all;
    }

}
