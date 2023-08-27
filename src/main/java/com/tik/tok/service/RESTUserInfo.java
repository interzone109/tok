package com.tik.tok.service;

import com.tik.tok.service.model.UserInfoModel;

import java.io.IOException;

public interface RESTUserInfo {

    UserInfoModel getUserInfo(String userName) throws IOException;

}
