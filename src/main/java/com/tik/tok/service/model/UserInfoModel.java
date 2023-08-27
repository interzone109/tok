package com.tik.tok.service.model;


import lombok.Data;

@Data
public class UserInfoModel {
    private Integer subscribers;

    private Integer followers;

    private String userName;

    private String img;

}
