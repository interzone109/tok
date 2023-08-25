package com.tik.tok.service;

import com.tik.tok.model.UserInfoModel;

import java.io.IOException;

public interface UserInfo {

    UserInfoModel getUserInfo(String userName) throws IOException;

}
