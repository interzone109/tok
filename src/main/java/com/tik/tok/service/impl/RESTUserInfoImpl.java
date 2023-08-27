package com.tik.tok.service.impl;

import com.tik.tok.jpa.entity.UserInfoEntity;
import com.tik.tok.jpa.services.UserInfoRepository;
import com.tik.tok.service.RESTUserInfo;
import com.tik.tok.service.model.UserInfoModel;
import jakarta.transaction.Transactional;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;

@Service
@Transactional
public class RESTUserInfoImpl implements RESTUserInfo {

    //@Value("{tik.tok}")
    private String URL = "https://www.tiktok.com/";
    @Autowired
    private UserInfoRepository userInfoRepository;


    public UserInfoModel getUserInfo(String userName) throws IOException {
        UserInfoModel userInfoModel = new UserInfoModel();

        Document doc = Jsoup.connect(URL + userName).get();
        String countSubscribers = doc.selectXpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/h3/div[1]/strong").get(0).text();
        String countFollowers = doc.selectXpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/h3/div[2]/strong").get(0).text();
        String img = doc.selectXpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/span/img").get(0).attr("src");

        userInfoModel.setImg(img);
        userInfoModel.setUserName(userName);
        userInfoModel.setFollowers(Integer.parseInt(countFollowers));
        userInfoModel.setSubscribers(Integer.parseInt(countSubscribers));

        saveUser(userInfoModel);

        return userInfoModel;
    }

    private void saveUser(UserInfoModel userInfoModel){
        var userOptional = userInfoRepository.findByUserName(userInfoModel.getUserName());
        UserInfoEntity userEntity = userOptional.orElseGet(UserInfoEntity::new);

        userEntity.setFollowers(userInfoModel.getFollowers());
        userEntity.setSubscribers(userInfoModel.getSubscribers());
        userEntity.setOnlineStatus(true);
        userEntity.setLastActivityDate(LocalDate.now());
        if (userOptional.isPresent()) {
            userEntity.setRegistrationDate(LocalDate.now());
        }
    }


}
