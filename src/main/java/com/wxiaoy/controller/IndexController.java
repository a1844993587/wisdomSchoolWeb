package com.wxiaoy.controller;

import com.wxiaoy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Alex Yu
 * @date 2019/11/29 14:48
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/tologin")
    public String toLogin() {
        return "/user/login";
    }

    @GetMapping("/toreg")
    public String toReg() {
        return "/user/reg";
    }

    @GetMapping("/home/console")
    public String console() {
        return "/home/console";
    }

    @GetMapping("/touserinfo")
    public String toUserInfo() {
        return "/set/user/info";
    }

    @GetMapping("/touserpassword")
    public String toUserPassword() {
        return "/set/user/password";
    }

    @GetMapping("/toenvironment")
    public String toEnvironment() {
        return "/app/environment/environment";
    }

    @GetMapping("/toweather")
    public String toWeather() {
        return "/app/weather/weather";
    }

    @GetMapping("/tocodelist")
    public String toCodelist() {
        return "/app/code/codelist";
    }

    @GetMapping("/toadminlist")
    public String toAdminList(HttpServletRequest request) {
        request.setAttribute("userList", userService.findAllUser());
        return "/user/administrators/list";
    }

    @GetMapping("/torole")
    public String toRole() {
        return "/user/administrators/role";
    }

    @GetMapping("/tovideolist")
    public String toVideoList() {
        return "/app/video/videolist";
    }
}
