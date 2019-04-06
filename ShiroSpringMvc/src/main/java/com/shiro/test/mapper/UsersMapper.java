package com.shiro.test.mapper;

import com.shiro.test.pojo.Users;
import org.apache.ibatis.annotations.Param;

/**
 * Created by wang on 2019/3/24.
 */
public interface UsersMapper {
    Users getUserByEmail(@Param("email")String email);
}
