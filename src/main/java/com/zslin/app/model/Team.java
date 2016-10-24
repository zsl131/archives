package com.zslin.app.model;

import javax.persistence.*;

/**
 * 队/组
 * Created by 钟述林 393156105@qq.com on 2016/10/20 8:50.
 */
@Entity
@Table(name = "t_team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /** 队名称 */
    private String name;

    /** 队长姓名 */
    @Column(name = "captain_name")
    private String captainName;

    /** 队长电话 */
    @Column(name = "captain_phone")
    private String captainPhone;

    /** 长队身份证号 */
    @Column(name = "captain_identity")
    private String captainIdentity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public String getCaptainPhone() {
        return captainPhone;
    }

    public void setCaptainPhone(String captainPhone) {
        this.captainPhone = captainPhone;
    }

    public String getCaptainIdentity() {
        return captainIdentity;
    }

    public void setCaptainIdentity(String captainIdentity) {
        this.captainIdentity = captainIdentity;
    }
}
