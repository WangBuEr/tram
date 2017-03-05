package me.king.admin.persistence;

import me.king.admin.domain.CustomerShare;

public interface CustomerShareMapper {
    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_share
     *
     * @mbggenerated Mon Jan 16 12:57:15 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_share
     *
     * @mbggenerated Mon Jan 16 12:57:15 CST 2017
     */
    int insert(CustomerShare record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_share
     *
     * @mbggenerated Mon Jan 16 12:57:15 CST 2017
     */
    int insertSelective(CustomerShare record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_share
     *
     * @mbggenerated Mon Jan 16 12:57:15 CST 2017
     */
    CustomerShare selectByPrimaryKey(Integer id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_share
     *
     * @mbggenerated Mon Jan 16 12:57:15 CST 2017
     */
    int updateByPrimaryKeySelective(CustomerShare record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_share
     *
     * @mbggenerated Mon Jan 16 12:57:15 CST 2017
     */
    int updateByPrimaryKey(CustomerShare record);
    
    
    CustomerShare selectByCustomerId(Integer customerId);
}