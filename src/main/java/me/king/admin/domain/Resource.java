package me.king.admin.domain;

import java.util.Date;
import java.util.List;

public class Resource {
    /**
     * 主键
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Long id;

    /**
     * 资源名称
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private String name;

    /**
     * 资源路径
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private String url;

    /**
     * 打开方式 ajax,iframe
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private String openMode;

    /**
     * 资源介绍
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private String description;

    /**
     * 资源图标
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private String icon;

    /**
     * 父级资源id
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
     * 状态
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Byte status;

    /**
     * 资源类别
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Byte resourceType;

    /**
     * 创建时间
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Feb 13 15:57:53 CST 2017
     */
    private Date createTime;
    
    private List<Resource> subResList;
    private Resource parentResource;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOpenMode() {
        return openMode;
    }

    public void setOpenMode(String openMode) {
        this.openMode = openMode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getResourceType() {
        return resourceType;
    }

    public void setResourceType(Byte resourceType) {
        this.resourceType = resourceType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Resource> getSubResList() {
		return subResList;
	}

    public void setSubResList(List<Resource> subResList) {
		this.subResList = subResList;
	}

    public Resource getParentResource() {
		return parentResource;
	}

    public void setParentResource(Resource parentResource) {
		this.parentResource = parentResource;
	}
    
}