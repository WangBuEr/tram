package me.king.admin.domain;

import java.util.Date;

public class CustomerExamineComments {
    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Thu Jan 19 16:04:37 CST 2017
     */
    private Integer id;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Thu Jan 19 16:04:37 CST 2017
     */
    private Integer customerId;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Thu Jan 19 16:04:37 CST 2017
     */
    private String examineComments;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Thu Jan 19 16:04:37 CST 2017
     */
    private Date examineTime;

    /**
     * 
     * 此字段是由MyBatis Generator自动生成，不要修改。
     *
     * @mbggenerated Thu Jan 19 16:04:37 CST 2017
     */
    private Integer agree;

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

    public String getExamineComments() {
        return examineComments;
    }

    public void setExamineComments(String examineComments) {
        this.examineComments = examineComments;
    }

    public Date getExamineTime() {
        return examineTime;
    }

    public void setExamineTime(Date examineTime) {
        this.examineTime = examineTime;
    }

    public Integer getAgree() {
        return agree;
    }

    public void setAgree(Integer agree) {
        this.agree = agree;
    }
}