package me.king.admin.persistence;

import me.king.admin.domain.CustomerEmergencyContact;

public interface CustomerEmergencyContactMapper {
    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_emergency_contact
     *
     * @mbggenerated Mon Jan 16 13:47:29 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_emergency_contact
     *
     * @mbggenerated Mon Jan 16 13:47:29 CST 2017
     */
    int insert(CustomerEmergencyContact record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_emergency_contact
     *
     * @mbggenerated Mon Jan 16 13:47:29 CST 2017
     */
    int insertSelective(CustomerEmergencyContact record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_emergency_contact
     *
     * @mbggenerated Mon Jan 16 13:47:29 CST 2017
     */
    CustomerEmergencyContact selectByPrimaryKey(Integer id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_emergency_contact
     *
     * @mbggenerated Mon Jan 16 13:47:29 CST 2017
     */
    int updateByPrimaryKeySelective(CustomerEmergencyContact record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_emergency_contact
     *
     * @mbggenerated Mon Jan 16 13:47:29 CST 2017
     */
    int updateByPrimaryKey(CustomerEmergencyContact record);
    
    CustomerEmergencyContact selectByCustomerId(Integer customerId);
    
    void deleteByCustomerId(Integer customerId);
}