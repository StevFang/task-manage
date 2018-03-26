package com.yoyo.common;

import com.yoyo.model.SysUser;

/**
 * 返回结果信息
 *
 * Created by fbin on 2018/3/23.
 */
public class RespInfo {

    private String code;

    private String msg;

    private String json;

    public RespInfo(){

    }

    public RespInfo(SysEnum sysEnum){
        this(sysEnum, null);
    }

    public RespInfo(SysEnum sysEnum, String json){
        this.setCode(sysEnum.getCode());
        this.setMsg(sysEnum.getMsg());
        this.json = json;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    /**
     * @param sysEnum
     */
    public RespInfo setBySysEnum(SysEnum sysEnum){
        this.setCode(sysEnum.getCode());
        this.setMsg(sysEnum.getMsg());
        return this;
    }
}
