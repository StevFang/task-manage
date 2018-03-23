package com.yoyo.dao;

import com.yoyo.model.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fbin on 2018/3/23.
 */
@Repository("sysUserMapper")
public interface SysUserMapper {

    List<SysUser> findAll();

}
