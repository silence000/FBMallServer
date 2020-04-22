package com.excmmy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.excmmy.bean.Users;
import com.excmmy.mapper.UsersMapper;
import com.excmmy.pojo.UserList;
import com.excmmy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.MallConstant;
import pojo.RequestJsonBody;
import pojo.ResponseJsonBody;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-19
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public ResponseJsonBody getUserByUsernameAndUserpass(RequestJsonBody requestJsonBody) {
        ResponseJsonBody responseJsonBody = new ResponseJsonBody();
        UserList userList = usersMapper.getUserByUsernameAndUserpass(requestJsonBody.getData() + "", requestJsonBody.getExtra() + "");
        if (userList != null) {
            userList.setUserpass(null);
            responseJsonBody.setCode(MallConstant.SUCCESS_CODE);
            responseJsonBody.setMsg(MallConstant.SUCCESS_DESC);
            responseJsonBody.setData(userList);
        } else {
            responseJsonBody.setCode(MallConstant.FAIL_CODE);
            responseJsonBody.setMsg(MallConstant.FAIL_DESC);
        }
        return responseJsonBody;
    }
}
