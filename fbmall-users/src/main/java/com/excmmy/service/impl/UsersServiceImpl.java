package com.excmmy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

import java.util.UUID;

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

    @Override
    public ResponseJsonBody insertUser(Users users) {
        ResponseJsonBody responseJsonBody = new ResponseJsonBody();
        QueryWrapper<Users> usersQueryWrapper = new QueryWrapper<>();
        usersQueryWrapper.eq("username", users.getUsername());
        Users usersName = usersMapper.selectOne(usersQueryWrapper);
        if (usersName != null) {
            responseJsonBody.setCode(MallConstant.FAIL_CODE_NAME_CONFLICT );
            responseJsonBody.setMsg(MallConstant.REGISTER_FALL_NAME_CONFLICT);
            return responseJsonBody;
        }
        users.setSeries(UUID.randomUUID().toString());
        int flag = usersMapper.insert(users);
        if (flag == 1) {
            responseJsonBody.setCode(MallConstant.SUCCESS_CODE);
            responseJsonBody.setMsg(MallConstant.REGISTER_SUCCESS);
        } else {
            responseJsonBody.setCode(MallConstant.FAIL_CODE);
            responseJsonBody.setMsg(MallConstant.FAIL_DESC);
        }
        return responseJsonBody;
    }
}
