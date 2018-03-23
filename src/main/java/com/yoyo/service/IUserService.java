package com.yoyo.service;

import com.yoyo.model.SysUser;

import java.util.List;

/**
 * 用户业务类
 *
 * Created by fbin on 2018/3/23.
 */
public interface IUserService {

    List<SysUser> findAll();

}
