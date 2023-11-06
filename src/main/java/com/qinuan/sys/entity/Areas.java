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
public class Areas implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String name;

    private String cityCode;

    private String provinceCode;

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

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    @Override
    public String toString() {
        return "Areas{" +
            "code = " + code +
            ", name = " + name +
            ", cityCode = " + cityCode +
            ", provinceCode = " + provinceCode +
        "}";
    }
}
