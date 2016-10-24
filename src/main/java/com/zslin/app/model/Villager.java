package com.zslin.app.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 村民
 * Created by 钟述林 393156105@qq.com on 2016/10/20 9:31.
 */
@Entity
@Table(name = "t_villager")
public class Villager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /** 家庭住址编码，由家庭住址生成的md5值 */
    @Column(name = "addr_code")
    private String addrCode;

    /** 所在队Id */
    @Column(name = "team_id")
    private Integer teamId;

    /** 所在队名称 */
    @Column(name = "team_name")
    private String teamName;

    /** 对应户Id */
    @Column(name = "family_id")
    private Integer familyId;

    private String name;

    private String identity;

    private String phone;

    private String sex;

    private String address;

    @Column(name = "create_date")
    private Date createDate;

    /** 民族 */
    private String nation;

    /** 民族代码 */
    @Column(name = "nation_code")
    private String nationCode;

    private String birth;

    /** 有效期 */
    @Column(name = "valid_date")
    private String validDate;

    /** 低保标记 */
    private Integer dbbj;

    /** 残疾标记 */
    private Integer cjbj;

    /** 上访人员标记 */
    private Integer sfbj;

    /** 吸毒人员标记 */
    private Integer xdbj;

    /** 五保标记 */
    private Integer wbbj;

    /** 独生子女标记 */
    private Integer dszlbj;

    /** 党员标记 */
    private Integer dybj;

    /** 贫困标记 */
    private Integer pkbj;

    /** 孤儿标记 */
    private Integer gebj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddrCode() {
        return addrCode;
    }

    public void setAddrCode(String addrCode) {
        this.addrCode = addrCode;
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

    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNationCode() {
        return nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public Integer getDbbj() {
        return dbbj;
    }

    public void setDbbj(Integer dbbj) {
        this.dbbj = dbbj;
    }

    public Integer getCjbj() {
        return cjbj;
    }

    public void setCjbj(Integer cjbj) {
        this.cjbj = cjbj;
    }

    public Integer getSfbj() {
        return sfbj;
    }

    public void setSfbj(Integer sfbj) {
        this.sfbj = sfbj;
    }

    public Integer getXdbj() {
        return xdbj;
    }

    public void setXdbj(Integer xdbj) {
        this.xdbj = xdbj;
    }

    public Integer getWbbj() {
        return wbbj;
    }

    public void setWbbj(Integer wbbj) {
        this.wbbj = wbbj;
    }

    public Integer getDszlbj() {
        return dszlbj;
    }

    public void setDszlbj(Integer dszlbj) {
        this.dszlbj = dszlbj;
    }

    public Integer getDybj() {
        return dybj;
    }

    public void setDybj(Integer dybj) {
        this.dybj = dybj;
    }

    public Integer getPkbj() {
        return pkbj;
    }

    public void setPkbj(Integer pkbj) {
        this.pkbj = pkbj;
    }

    public Integer getGebj() {
        return gebj;
    }

    public void setGebj(Integer gebj) {
        this.gebj = gebj;
    }
}
