package com.qinuan.sys.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author qinuan
 * @since 2023-11-06
 */
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private String role;

    private LocalDateTime regtime;

    private String location;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getRegtime() {
        return regtime;
    }

    public void setRegtime(LocalDateTime regtime) {
        this.regtime = regtime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Users{" +
            "username = " + username +
            ", password = " + password +
            ", role = " + role +
            ", regtime = " + regtime +
            ", location = " + location +
        "}";
    }
}
