package com.qinuan.sys.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author qinuan
 * @since 2023-11-06
 */
public class Provinces implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Provinces{" +
            "code = " + code +
            ", name = " + name +
        "}";
    }
}
