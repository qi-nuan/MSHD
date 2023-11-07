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
public class Streets implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String name;

    private String areaCode;

    private String provinceCode;

    private String cityCode;

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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Override
    public String toString() {
        return "Streets{" +
            "code = " + code +
            ", name = " + name +
            ", areaCode = " + areaCode +
            ", provinceCode = " + provinceCode +
            ", cityCode = " + cityCode +
        "}";
    }
}
