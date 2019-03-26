package com.cyj.spring.system.model.wechat;

/**
 * Created by cyj
 * on 2018/8/9.
 */
public enum WxinfoEnum {
    /**
     * 商家APPID
     */
    APPID("XXXXXXXXXXXX", "提供给微信的appid"),
    /**
     * 商家key
     */
    SECRET("XXXXXXXXXXXX", "提供给用户的key"),


    TEMPLATEID("XXXXXXXXXXXXXXXXXXXXXXXX", "模板ID");

    private String key;

    /**
     * 描述
     */
    private String des;

    /**
     * 构造函数
     *
     * @param key
     * @param des
     */
    WxinfoEnum(String key, String des) {
        this.key = key;
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public String getKey() {
        return key;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 重写toString()
     *
     * @return
     */
    @Override
    public String toString() {
        return getKey();
    }
}
