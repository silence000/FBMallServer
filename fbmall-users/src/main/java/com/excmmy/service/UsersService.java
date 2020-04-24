package com.excmmy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.excmmy.bean.Users;
import pojo.RequestJsonBody;
import pojo.ResponseJsonBody;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-19
 */
public interface UsersService extends IService<Users> {
    public ResponseJsonBody getUserByUsernameAndUserpass(RequestJsonBody requestJsonBody);
    public ResponseJsonBody insertUser(Users users);
}
