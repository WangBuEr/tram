package me.king.admin.domain;

import java.util.Date;
import java.util.List;

public class Customer extends BaseQuery {
    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    private Integer id;

    /**
     * 客户姓名
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    private String name;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    private String cardNumber;

    /**
     * 性别：0女1男
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    private Integer sex;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    private String phone;

    /**
     * 车型
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    private String carModels;

    /**
     * 车价
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    private Double carPrice;

    /**
     * 签约合同号
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    private String contractNumber;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    private String upingUserName;
    /**
     * 上报人
     */
    private User upingUser;
    /**
     * 上报时间
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    private Date upingTime;
    
    private String upingTimeStr;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    private String examineUserName;
    /**
     * 审批人
     */
    private User examineUser;
    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    private Date examineTime;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    private String releasePaymentsUserName;
    /**
     * 放款人
     */
    private User releasePaymentsUser;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    private Date releasePaymentsTime;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    private String releasePaymentsNumber;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    private Integer status;
    
    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    private Integer preStatus;
    
    
    private CustomerShare share;
    
    private List<CustomerEmergencyContact> emergencyContactList;
    
    private List<Image> imageList;
    
    private List<Image> contractImageList;
    
    private List<Video> contractVideoList;
    private Image idCardFaceImg;
    private Image idCardSideImg;
    private Image releasePaymentsImg;
    private CustomerLoan loan;
    private List<CustomerPaymentPlan> paymentPlanList;
    
    /**
     * 回款列表
     */
    private List<CustomerPaymentPlan> receivePaymentList;
    /**
     * 逾期列表
     */
    private List<CustomerPaymentPlan> overdubPaymentList;
    /**
     * 待还期数
     */
    private Integer remainingPeriod;
    /**
     * 已还款
     */
    private Double totalRepaymentAmount;
    /**
     * 待还金额
     */
    private Double totalSurplusPaymentAmount;
    /**
     * 当期需要还款
     */
    private Double currentRepayment;
    /**
     * 追回逾期总金额
     */
    private Double totalRecoveredAmount;
    /**
     * 待追回的逾期总金额
     */
    private double totalToBeRecoveredOverdueAmount;
    
    private Double loanAmount;
    private Integer stageNumber;
    
    private List<Integer> statusList;
    /**
     * 客户回款状态  0 预警回款   1当前回款  2逾期回款
     */
    private Integer receivePaymentsStatus;
    /**
     * 开始放款日期
     */
    private String beginReleasePaymentsDate;
    /**
     * 结束放款日期
     */
    private String endReleasePaymentsDate;
    //查询字段 end
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

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCarModels() {
        return carModels;
    }

    public void setCarModels(String carModels) {
        this.carModels = carModels;
    }

    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getUpingUserName() {
        return upingUserName;
    }

    public void setUpingUserName(String upingUserName) {
        this.upingUserName = upingUserName;
    }

    public Date getUpingTime() {
        return upingTime;
    }

    public void setUpingTime(Date upingTime) {
        this.upingTime = upingTime;
    }

    public String getExamineUserName() {
        return examineUserName;
    }

    public void setExamineUserName(String examineUserName) {
        this.examineUserName = examineUserName;
    }

    public Date getExamineTime() {
        return examineTime;
    }

    public void setExamineTime(Date examineTime) {
        this.examineTime = examineTime;
    }

    public String getReleasePaymentsUserName() {
        return releasePaymentsUserName;
    }

    public void setReleasePaymentsUserName(String releasePaymentsUserName) {
        this.releasePaymentsUserName = releasePaymentsUserName;
    }

    public Date getReleasePaymentsTime() {
        return releasePaymentsTime;
    }

    public void setReleasePaymentsTime(Date releasePaymentsTime) {
        this.releasePaymentsTime = releasePaymentsTime;
    }

    public String getReleasePaymentsNumber() {
        return releasePaymentsNumber;
    }

