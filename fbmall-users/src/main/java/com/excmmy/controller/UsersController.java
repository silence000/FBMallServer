package com.excmmy.controller;


import com.excmmy.bean.Users;
import com.excmmy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pojo.RequestJsonBody;
import pojo.ResponseJsonBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-19
 */
@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/user/hello", method = RequestMethod.GET)
    public String welcome() {
        System.out.println("成功访问到了FBMall-UsersServer后台");
        return "hello to FBMall-UsersServer";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResponseJsonBody getUserByUsernameAndUserpass(@RequestBody RequestJsonBody requestJsonBody) {
        return usersService.getUserByUsernameAndUserpass(requestJsonBody);
    }

    @RequestMapping(value = "/user/insert", method = RequestMethod.POST)
    public ResponseJsonBody insertUser(@RequestBody Users users) {
        return usersService.insertUser(users);
    }
}

