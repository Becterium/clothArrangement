package com.hehe.boot.controller;

import com.hehe.boot.Utils.UploadUtils;
import com.hehe.boot.pojo.Result;
import com.hehe.boot.pojo.User;
import com.hehe.boot.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findbyname")
    public Result<User> findByName(@RequestParam(required = false) String query,
                                   @RequestParam String username){
        if (query != null && !query.isEmpty()) {
            // 如果提供了查询参数，执行模糊查询userService.findUsersByName(query)
            return Result.success(userService.findUsersByName(username));
        }
        return Result.error("null query");
    }

    @PostMapping("/register")
    public Result<Boolean> register(@RequestBody User user) {
        boolean isRegistered = userService.registerUser(user);
        if (isRegistered) {
            return Result.success(true);
        } else {
            return Result.error("User registration failed");
        }
    }

    @PostMapping("/login")
    public Result<Boolean> login(@RequestBody User user) {
        String username = user.getUsername();
        User film = userService.findUsersByName(username);
        if (film != null && film.getPassword().equals(user.getPassword())){
            System.out.println("handler login");
            return Result.success(true);
        }else {
            return Result.error("fail to login");
        }
    }

    private static String UPLOAD_DIR = "/path/to/your/frontend/project/src/img";

    @PostMapping("/upload")
    public JSONObject upImg(@RequestParam("file") MultipartFile file) throws IOException {
        String name = "fileName";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(name,UploadUtils.uploadImage(file));
        return jsonObject;
    }
}
