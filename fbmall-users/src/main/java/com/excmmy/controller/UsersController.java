package com.excmmy.controller;


import com.excmmy.bean.Users;
import com.excmmy.service.UsersService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pojo.MallConstant;
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

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod = "getUserByUsernameAndUserpassBackup")
    public ResponseJsonBody getUserByUsernameAndUserpass(@RequestBody RequestJsonBody requestJsonBody) {
        return usersService.getUserByUsernameAndUserpass(requestJsonBody);
    }

    public ResponseJsonBody getUserByUsernameAndUserpassBackup(@RequestBody RequestJsonBody requestJsonBody) {
        ResponseJsonBody responseJsonBody = new ResponseJsonBody();
        responseJsonBody.setCode(MallConstant.FAIL_CODE_REQUEST_TIMEOUT);
        responseJsonBody.setMsg(MallConstant.FAIL_CODE_REQUEST_TIMEOUT_STRING);
        return responseJsonBody;
    }

    @RequestMapping(value = "/user/insert", method = RequestMethod.POST)
    public ResponseJsonBody insertUser(@RequestBody Users users) {
        return usersService.insertUser(users);
    }
}

