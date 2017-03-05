package me.king.admin.persistence;

import java.util.List;

import me.king.admin.domain.Customer;

public interface CustomerMapper {
    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    int insert(Customer record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    int insertSelective(Customer record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    Customer selectByPrimaryKey(Integer id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    int updateByPrimaryKeySelective(Customer record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    int updateByPrimaryKey(Customer record);
    
    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer
     *
     * @mbggenerated Mon Jan 16 11:48:46 CST 2017
     */
    Customer selectDetailsByPrimaryKey(Integer id);
    /**
     * 根据身份证号查询客户
     * @param cardNumber
     * @return
     */
    Customer queryByCardNumber(String cardNumber);
    
    List<Customer> selectSelective(Customer customer);
    
    int selectSelectiveCount(Customer customer);
    /**
     * 查询需要需要还款的客户
     * @param customer
     * @return
     */
    List<Customer> selectCurrentAccount(Customer customer);
}