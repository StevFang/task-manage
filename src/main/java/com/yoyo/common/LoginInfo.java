package com.yoyo.common;

/**
 * 登录信息
 *
 * Created by fbin on 2018/3/23.
 */
public class LoginInfo {

    // 账号
    private String account;

    // 密码
    private String password;

    // 验证码
    private String validCode;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidCode() {
        return validCode;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }

}
