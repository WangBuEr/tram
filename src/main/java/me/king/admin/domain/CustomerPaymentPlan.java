package me.king.admin.domain;

import java.util.Date;

public class CustomerPaymentPlan {
    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Feb 07 16:47:39 CST 2017
     */
    private Integer id;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Feb 07 16:47:39 CST 2017
     */
    private Integer customerId;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Feb 07 16:47:39 CST 2017
     */
    private Integer periods;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Feb 07 16:47:39 CST 2017
     */
    private Double amount;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Feb 07 16:47:39 CST 2017
     */
    private Date planPaymentDay;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Feb 07 16:47:39 CST 2017
     */
    private Date actualPaymentDay;

    /**
     * 是否已还款：0 未还款 1逾期中 2 已还款
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Feb 07 16:47:39 CST 2017
     */
    private Integer status;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Feb 07 16:47:39 CST 2017
     */
    private Integer paymentType;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Feb 07 16:47:39 CST 2017
     */
    private String manualPaymentUser;

    /**
     * 是否有逾期 0无 1有
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Feb 07 16:47:39 CST 2017
     */
    private Integer whetherOverdue;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Tue Feb 07 16:47:39 CST 2017
     */
    private Integer overdueReason;
    /**
     * 共逾期金额
     */
    private Integer sumOverdueDay;
    /**
     * 开始还款日期
     */
    private String beginPlanPaymentDay;
    /**
     * 结束还款日期
     */
    private String endPlanPaymentDay;
    
    private User manualUser;
    public CustomerPaymentPlan() {
		super();
	}

	public CustomerPaymentPlan(Integer customerId, Integer periods, Double amount, Date planPaymentDay) {
		super();
		this.customerId = customerId;
		this.periods = periods;
		this.amount = amount;
		this.planPaymentDay = planPaymentDay;
	}

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

    public Integer getPeriods() {
        return periods;
    }

    public void setPeriods(Integer periods) {
        this.periods = periods;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getPlanPaymentDay() {
        return planPaymentDay;
    }

    public void setPlanPaymentDay(Date planPaymentDay) {
        this.planPaymentDay = planPaymentDay;
    }

    public Date getActualPaymentDay() {
        return actualPaymentDay;
    }

    public void setActualPaymentDay(Date actualPaymentDay) {
        this.actualPaymentDay = actualPaymentDay;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getManualPaymentUser() {
        return manualPaymentUser;
    }

    public void setManualPaymentUser(String manualPaymentUser) {
        this.manualPaymentUser = manualPaymentUser;
    }

    public Integer getWhetherOverdue() {
        return whetherOverdue;
    }

    public void setWhetherOverdue(Integer whetherOverdue) {
        this.whetherOverdue = whetherOverdue;
    }

    public Integer getOverdueReason() {
        return overdueReason;
    }

    public void setOverdueReason(Integer overdueReason) {
        this.overdueReason = overdueReason;
    }

	public Integer getSumOverdueDay() {
		return sumOverdueDay;
	}

	public void setSumOverdueDay(Integer sumOverdueDay) {
		this.sumOverdueDay = sumOverdueDay;
	}

	public String getBeginPlanPaymentDay() {
		return beginPlanPaymentDay;
	}

	public void setBeginPlanPaymentDay(String beginPlanPaymentDay) {
		this.beginPlanPaymentDay = beginPlanPaymentDay;
	}

	public String getEndPlanPaymentDay() {
		return endPlanPaymentDay;
	}

	public void setEndPlanPaymentDay(String endPlanPaymentDay) {
		this.endPlanPaymentDay = endPlanPaymentDay;
	}

	public User getManualUser() {
		return manualUser;
	}

	public void setManualUser(User manualUser) {
		this.manualUser = manualUser;
	}
    
}