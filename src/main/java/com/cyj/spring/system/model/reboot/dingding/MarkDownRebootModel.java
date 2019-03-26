package com.cyj.spring.system.model.reboot.dingding;

import lombok.Data;

/**
 * Created by cyj
 * on 2018/8/30.
 */
@Data
public class MarkDownRebootModel {
    /**
     * 此消息类型为固定markdown
     */
    public String msgtype = "markdown";

    public MarkDownModel markdown;

    public AtMobiles at;
}
