package com.qinuan.sys.controller;

import com.qinuan.common.vo.Result;
import com.qinuan.sys.entity.Users;
import com.qinuan.sys.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qinuan
 * @since 2023-11-05
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UsersController {
    @Autowired
    private IUsersService usersService;

    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody Users user){
        Map<String,Object> data =  usersService.login(user);
        if(data != null){
            return Result.success(data);
        }
        return Result.fail("用户名或密码错误");
    }

    @GetMapping("/info")
    public Result<Map<String,Object>> getUserInfo(@RequestParam("token") String token){
        Map<String,Object> data = usersService.getUserInfo(token);
        if(data != null){
            return Result.success(data);
        }
        return Result.fail("登录无效，请重新登录");
    }

    @PostMapping("/logout")
    public Result logout(@RequestHeader("X-Token") String token){
        usersService.logout(token);
        return Result.success("退出成功");
    }
}