package com.BugManageSystem.Entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // 会在Spring运行时实例化成数据库中的一张同名的表
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private Integer identity;   //表示身份ID，0为普通用户，1为管理员


    protected User(){}

    public User(String username, String password, Integer identity){
        this.username=username;
        this.password=password;
        this.identity=identity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        // TODO:密码解密过程
        return password;
    }

    public void setPassword(String password) {
        // TODO:密码加密过程
        this.password = password;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString(){
        return String.format("User[id=%d, username=%s, password=%s, identity=%d]",id, username, password ,identity);
    }
}
