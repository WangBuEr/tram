package me.king.admin.persistence;

import java.util.List;

import me.king.admin.domain.CustomerExamineComments;

public interface CustomerExamineCommentsMapper {
    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_examine_comments
     *
     * @mbggenerated Thu Jan 19 16:04:37 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_examine_comments
     *
     * @mbggenerated Thu Jan 19 16:04:37 CST 2017
     */
    int insert(CustomerExamineComments record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_examine_comments
     *
     * @mbggenerated Thu Jan 19 16:04:37 CST 2017
     */
    int insertSelective(CustomerExamineComments record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_examine_comments
     *
     * @mbggenerated Thu Jan 19 16:04:37 CST 2017
     */
    CustomerExamineComments selectByPrimaryKey(Integer id);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_examine_comments
     *
     * @mbggenerated Thu Jan 19 16:04:37 CST 2017
     */
    int updateByPrimaryKeySelective(CustomerExamineComments record);

    /**
     * 此方法是由MyBatis Generator自动生成不要修改。
     * 这个方法对应于数据库表。 customer_examine_comments
     *
     * @mbggenerated Thu Jan 19 16:04:37 CST 2017
     */
    int updateByPrimaryKey(CustomerExamineComments record);
    
    List<CustomerExamineComments> selectByCustomerId(Integer customerId);
}