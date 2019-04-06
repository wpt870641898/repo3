package com.shiro.test.pojo;

/**
 * Created by wang on 2019/3/24.
 */
public class Users {
    private int id;
    private String realName;
    private String email;
    private String password;
    private String status;

    public Users(int id, String realName,
                 String email, String password, String status) {
        this.id = id;
        this.realName = realName;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
