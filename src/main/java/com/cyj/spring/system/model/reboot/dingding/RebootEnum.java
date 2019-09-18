package com.cyj.spring.system.model.reboot.dingding;

/**
 * @author：hpf
 * @date：2017/12/26 下午12:53
 * @describe：钉钉机器人枚举
 */
public enum RebootEnum {

    SBK_WX_REBOOT("webhook", "通知机器人");


    private String key;

    private String des;

    RebootEnum(String key, String des) {
        this.key = key;
        this.des = des;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return getKey();
    }
}
