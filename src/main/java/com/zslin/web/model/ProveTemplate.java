package com.zslin.web.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 证明模板
 * Created by 钟述林 393156105@qq.com on 2016/10/21 9:35.
 */
@Entity
@Table(name = "t_prove_template")
public class ProveTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /** 模板编号 */
    private String sn;

    /** 证明名称 */
    private String name;

    /** 创建日期 */
    @Column(name = "create_date")
    private Date createDate;

    /** 内容 */
    @Lob
    private String content;

    /** 落款 */
    private String signed;

    public String getSigned() {
        return signed;
    }

    public void setSigned(String signed) {
        this.signed = signed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
