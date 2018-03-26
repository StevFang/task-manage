package com.yoyo.utils;

/**
 * 转换工具类
 * Created by fbin on 2018/3/25.
 */
public class ConvertUtil {

    public static int getInt(Object obj){
        if(obj == null){
            return 0;
        }
        try{
            return Integer.parseInt(obj.toString());
        }catch (Exception e){
            return 0;
        }
    }

}
