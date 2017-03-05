package me.king.admin.domain;

public class CustomerEmergencyContact {
    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 13:47:29 CST 2017
     */
    private Integer id;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 13:47:29 CST 2017
     */
    private Integer customerId;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 13:47:29 CST 2017
     */
    private String name;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 13:47:29 CST 2017
     */
    private String phone;

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

	@Override
	public String toString() {
		return "CustomerEmergencyContact [id=" + id + ", customerId=" + customerId + ", name=" + name + ", phone="
				+ phone + "]";
	}
}