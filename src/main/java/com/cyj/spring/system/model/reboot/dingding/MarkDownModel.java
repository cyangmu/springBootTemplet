package com.cyj.spring.system.model.reboot.dingding;

import lombok.Data;

/**
 * Created by cyj
 * on 2018/8/30.
 */
@Data
public class MarkDownModel {
    /**
     * 首屏会话透出的展示内容
     */
    private String title;

    /**
     * markdown格式的消息
     */
    private String text;
}
