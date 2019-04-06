package com.shiro.test.pojo;

/**
 * Created by wang on 2019/3/25.
 */
public class Role {
    private int id;
    private String name;
    private String remarke;
    private String status;

    public Role(int id, String name, String remarke, String status) {
        this.id = id;
        this.name = name;
        this.remarke = remarke;
        this.status = status;
    }

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarke() {
        return remarke;
    }

    public void setRemarke(String remarke) {
        this.remarke = remarke;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remarke='" + remarke + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
