package com.yweiai.bean;

/**
 * 用户登录接口返回结果
 * @author wj
 */
public class LoginResponse extends BaseBean{
    private String token;
    private String user_id;

    public LoginResponse(String token, String user_id) {
        this.token = token;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "token='" + token + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public LoginResponse() {

    }
}
