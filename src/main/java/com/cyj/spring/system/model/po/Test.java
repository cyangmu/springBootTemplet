package com.cyj.spring.system.model.po;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cyj
 * @since 2019-03-26
 */
public class Test extends Model<Test> {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Test{" +
        ", id=" + id +
        ", name=" + name +
        ", password=" + password +
        "}";
    }
}
