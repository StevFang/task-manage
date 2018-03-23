package com.yoyo.common;

/**
 * 系统统一码信息
 *
 * Created by fbin on 2018/3/23.
 */
public enum SysEnum {

    LOGIN_SUCCESS("0000", "登录成功!"),
    LOGIN_FAILED("1000", "登录失败，账号或密码错误!"),
    VALID_FAILED("1001", "验证码校验失败!"),
    SYS_ERROR("9999", "系统错误，请联系管理员!");

    SysEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
