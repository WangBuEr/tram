package me.king.admin.domain;

public class CustomerLoan {
    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Jan 17 11:29:18 CST 2017
     */
    private Integer id;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Jan 17 11:29:18 CST 2017
     */
    private Integer customerId;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Jan 17 11:29:18 CST 2017
     */
    private String serialNumber;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Jan 17 11:29:18 CST 2017
     */
    private Double amount;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Jan 17 11:29:18 CST 2017
     */
    private Integer stageNumber;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Jan 17 11:29:18 CST 2017
     */
    private Integer bankAccount;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Jan 17 11:29:18 CST 2017
     */
    private String bankBranch;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Jan 17 11:29:18 CST 2017
     */
    private String bankCardNumber;
    
    private Image bankCardImg;
    private Image holdBankCardImg;
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(Integer stageNumber) {
        this.stageNumber = stageNumber;
    }

    public Integer getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Integer bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

	public Image getBankCardImg() {
		return bankCardImg;
	}

	public void setBankCardImg(Image bankCardImg) {
		this.bankCardImg = bankCardImg;
	}

	public Image getHoldBankCardImg() {
		return holdBankCardImg;
	}

	public void setHoldBankCardImg(Image holdBankCardImg) {
		this.holdBankCardImg = holdBankCardImg;
	}

	@Override
	public String toString() {
		return "CustomerLoan [id=" + id + ", customerId=" + customerId + ", serialNumber=" + serialNumber + ", amount="
				+ amount + ", stageNumber=" + stageNumber + ", bankAccount=" + bankAccount + ", bankBranch="
				+ bankBranch + ", bankCardNumber=" + bankCardNumber + ", bankCardImg=" + bankCardImg
				+ ", holdBankCardImg=" + holdBankCardImg + "]";
	}
}