package me.king.admin.persistence;

import me.king.admin.domain.CustomerLoan;

public interface CustomerLoanMapper {
    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_loan
     *
     * @mbggenerated Tue Jan 17 11:29:18 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_loan
     *
     * @mbggenerated Tue Jan 17 11:29:18 CST 2017
     */
    int insert(CustomerLoan record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_loan
     *
     * @mbggenerated Tue Jan 17 11:29:18 CST 2017
     */
    int insertSelective(CustomerLoan record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_loan
     *
     * @mbggenerated Tue Jan 17 11:29:18 CST 2017
     */
    CustomerLoan selectByPrimaryKey(Integer id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_loan
     *
     * @mbggenerated Tue Jan 17 11:29:18 CST 2017
     */
    int updateByPrimaryKeySelective(CustomerLoan record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_loan
     *
     * @mbggenerated Tue Jan 17 11:29:18 CST 2017
     */
    int updateByPrimaryKey(CustomerLoan record);
    
    CustomerLoan selectByCustomerId(Integer customerId);
    
    void deleteByCustomerId(Integer customerId);
}