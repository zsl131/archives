package com.zslin.app.model;

import javax.persistence.*;

/**
 * 户
 * Created by 钟述林 393156105@qq.com on 2016/10/20 9:59.
 */
@Entity
@Table(name = "t_family")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /** 所在队Id */
    @Column(name = "team_Id")
    private Integer teamId;

    /** 所在队名称 */
    @Column(name = "team_name")
    private String teamName;

    /** 家庭住址代码，由家庭住址生成的Md5值 */
    @Column(name = "addr_code")
    private String addrCode;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getAddrCode() {
        return addrCode;
    }

    public void setAddrCode(String addrCode) {
        this.addrCode = addrCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
