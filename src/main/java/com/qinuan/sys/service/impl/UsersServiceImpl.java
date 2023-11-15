package com.qinuan.sys.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinuan.sys.entity.Users;
import com.qinuan.sys.mapper.UsersMapper;
import com.qinuan.sys.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qinuan
 * @since 2023-11-05
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Map<String, Object> login(Users user) {
        LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Users::getUsername, user.getUsername());
        wrapper.eq(Users::getPassword, user.getPassword());
        Users loginUser = this.baseMapper.selectOne(wrapper);

        if (loginUser != null) {
            String key = "user:" + UUID.randomUUID();

            loginUser.setPassword(null);
            redisTemplate.opsForValue().set(key, loginUser, 30, TimeUnit.MINUTES);

            Map<String, Object> data = new HashMap<>();
            data.put("token", key);
            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {
        Object obj = redisTemplate.opsForValue().get(token);
        if (obj != null) {
            Users loginUser = JSON.parseObject(JSON.toJSONString(obj), Users.class);
            Map<String, Object> data = new HashMap<>();
            data.put("name", loginUser.getUsername());
            data.put("role", loginUser.getRole());
            data.put("avatar", loginUser.getAvatar());
            return data;
        }
        return null;
    }


    @Override
    public void logout(String token) {
        redisTemplate.delete(token);
    }

    @Override
    public boolean register(Users user) {
        // 检查用户名是否已存在
        LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Users::getUsername, user.getUsername());
        Long count = this.baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            return false;
        }

        user.setAvatar("");
        user.setRole("user");
        // 插入新用户
        int result = this.baseMapper.insert(user);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void updateInfo(Users user) {
        LambdaUpdateWrapper<Users> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Users::getUsername, user.getUsername())
                .set(Users::getAvatar, user.getAvatar())
                .set(Users::getLocation, user.getLocation())
                .set(Users::getPassword, user.getPassword())
                .set(Users::getRegtime, user.getRegtime());
        this.baseMapper.update(null, updateWrapper);
    }

    @Override
    public void updateAvatar(String username, String filePath) {
        LambdaUpdateWrapper<Users> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Users::getUsername, username).set(Users::getAvatar, filePath);
        this.baseMapper.update(null, updateWrapper);
    }

    @Override
    public void delete(String username) {
        LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Users::getUsername, username);
        this.baseMapper.delete(queryWrapper);
    }

}