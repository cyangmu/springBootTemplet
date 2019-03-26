package com.cyj.spring.system.model.reboot.dingding;

/**
 * @author：hpf
 * @date：2017/12/26 下午12:53
 * @describe：钉钉机器人枚举
 */
public enum RebootEnum {

    SBK_WX_REBOOT("https://oapi.dingtalk.com/robot/send?access_token=4a32898b7c65279fd037af67c81ad624d630b47b9da11439167fe53f09b250db", "微信平台通知机器人"),

    SBK_ERROR_REBOOT("https://oapi.dingtalk.com/robot/send?access_token=09a97dfcbe9844bccee05075a62d00db872c2da00ce718452ccaf3015a1b8605", "查错机器人"),

    SBK_APP("https://oapi.dingtalk.com/robot/send?access_token=dda3457dc3dc7172307978bfa14953a1af1ee6f265175fdcd90cc82417cade5a", "APP数据机器人");

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
