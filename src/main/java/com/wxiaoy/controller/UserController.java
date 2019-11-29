package com.wxiaoy.controller;

import com.wxiaoy.pojo.User;
import com.wxiaoy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex Yu
 * @date 2019/11/29 14:25
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(User user, HttpServletRequest request) {
        User userLogin = userService.login(user);
        if (userLogin == null) {
            request.setAttribute("msg", "账号或者密码错误!");
            return "/user/login";
        }
        request.getSession().setAttribute("user", userLogin);
        return "redirect:/";
    }

    @ResponseBody
    @GetMapping("/checkaccount")
    public boolean checkAccount(String account) {
        return userService.checkAccount(account);
    }

    @PostMapping("/reg")
    public String reg(User user, HttpServletRequest request) {
        Boolean flag = userService.reg(user);
        if (flag) {
            request.setAttribute("msg", "账号已经存在 请您重新注册!");
            return "/user/reg";
        }
        return "redirect:/tologin";
    }

    @ResponseBody
    @PostMapping("/updateUserInfo")
    public boolean updateUserInfo(User user, HttpServletRequest request) {
        User userInfo = (User) request.getSession().getAttribute("user");
        User user1 = userService.updateUserInfo(userInfo.getId(), user);
        request.getSession().setAttribute("user", user1);
        return true;
    }

    @ResponseBody
    @PostMapping("/updateUserPassword")
    public Map<String, String> updateUserPassword(String oldPassword, String newPassword, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String userId = user.getId();
        boolean flag = userService.updateUserPassword(userId, oldPassword, newPassword);
        Map<String, String> map = new HashMap<>();
        if (!flag) {
            map.put("code", "400");
            map.put("msg", "原来的密码不正确");
            return map;
        }
        map.put("code", "200");
        map.put("msg", "密码修改成功");
        return map;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "redirect:/tologin";
    }

}
