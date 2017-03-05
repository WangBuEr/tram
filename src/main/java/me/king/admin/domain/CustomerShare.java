package me.king.admin.domain;

public class CustomerShare {
    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 12:57:15 CST 2017
     */
    private Integer id;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 12:57:15 CST 2017
     */
    private String name;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 12:57:15 CST 2017
     */
    private String phone;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 12:57:15 CST 2017
     */
    private Integer relation;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 12:57:15 CST 2017
     */
    private Integer customerId;
    
    private Image idCardFaceImg;
    private Image idCardSideImg;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
	public Image getIdCardFaceImg() {
		return idCardFaceImg;
	}

	public void setIdCardFaceImg(Image idCardFaceImg) {
		this.idCardFaceImg = idCardFaceImg;
	}

	public Image getIdCardSideImg() {
		return idCardSideImg;
	}

	public void setIdCardSideImg(Image idCardSideImg) {
		this.idCardSideImg = idCardSideImg;
	}

	@Override
	public String toString() {
		return "CustomerShare [id=" + id + ", name=" + name + ", phone=" + phone + ", relation=" + relation
				+ ", customerId=" + customerId + ", idCardFaceImg=" + idCardFaceImg + ", idCardSideImg=" + idCardSideImg
				+ "]";
	}
}