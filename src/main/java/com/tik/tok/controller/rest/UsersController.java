package com.tik.tok.controller.rest;

import com.tik.tok.service.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/rest")
public class UsersController {

    @Autowired
    private UserInfo userInfo;

    @GetMapping("/find/user")
    public ResponseEntity findUser(@RequestParam("userName") String userName) {
        try {
            return new ResponseEntity<>(userInfo.getUserInfo(userName), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Username '" + userName + "' not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/user/save")
    public ResponseEntity findUserSave(@RequestParam("userName") String userName) {
        try {
            var userInfoModel = userInfo.getUserInfo(userName);

            return new ResponseEntity<>(userInfoModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Username '" + userName + "' not found", HttpStatus.NOT_FOUND);
        }
    }
}
