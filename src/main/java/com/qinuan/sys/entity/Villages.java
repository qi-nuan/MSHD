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
public class Villages implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String name;

    private String streetCode;

    private String provinceCode;

    private String cityCode;

    private String areaCode;

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

    public String getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public String toString() {
        return "Villages{" +
            "code = " + code +
            ", name = " + name +
            ", streetCode = " + streetCode +
            ", provinceCode = " + provinceCode +
            ", cityCode = " + cityCode +
            ", areaCode = " + areaCode +
        "}";
    }
}
