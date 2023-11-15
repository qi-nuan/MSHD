package com.qinuan.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qinuan.sys.entity.Users;

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

    boolean register(Users user);

    void updateInfo(Users user);

    void updateAvatar(String username, String filePath);

    void delete(String username);
}
