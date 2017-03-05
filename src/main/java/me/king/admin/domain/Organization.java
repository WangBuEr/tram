package me.king.admin.domain;

import java.util.Date;
import java.util.List;

public class Organization {
    /**
     * 主键id
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Long id;

    /**
     * 组织名
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private String name;

    /**
     * 地址
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private String address;

    /**
     * 编号
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private String code;

    /**
     * 图标
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private String icon;

    /**
     * 父级主键
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Long pid;

    /**
     * 排序
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Byte seq;

    /**
     * 创建时间
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Date createTime;
    /**
     * 子部门列表
     */
    private List<Organization> subOrgList;
    /**
     * 父组织
     */
    private Organization parentOrg;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Byte getSeq() {
        return seq;
    }

    public void setSeq(Byte seq) {
        this.seq = seq;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public List<Organization> getSubOrgList() {
		return subOrgList;
	}

	public void setSubOrgList(List<Organization> subOrgList) {
		this.subOrgList = subOrgList;
	}

	public Organization getParentOrg() {
		return parentOrg;
	}

	public void setParentOrg(Organization parentOrg) {
		this.parentOrg = parentOrg;
	}
    
}