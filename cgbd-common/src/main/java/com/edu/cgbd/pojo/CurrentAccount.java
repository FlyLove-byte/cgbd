package com.edu.cgbd.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class CurrentAccount implements Serializable {

    //Account
    Long accountId;
    String accountName;
    String password;
    Date loginOn;
    String loginIp;
    String loginHost;
    Long loginSysId;
    Date logoutOn;
    int attemptCount;

    //User
    Long userId;
    String userName;
    String userType;
    int status;
}
