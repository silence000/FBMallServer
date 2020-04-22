package com.excmmy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.excmmy.bean.Users;
import com.excmmy.pojo.UserList;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Excmmy
 * @since 2020-04-19
 */
@Repository
public interface UsersMapper extends BaseMapper<Users> {
    @Select("SELECT * FROM user_list WHERE username = #{username} AND userpass = #{userpass}")
    public UserList getUserByUsernameAndUserpass(@Param("username") String username, @Param("userpass") String userpass);
}
