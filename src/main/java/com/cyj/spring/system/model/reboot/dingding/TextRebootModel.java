package com.cyj.spring.system.model.reboot.dingding;

import lombok.Data;

/**
 * @author：hpf
 * @date：2017/12/26 下午1:02
 * @describe：机器人text模板
 */
@Data
public class TextRebootModel {
    /**
     * 此消息类型为固定text
     */
    public String msgtype = "text";

    public ContentModel text;

    public AtMobiles at;
}
