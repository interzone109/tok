package com.tik.tok.controller.rest;

import com.tik.tok.service.RESTUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private RESTUserInfo restUserInfo;

    @GetMapping("/find/user")
    public ResponseEntity findUser(@RequestParam("userName") String userName) {
        try {
            userName = userName.startsWith("@")? userName: "@"+userName;
            return new ResponseEntity<>(restUserInfo.getUserInfo(userName), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Username '" + userName + "' not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/user/update")
    public ResponseEntity findUserSave(@RequestParam("userName") String userName) {
        try {
            userName = userName.startsWith("@")? userName: "@"+userName;
            var userInfoModel = restUserInfo.getUserInfo(userName);

            return new ResponseEntity<>(userInfoModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Username '" + userName + "' not found", HttpStatus.NOT_FOUND);
        }
    }
}
