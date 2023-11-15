package com.qinuan.sys.controller;

import com.qinuan.common.vo.Result;
import com.qinuan.sys.entity.Users;
import com.qinuan.sys.service.IUsersService;
import com.qinuan.sys.service.impl.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @Autowired
    private FileStorageService fileStorageService;



    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody Users user){
        Map<String,Object> data =  usersService.login(user);
        if(data != null){
            return Result.success(data);
        }
        return Result.fail("用户名或密码错误");
    }

    @PostMapping("/register")
    public Result<Map<String,Object>> register(@RequestBody Users user){
        boolean flag = usersService.register(user);
        if(flag){
            return Result.success("注册成功");
        }
        return Result.fail("注册失败");
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


    @PostMapping("/updateAvatar")
    public ResponseEntity<String> uploadAvatar(@RequestParam("file") MultipartFile file,@RequestParam("username") String username, @RequestParam("avatar") String avatar) {
        try {
            String filePath = fileStorageService.uploadFile(file, username, avatar);
            usersService.updateAvatar(username, filePath);
            // 此处应更新用户模型中的avatarUrl，然后保存到数据库
            return ResponseEntity.ok(filePath);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @PostMapping("/updateInfo")
    public Result updateInfo(@RequestBody Users user){
        usersService.updateInfo(user);
        return Result.success("修改成功");
    }

    @PostMapping("/deleteUser")
    public Result deleteUser(@RequestParam("username") String username){
        usersService.delete(username);
        return Result.success("删除成功");
    }



}