    public void setReleasePaymentsNumber(String releasePaymentsNumber) {
        this.releasePaymentsNumber = releasePaymentsNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public CustomerShare getShare() {
		return share;
	}

	public void setShare(CustomerShare share) {
		this.share = share;
	}
	
	

	public List<CustomerEmergencyContact> getEmergencyContactList() {
		return emergencyContactList;
	}

	public void setEmergencyContactList(List<CustomerEmergencyContact> emergencyContactList) {
		this.emergencyContactList = emergencyContactList;
	}
	
	
	public List<Image> getImageList() {
		return imageList;
	}

	public void setImageList(List<Image> imageList) {
		this.imageList = imageList;
	}
	
	
	public List<Image> getContractImageList() {
		return contractImageList;
	}

	public void setContractImageList(List<Image> contractImageList) {
		this.contractImageList = contractImageList;
	}

	
	
	
	public List<Video> getContractVideoList() {
		return contractVideoList;
	}

	public void setContractVideoList(List<Video> contractVideoList) {
		this.contractVideoList = contractVideoList;
	}

	public CustomerLoan getLoan() {
		return loan;
	}

	public void setLoan(CustomerLoan loan) {
		this.loan = loan;
	}

	public String getUpingTimeStr() {
		return upingTimeStr;
	}

	public void setUpingTimeStr(String upingTimeStr) {
		this.upingTimeStr = upingTimeStr;
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
	
	public Integer getPreStatus() {
		return preStatus;
	}

	public void setPreStatus(Integer preStatus) {
		this.preStatus = preStatus;
	}
	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Integer getStageNumber() {
		return stageNumber;
	}

	public void setStageNumber(Integer stageNumber) {
		this.stageNumber = stageNumber;
	}
	
	public List<Integer> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<Integer> statusList) {
		this.statusList = statusList;
	}
	
	
	public List<CustomerPaymentPlan> getPaymentPlanList() {
		return paymentPlanList;
	}

	public void setPaymentPlanList(List<CustomerPaymentPlan> paymentPlanList) {
		this.paymentPlanList = paymentPlanList;
	}
	
	public Integer getReceivePaymentsStatus() {
		return receivePaymentsStatus;
	}

	public void setReceivePaymentsStatus(Integer receivePaymentsStatus) {
		this.receivePaymentsStatus = receivePaymentsStatus;
	}

	public Integer getRemainingPeriod() {
		return remainingPeriod;
	}

	public void setRemainingPeriod(Integer remainingPeriod) {
		this.remainingPeriod = remainingPeriod;
	}

	
	public Double getCurrentRepayment() {
		return currentRepayment;
	}

	public void setCurrentRepayment(Double currentRepayment) {
		this.currentRepayment = currentRepayment;
	}
	
	public Image getReleasePaymentsImg() {
		return releasePaymentsImg;
	}

	public void setReleasePaymentsImg(Image releasePaymentsImg) {
		this.releasePaymentsImg = releasePaymentsImg;
	}
	
	public List<CustomerPaymentPlan> getReceivePaymentList() {
		return receivePaymentList;
	}

	public void setReceivePaymentList(List<CustomerPaymentPlan> receivePaymentList) {
		this.receivePaymentList = receivePaymentList;
	}

	public List<CustomerPaymentPlan> getOverdubPaymentList() {
		return overdubPaymentList;
	}

	public void setOverdubPaymentList(List<CustomerPaymentPlan> overdubPaymentList) {
		this.overdubPaymentList = overdubPaymentList;
	}

	public Double getTotalRepaymentAmount() {
		return totalRepaymentAmount;
	}

	public void setTotalRepaymentAmount(Double totalRepaymentAmount) {
		this.totalRepaymentAmount = totalRepaymentAmount;
	}

	public Double getTotalSurplusPaymentAmount() {
		return totalSurplusPaymentAmount;
	}

	public void setTotalSurplusPaymentAmount(Double totalSurplusPaymentAmount) {
		this.totalSurplusPaymentAmount = totalSurplusPaymentAmount;
	}
	public Double getTotalRecoveredAmount() {
		return totalRecoveredAmount;
	}

	public void setTotalRecoveredAmount(Double totalRecoveredAmount) {
		this.totalRecoveredAmount = totalRecoveredAmount;
	}

	public double getTotalToBeRecoveredOverdueAmount() {
		return totalToBeRecoveredOverdueAmount;
	}

	public void setTotalToBeRecoveredOverdueAmount(double totalToBeRecoveredOverdueAmount) {
		this.totalToBeRecoveredOverdueAmount = totalToBeRecoveredOverdueAmount;
	}
	
	public String getBeginReleasePaymentsDate() {
		return beginReleasePaymentsDate;
	}

	public void setBeginReleasePaymentsDate(String beginReleasePaymentsDate) {
		this.beginReleasePaymentsDate = beginReleasePaymentsDate;
	}

	public String getEndReleasePaymentsDate() {
		return endReleasePaymentsDate;
	}

	public void setEndReleasePaymentsDate(String endReleasePaymentsDate) {
		this.endReleasePaymentsDate = endReleasePaymentsDate;
	}
	
	public User getUpingUser() {
		return upingUser;
	}

	public void setUpingUser(User upingUser) {
		this.upingUser = upingUser;
	}

	public User getExamineUser() {
		return examineUser;
	}

	public void setExamineUser(User examineUser) {
		this.examineUser = examineUser;
	}

	public User getReleasePaymentsUser() {
		return releasePaymentsUser;
	}

	public void setReleasePaymentsUser(User releasePaymentsUser) {
		this.releasePaymentsUser = releasePaymentsUser;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", cardNumber=" + cardNumber + ", sex=" + sex + ", phone="
				+ phone + ", carModels=" + carModels + ", carPrice=" + carPrice + ", contractNumber=" + contractNumber
				+ ", upingUserName=" + upingUserName + ", upingTime=" + upingTime + ", upingTimeStr=" + upingTimeStr
				+ ", examineUserName=" + examineUserName + ", examineTime=" + examineTime + ", releasePaymentsUserName="
				+ releasePaymentsUserName + ", releasePaymentsTime=" + releasePaymentsTime + ", releasePaymentsNumber="
				+ releasePaymentsNumber + ", status=" + status + ", share=" + share + ", emergencyContactList="
				+ emergencyContactList + ", imageList=" + imageList + ", contractImageList=" + contractImageList
				+ ", contractVideoList=" + contractVideoList + ", idCardFaceImg=" + idCardFaceImg + ", idCardSideImg="
				+ idCardSideImg + ", loan=" + loan + ", draw=" + draw + ", start=" + start + ", length=" + length + "]";
	}
}