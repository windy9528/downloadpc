package com.yanggaofeng20190713.entity;

/**
 * date:2019/7/13
 * name:windy
 * function:
 */
public class UserInfo {

    private String userId;
    private String sessionId;
    private String phone;  //sp存储电话号码
    private String headPic;

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
