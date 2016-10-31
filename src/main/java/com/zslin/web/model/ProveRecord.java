package com.zslin.web.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 证明电子台账
 * Created by 钟述林 393156105@qq.com on 2016/10/30 10:00.
 */
@Entity
@Table(name = "t_prove_record")
public class ProveRecord {

    /** 主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /** 证明Id */
    @Column(name = "prove_id")
    private Integer proveId;

    /** 证明名称 */
    @Column(name = "prove_name")
    private String proveName;

    /** 开证明日期，yyyy-MM-dd */
    @Column(name = "date_str")
    private String dateStr;

    @Column(name = "create_date")
    private Date createDate;

    /** 所在队Id */
    @Column(name = "team_id")
    private Integer teamId;

    /** 所在队名称 */
    @Column(name = "team_name")
    private String teamName;

    /** 所在家庭Id */
    @Column(name = "family_id")
    private Integer familyId;

    /** 所在家庭地址代码 */
    @Column(name = "addr_code")
    private String addrCode;

    /** 所属村民Id */
    @Column(name = "villager_id")
    private Integer VillagerId;

    /** 姓名 */
    private String name;

    /** 身份证号 */
    private String identity;

    /** 证明内容 */
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProveId() {
        return proveId;
    }

    public void setProveId(Integer proveId) {
        this.proveId = proveId;
    }

    public String getProveName() {
        return proveName;
    }

    public void setProveName(String proveName) {
        this.proveName = proveName;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public String getAddrCode() {
        return addrCode;
    }

    public void setAddrCode(String addrCode) {
        this.addrCode = addrCode;
    }

    public Integer getVillagerId() {
        return VillagerId;
    }

    public void setVillagerId(Integer villagerId) {
        VillagerId = villagerId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
