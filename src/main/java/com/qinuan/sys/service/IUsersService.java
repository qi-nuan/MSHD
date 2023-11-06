package com.qinuan.sys.service;

import com.qinuan.sys.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qinuan
 * @since 2023-11-06
 */
public interface IUsersService extends IService<Users> {

    Map<String, Object> login(Users user);

    Map<String, Object> getUserInfo(String token);

    void logout(String token);
}
