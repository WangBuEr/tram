package me.king.admin.domain;

import java.util.Date;

public class Video {
    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Jan 17 13:54:21 CST 2017
     */
    private Integer id;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Jan 17 13:54:21 CST 2017
     */
    private Integer customerId;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Jan 17 13:54:21 CST 2017
     */
    private String url;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Jan 17 13:54:21 CST 2017
     */
    private Integer type;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Jan 17 13:54:21 CST 2017
     */
    private String suffix;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Jan 17 13:54:21 CST 2017
     */
    private Date uploadTime;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Jan 17 13:54:21 CST 2017
     */
    private String uploadUser;
    
    private String fullUrl;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser;
    }

	public String getFullUrl() {
		return fullUrl;
	}

	public void setFullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", customerId=" + customerId + ", url=" + url + ", type=" + type + ", suffix="
				+ suffix + ", uploadTime=" + uploadTime + ", uploadUser=" + uploadUser + ", fullUrl=" + fullUrl + "]";
	}
    
}