package com.tik.tok.service.impl;

import com.tik.tok.model.UserInfoModel;
import com.tik.tok.service.UserInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserInfoImpl implements UserInfo {

    @Value("{tik.tok}")
    private String URL;

    public UserInfoModel getUserInfo(String userName) throws IOException {
        UserInfoModel userInfoModel = new UserInfoModel();

        Document doc = Jsoup.connect(URL + userName).get();
        String countSubscribers = doc.selectXpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/h3/div[1]/strong").get(0).text();
        String countFollowers = doc.selectXpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/h3/div[2]/strong").get(0).text();

        userInfoModel.setUserName(userName);
        userInfoModel.setFollowers( Integer.parseInt(countFollowers));
        userInfoModel.setSubscribers(Integer.parseInt(countSubscribers));
        return userInfoModel;
    }

}
