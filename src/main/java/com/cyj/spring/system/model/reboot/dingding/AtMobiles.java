package com.cyj.spring.system.model.reboot.dingding;

import lombok.Data;

import java.util.List;

/**
 * @author：hpf
 * @date：2017/12/26 下午1:08
 * @describe：@ 人员模板
 */
@Data
public class AtMobiles {

    /**
     * 集合里面保存的是电话号码
     *
     * @return
     */
    private List<String> atMobiles;

    /**
     * 是否要 @所有人
     */
    private Boolean isAtAll;
}
