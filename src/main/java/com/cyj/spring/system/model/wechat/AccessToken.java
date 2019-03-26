package com.cyj.spring.system.model.wechat;

import lombok.Data;

/**
 * Created by cyj
 * on 2018/8/9.
 *
 * @author cyj
 */
@Data
public class AccessToken {
    private String token;

    private int expiresIn;

    @Override
    public String toString() {
        return "AccessToken [token=" + token + ", expiresIn=" + expiresIn + "]";
    }
}
